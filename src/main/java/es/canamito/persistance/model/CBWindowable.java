package es.canamito.persistance.model;

import java.util.List;

import es.canamito.app.model.CBAttribute;

/**
 * Aquellas entidades del modelo de persistencia que implementen esta interfaz
 * pueden mostrarse en procesos de tipo ventana
 * 
 * @author wkl
 * @version 1.210618 - Implementación y documentación inicial
 */
public interface CBWindowable {

	/**
	 * Devuelve el atributo que contiene el id de la entidad, este id es el que
	 * determina cuál es el registro en la base de datos
	 * 
	 * @return El CBAttribute que contiene el id del registro
	 */
	public CBAttribute getId();

	/**
	 * Devuelve el atributo considerado como identificador, este es el atributo que
	 * aparecerá para representar relaciones con otras entidades del modelo de
	 * persistencia
	 * 
	 * @return El CBAttribute considerado como identificador
	 */
	public CBAttribute getIdentifier();

	/**
	 * Devuelve una lista de atributos de la entidad. Un atributo contiene una
	 * propiedad de la entidad además de información extra usada por los procesos
	 * ventana
	 * 
	 * @return Una lista de los CBAttribute de la entidad
	 */
	public List<CBAttribute> getAttributes();
}
