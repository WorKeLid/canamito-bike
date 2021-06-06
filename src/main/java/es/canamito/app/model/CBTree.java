package es.canamito.app.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase de utilidad para almacenar objectos en forma de árbol
 * 
 * @author wkl
 * @version 1.210506 - Implementación inicial
 * @param <T> El tipo de objecto que el árbol va a contener
 */
public class CBTree<T> {

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
}
