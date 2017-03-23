package org.albaross.agents4j.simulation.gui.javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TreePanel<T> extends HBox implements ViewItem {

	protected String title;
	protected TreeView<T> tree;
	protected List<ItemDoubleClickListener<T>> listeners;

	@SuppressWarnings("unchecked")
	public TreePanel(String title) {
		this.title = Objects.requireNonNull(title, "title must not´be null");
		this.listeners = new ArrayList<>();
		this.tree = new TreeView<>();
		this.tree.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			if (event.getClickCount() < 2)
				return;

			T value = ((TreeItem<T>) ((TreeView<T>) event.getSource()).getSelectionModel().getSelectedItem())
					.getValue();

			for (ItemDoubleClickListener<T> l : this.listeners) {
				l.handleDoubleClick(value);
			}
		});

		this.setPadding(new Insets(8));
		HBox.setHgrow(tree, Priority.ALWAYS);
		this.getChildren().add(tree);
	}

	@SuppressWarnings("unchecked")
	public static <T> TreeItem<T> node(T value, TreeItem<T>... children) {
		TreeItem<T> item = new TreeItem<T>(value);
		item.getChildren().addAll(children);
		return item;
	}

	public void addListener(ItemDoubleClickListener<T> listener) {
		this.listeners.add(listener);
	}

	public void removeListener(ItemDoubleClickListener<T> listener) {
		this.listeners.remove(listener);
	}

	public void removeListener(int index) {
		this.listeners.remove(index);
	}

	public TreeView<T> getTree() {
		return tree;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Node getDisplay() {
		return this;
	}

}
