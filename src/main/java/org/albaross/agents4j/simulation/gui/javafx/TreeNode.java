package org.albaross.agents4j.simulation.gui.javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode<T> {

	protected T value;
	protected List<TreeNode<T>> children = new ArrayList<>();

	public TreeNode(T value, TreeNode<T>... children) {
		this.value = Objects.requireNonNull(value, "value must not be null");
		for (TreeNode<T> n : children)
			this.children.add(n);
	}

	public T getValue() {
		return value;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

}
