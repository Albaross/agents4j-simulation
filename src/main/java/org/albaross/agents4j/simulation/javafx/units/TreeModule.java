package org.albaross.agents4j.simulation.javafx.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.albaross.agents4j.simulation.javafx.ViewModule;
import org.albaross.agents4j.simulation.javafx.handler.ItemDoubleClickHandler;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TreeModule<T> extends HBox implements ViewModule {

	protected String title;
	protected TreeView<T> tree;
	protected List<ItemDoubleClickHandler<T>> listeners;

	@SuppressWarnings("unchecked")
	public TreeModule(String title) {
		this.title = Objects.requireNonNull(title, "title must not´be null");
		this.listeners = new ArrayList<>();
		this.tree = new TreeView<>();
		this.tree.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			if (event.getClickCount() < 2)
				return;

			T value = ((TreeItem<T>) ((TreeView<T>) event.getSource()).getSelectionModel().getSelectedItem())
					.getValue();

			for (ItemDoubleClickHandler<T> l : this.listeners) {
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

	public void addListener(ItemDoubleClickHandler<T> listener) {
		this.listeners.add(listener);
	}

	public void removeListener(ItemDoubleClickHandler<T> listener) {
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
