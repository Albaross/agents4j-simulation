package org.albaross.agents4j.simulation.gui.javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TreePane<T> extends HBox implements ViewItem<Node> {

	protected String title;
	protected List<ItemDoubleClickListener<T>> listeners;

	public TreePane(String title, TreeNode<T> tree) {
		this.title = Objects.requireNonNull(title, "title must not´be null");
		this.listeners = new ArrayList<>();

		TreeItem<T> root = new TreeItem<>(tree.getValue());
		root.setExpanded(true);
		root.getChildren().addAll(new TreeItem<String>("Item 1"), new TreeItem<String>("Item 2"),
				new TreeItem<String>("Item 3"));
		TreeView<String> treeView = new TreeView<String>(root);

		this.setPadding(new Insets(8));
		HBox.setHgrow(treeView, Priority.ALWAYS);
		this.getChildren().add(treeView);
		treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			if (event.getClickCount() < 2)
				return;

			System.out.println("doubleclicked");
			TreeView source = (TreeView) event.getSource();
			MultipleSelectionModel<TreeItem<String>> tree = source.getSelectionModel();
			TreeItem<String> selected = tree.getSelectedItem();
			System.out.println(selected.getValue());
		});
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

	@Override
	public String getTitle() {
		return "Agents";
	}

	@Override
	public Node getDisplay() {
		return this;
	}

}
