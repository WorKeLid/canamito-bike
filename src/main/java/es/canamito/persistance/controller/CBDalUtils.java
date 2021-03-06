package es.canamito.persistance.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.persistance.model.CMenu;
import es.canamito.persistance.model.CProcess;
import es.canamito.persistance.model.CRol;
import es.canamito.persistance.model.CRolMenu;
import es.canamito.persistance.model.CUser;
import es.canamito.persistance.model.CUserRol;

/**
 * Clase de utilidades sobre el modelo de persistencia
 * 
 * @author wkl
 * @version 1.210603 - Implementación inicial
 */
public class CBDalUtils {

	private static final Logger log = LogManager.getLogger();

	/**
	 * Busca en la base de datos si el proceso solicitado existe
	 * 
	 * @param goingTo Nombre del proceso
	 * @return Nombre del proceso a instanciar o null si no existe
	 */
	public static CProcess getProcessFromMenu(HttpServletRequest request) {
		CProcess res = null;

		String goingTo = request.getRequestURI().substring(request.getContextPath().length()).replace("/app/", "");
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CMenu> cQuery = cBuilder.createQuery(CMenu.class);
			Root<CMenu> root = cQuery.from(CMenu.class);

			cQuery.select(root).where(cBuilder.isNotNull(root.get("CProcess")));

			TypedQuery<CMenu> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CMenu> lMenus = tQuery.getResultList();

			res = lMenus.stream().filter(m -> m.getPath().equals(goingTo)).findAny().orElse(null).getCProcess();

		} catch (Exception e) {
			log.debug("getProcessFromMenu: " + e.getClass() + ": " + e.getMessage());
		}
		return res;
	}

	/**
	 * @param request El request donde buscar al usuario
	 * @return El CUser de la sesión o null si no existe
	 */
	public static CUser getUserInSession(HttpServletRequest request) {
		CUser res = null;

		HttpSession httpSession = request.getSession();

		Object userObject = httpSession.getAttribute("user");

		if (userObject instanceof CUser) {
			CBDal cbd = new CBDal();
			res = cbd.getEntityManager().find(CUser.class, ((CUser) userObject).getCUserId());
			log.trace("session email: " + res.getEmail());
		} else {
			log.trace("anonymous session");
		}
		return res;
	}

	/**
	 * @param cUser El usuario o null si es anónimo
	 * @return Devuelve el conjunto de menús a los que el usuario tiene acceso
	 */
	public static Set<CMenu> getUserMenus(CUser cUser) {
		Set<CMenu> res = new HashSet<CMenu>();
		if (cUser != null) {
			List<CUserRol> lUserRoles = cUser.getCUserRols();

			if (lUserRoles.isEmpty()) {
				log.error("user " + cUser.getEmail() + " does not have defined roles");
			} else {
				for (CUserRol ur : lUserRoles) {
					List<CRolMenu> lRolMenus = ur.getCRol().getCRolMenus();
					if (lRolMenus.isEmpty()) {
						log.error("rol " + ur.getCRol().getName() + " does not have defined menus");
					} else {
						for (CRolMenu rm : lRolMenus) {
							res.add(rm.getCMenu());
						}
					}
				}
			}
		} else {
			CRol anonymousRole = CBDalUtils.getAnonymousRole();

			if (anonymousRole != null) {
				List<CRolMenu> lRolMenus = anonymousRole.getCRolMenus();
				if (lRolMenus.isEmpty()) {
					log.error("rol " + anonymousRole.getName() + " does not have defined menus");
				} else {
					for (CRolMenu rm : lRolMenus) {
						res.add(rm.getCMenu());
					}
				}
			} else {
				log.error("anonymous role not found");
			}
		}
		return res;
	}

	/**
	 * @return El rol considerado como anónimo o null si no existe
	 */
	public static CRol getAnonymousRole() {
		CRol res = null;
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CRol> cQuery = cBuilder.createQuery(CRol.class);

			TypedQuery<CRol> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CRol> lRoles = tQuery.getResultList();

			res = lRoles.stream().filter(r -> r.getName().equals("Anónimo")).findAny().orElse(null);

		} catch (Exception e) {
			log.error("getAnonymousRole: " + e.getClass() + ": " + e.getMessage());
		}
		return res;
	}

	/**
	 * Devuelve aquellos menús hijos del menú dado
	 * 
	 * @param menu  El menú padre donde buscar a los hijos
	 * @param cUser El usuario para determinar a que menús hijos tiene acceso
	 * @return Una lista de menús hijos del padre a los que el usuario tiene acceso
	 *         o null si no tiene
	 */
	public static List<CMenu> getChildren(CMenu menu, CUser cUser) {
		List<CMenu> res = new ArrayList<CMenu>();
		try {
			Set<CMenu> userMenus = getUserMenus(cUser);

			for (CMenu c : userMenus) {
				if (c.getCMenu() != null) {
					if (c.getCMenu().getCMenuId().equals(menu.getCMenuId())) {
						res.add(c);
					}
				}
			}
		} catch (Exception e) {
			log.error("getChildren: " + e.getClass() + ": " + e.getMessage());
		}
		return res;
	}
}
