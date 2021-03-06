package es.canamito.app.controller.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.app.model.CBTree;
import es.canamito.persistance.controller.CBDalUtils;
import es.canamito.persistance.model.CMenu;
import es.canamito.persistance.model.CUser;

/**
 * Etiqueta encargada de mostrar en la barra de navegación todos los procesos,
 * ventanas e informes a los que el usuario tiene acceso. Si no hay usuario en
 * sesión, se muestran solo los procesos asociados al rol Anónimo.
 * 
 * @author wkl
 * @version 1.210617 - Implementación y documentación inicial
 */
public class CBTDrawMenuItems extends TagSupport implements TryCatchFinally {

	private static final Logger log = LogManager.getLogger();
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		int res = EVAL_BODY_INCLUDE;

		try {
			CUser user = CBDalUtils.getUserInSession((HttpServletRequest) pageContext.getRequest());
			Set<CMenu> allMenus = CBDalUtils.getUserMenus(user);

			List<CBTree<CMenu>> tree = getCBTree(allMenus, user);

			drawTree(tree);

		} catch (Exception e) {
			log.error("doStartTag: " + e.getClass() + ": " + e.getMessage());
			res = SKIP_BODY;
		}
		return res;
	}

	public int doAfterBody() {
		return 0;
	}

	public int doEndTag() {
		return 0;
	}

	public void doCatch(Throwable arg0) throws Throwable {
	}

	public void doFinally() {
	}

	/**
	 * Construye una lista de árboles de procesos, cada árbol representa un tipo de
	 * proceso (proceso, ventana, informe) y dentro de cada árbol se encuentran los
	 * procesos de ese tipo
	 * 
	 * @param allMenus Todos los menus a los que el usuario tiene acceso
	 * @return Una lista de árboles de procesos
	 */
	private List<CBTree<CMenu>> getCBTree(Set<CMenu> allMenus, CUser cUser) {
		List<CBTree<CMenu>> res = new ArrayList<CBTree<CMenu>>();

		// Son menús raíz aquellos que no tienen padres
		List<CMenu> rootMenus = allMenus.stream().filter(m -> m.getCMenu() == null).collect(Collectors.toList());

		if (rootMenus.isEmpty()) {
			log.error("getCBTree: user does not have root menus defined");
		} else {
			for (CMenu r : rootMenus) {
				CBTree<CMenu> root = new CBTree<CMenu>(r);
				constructRoot(root, cUser);
				res.add(root);
			}
		}
		Collections.sort(res);
		return res;
	}

	/**
	 * Función recursiva para poblar un árbol de procesos
	 * 
	 * @param root     El nodo raíz que contiene todos los procesos hijos
	 * @param allMenus Todos los nodos a los que el usuario tiene acceso
	 */
	private void constructRoot(CBTree<CMenu> root, CUser cUser) {
		List<CMenu> lchildren = CBDalUtils.getChildren(root.getNode(), cUser);
		Collections.sort(lchildren);
		for (CMenu c : lchildren) {
			CBTree<CMenu> child = new CBTree<CMenu>(c);
			root.addChild(child);
			constructRoot(child, cUser);
		}
	}

	/**
	 * Dibuja en la cabecera Header.jsp los menús disponibles del usuario utilizando
	 * Bootstrap 5
	 * 
	 * @param tree Listado de árboles de procesos a dibujar
	 */
	private void drawTree(List<CBTree<CMenu>> treeList) throws IOException {
		JspWriter out = pageContext.getOut();
		for (CBTree<CMenu> root : treeList) {
			if (root.getChildren().isEmpty()) {
				log.info("drawTree: root " + root.getNode().getName() + " is empty");
			} else {
				out.println(
						"<li class=\"nav-item dropdown\"><a class=\"nav-link dropdown-toggle\" href=\"\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">"
								+ root.getNode().getName()
								+ "</a><ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
				drawRootChildren(out, root);
				out.println("</ul></li>");
			}
		}
	}

	/**
	 * Dibuja en la barra de navegación los procesos dentro de sus respectivos menús
	 * 
	 * @param out
	 * @param root El menú del que coger los procesos a dibujar
	 * @throws IOException
	 */
	private void drawRootChildren(JspWriter out, CBTree<CMenu> root) throws IOException {
		for (CBTree<CMenu> m : root.getChildren()) {

			if (m.getChildren().isEmpty()) {
				String url = ((HttpServletRequest) pageContext.getRequest()).getContextPath() + "/app/"
						+ m.getNode().getPath();
				out.println("<li class=\"nav-item\"><a class=\"dropdown-item\" href=\"" + url + "\">"
						+ m.getNode().getName() + "</a></li>");
			} else {
				out.println(
						"<li class=\"dropdown-submenu\"><a class=\"dropdown-item dropdown-toggle\" href=\"\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">"
								+ m.getNode().getName()
								+ "</a><ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
				drawRootChildren(out, m);
				out.println("</ul></li>");
			}
		}
	}
}
