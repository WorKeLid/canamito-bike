package es.canamito.app.model;

/**
 * <div>Contenedor con mensajes para el usuario.</div> <div>Existen dos
 * constructores, uno para mensajes informativos sobre la operación realizada y
 * otro para mostrar excepciones</div>
 * 
 * @author wkl
 * @version 1.210601 - Implementación y documentación inicial
 */
public class CBMessage {

	enum Type {
		SUCCSESS, INFO, WARNING, ERROR
	}

	private Type type;
	private String title, description;
	private Exception exception;

	/**
	 * <div>Instancia un mensaje informativo sobre la operación
	 * realizada.</div><div>El tipo determina como se muestra el mensaje en la
	 * aplicación, el título y la descripción contiene la información del
	 * mensaje</div>
	 * 
	 * @param type        Existen cuatro tipos {SUCCSESS, INFO, WARNING, ERROR}
	 * @param title       Título del mensaje
	 * @param description Descripción del mensaje
	 */
	public CBMessage(String type, String title, String description) {
		setType(type);
		setTitle(title);
		setDescription(description);
	}

	/**
	 * <div>Instancia una excepción como un mensaje</div>
	 * 
	 * @param exception La excepción capturada
	 */
	public CBMessage(Exception exception) {
		setType("ERROR");
		setTitle(exception.getClass().getName());
		setDescription(exception.getMessage());
		setException(exception);
	}

	private void setType(String type) {
		this.type = Type.valueOf(type);
	}

	private void setTitle(String title) {
		this.title = title;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setException(Exception exception) {
		this.exception = exception;
	}

	public String getType() {
		return this.type.toString();
	}

	/**
	 * @return La cabecera del mensaje
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return La descripción del mensaje
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return La excepción capturada o null si no se ha lanzado una
	 */
	public Exception getException() {
		return this.exception;
	}
}
