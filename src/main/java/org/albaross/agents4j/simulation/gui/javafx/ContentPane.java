package org.albaross.agents4j.simulation.gui.javafx;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class ContentPane extends SplitPane {

	protected TabPane left;
	protected TabPane right;

	public ContentPane(List<ItemView<Node>> items, List<OutputView<Node>> outputs) {
		this.setDividerPositions(0.25);

		left = new TabPane();
		left.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		for (ItemView<Node> i : items) {
			left.getTabs().add(new Tab(i.getCaption(), i.getView()));
		}

		right = new TabPane();
		right.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		for (OutputView<Node> o : outputs) {
			right.getTabs().add(new Tab(o.getCaption(), o.getView()));
		}

		this.getItems().addAll(left, right);
	}

}
