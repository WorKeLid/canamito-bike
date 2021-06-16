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

	private String inputName;

	private Object value;

	public CBAttribute(String inputType, String inputName, Object value) {
		setInputType(inputType);
		this.inputName = inputName;
		this.value = value;
	}

	private void setInputType(String inputType) {
		this.inputType = InputType.valueOf(inputType);
	}

	public InputType getInputType() {
		return this.inputType;
	}

	public String getInputName() {
		return this.inputName;
	}

	public Object getValue() {
		return this.value;
	}

}
