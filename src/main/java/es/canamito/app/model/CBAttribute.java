package es.canamito.app.model;

import es.canamito.persistance.model.CBWindowable;

/**
 * Clase para definir los atributos de una entidad del modelo de persistencia.
 * Un atributo es una representación visual de las propiedades de la entidad. Es
 * usado por los procesos de tipo ventana para representar las entidades en la
 * vista.
 * 
 * @author wkl
 * @version 1.210618 - Implementación y documentación inicial
 */
public class CBAttribute {

	public enum HTMLInputType {
		text, number, email, password, id, selector, checkbox
	}

	private HTMLInputType htmlInputType;

	private String inputName;

	private Object value;

	private CBWindowable cbWindowable;

	/**
	 * Construye un atributo para una propiedad de una entidad
	 * 
	 * @param inputType El tipo de input en la vista {text, number, email, password,
	 *                  id, selector}
	 * @param inputName El name que adquiere la propiedad en el formulario
	 * @param value     La propiedad en si
	 */
	public CBAttribute(String inputType, String inputName, Object value, CBWindowable cbWindowable) {
		setHTMLInputType(inputType);
		this.inputName = inputName;
		this.value = value;
		this.cbWindowable = cbWindowable;
	}

	private void setHTMLInputType(String inputType) {
		this.htmlInputType = HTMLInputType.valueOf(inputType);
	}

	/**
	 * @return El tipo de input que es {text, number, email, password, id, selector}
	 */
	public HTMLInputType getHTMLInputType() {
		return this.htmlInputType;
	}

	/**
	 * @return El valor del atributo name en el formulario
	 */
	public String getInputName() {
		return this.inputName;
	}

	/**
	 * @return La propiedad de la entidad
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * @return La entidad ventanable al que este atributo pertenece
	 */
	public CBWindowable getCBWindowable() {
		return this.cbWindowable;
	}
}
