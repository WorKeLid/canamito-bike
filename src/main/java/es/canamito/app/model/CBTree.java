package es.canamito.app.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase de utilidad para almacenar entidades en árbol
 * 
 * @author wkl
 * @version 1.210506 - Implementación inicial
 * @param <T> El tipo de entidad que el árbol va a contener
 */
public class CBTree<T extends Comparable<T>> implements Comparable<CBTree<T>> {

	private T node;
	private CBTree<T> parent;
	private List<CBTree<T>> children;

	public CBTree(T node) {
		this.node = node;
		this.children = new LinkedList<CBTree<T>>();
	}

	public CBTree<T> addChild(CBTree<T> child) {
		child.parent = this;
		this.children.add(child);
		return child;
	}

	public T getNode() {
		return this.node;
	}

	public CBTree<T> getParent() {
		return this.parent;
	}

	public List<CBTree<T>> getChildren() {
		return this.children;
	}

	/**
	 * El orden natural de los nodos dependerá del tipo que sea (ej. CMenu se ordena
	 * por nombre alfabéticamente)
	 */
	public int compareTo(CBTree<T> node) {
		return this.getNode().compareTo(node.getNode());
	}
}
