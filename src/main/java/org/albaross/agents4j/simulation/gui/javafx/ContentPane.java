package org.albaross.agents4j.simulation.gui.javafx;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TitledPane;

public class ContentPane extends SplitPane {

	protected Accordion left;
	protected TabPane right;

	public ContentPane(List<ViewItem<Node>> elements, List<ViewItem<Node>> outputs) {
		this.setDividerPositions(0.25);

		left = new Accordion();

		TitledPane tp;
		for (ViewItem<Node> e : elements) {
			left.getPanes().add(tp = new TitledPane(e.getTitle(), e.getDisplay()));
			left.setExpandedPane(tp);
		}

		right = new TabPane();
		right.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		for (ViewItem<Node> o : outputs) {
			right.getTabs().add(new Tab(o.getTitle(), o.getDisplay()));
		}

		this.getItems().addAll(left, right);
	}

}
