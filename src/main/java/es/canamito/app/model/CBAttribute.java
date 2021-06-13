package es.canamito.app.model;

/**
 * TODO: Documentacion
 * 
 * @author wkl
 *
 */
public class CBAttribute {

	public enum InputType {
		text, number, email, password, id
	}

	private InputType inputType;
	private Class<?> javaType;
	private Object value;

	public CBAttribute(String inputType, Class<?> javaType, Object value) {
		setInputType(inputType);
		this.javaType = javaType;
		this.value = value;
	}

	private void setInputType(String inputType) {
		this.inputType = InputType.valueOf(inputType);
	}

	public InputType getInputType() {
		return this.inputType;
	}

	public Class<?> getJavaType() {
		return this.javaType;
	}

	public Object getValue() {
		return this.value;
	}

}
