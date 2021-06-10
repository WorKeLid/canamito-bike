package es.canamito.app.model.process;

import java.util.Collections;
import java.util.List;

import es.canamito.persistance.model.CColumn;
import es.canamito.persistance.model.CWindow;
import es.canamito.persistance.model.CWindowTable;

/**
 * Implementacion padre de procesos de tipo ventana
 * 
 * @author wkl
 * @version 1.210609 - Implementación inicial
 */
public class CBWindowImpl extends CBProcessImpl implements CBProcess {

	public CBWindowImpl() {
		super();
	}

	public void execute() throws Exception {
		// TODO: Implementacion
		CWindow cWindow = getCProcess().getCWindow();

		if (cWindow != null) {
			List<CWindowTable> lWindowTables = cWindow.getCWindowTables();
			Collections.sort(lWindowTables);

			for (CWindowTable cwt : lWindowTables) {
				log.debug("table " + cwt.getCTable().getName());
				for (CColumn cc : cwt.getCTable().getCColumns()) {
					log.debug("-column " + cc.getName());
				}
			}
			getRequest().getRequestDispatcher(getProcessDefaultView()).forward(getRequest(), getResponse());
		} else {
			throw new Exception("process " + getCProcess().getProcessPath() + " does not have a defined window");
		}
	}
}
