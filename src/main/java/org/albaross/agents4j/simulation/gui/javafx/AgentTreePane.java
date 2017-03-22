package org.albaross.agents4j.simulation.gui.javafx;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AgentTreePane extends HBox implements ViewItem<Node> {

	public AgentTreePane() {
		TreeItem<String> root = new TreeItem<String>("Agents");
		root.setExpanded(true);
		root.getChildren().addAll(new TreeItem<String>("Item 1"), new TreeItem<String>("Item 2"),
				new TreeItem<String>("Item 3"));
		TreeView<String> treeView = new TreeView<String>(root);

		this.setPadding(new Insets(8));
		HBox.setHgrow(treeView, Priority.ALWAYS);
		this.getChildren().add(treeView);
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
