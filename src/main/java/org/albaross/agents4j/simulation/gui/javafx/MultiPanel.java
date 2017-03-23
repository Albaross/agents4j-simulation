package org.albaross.agents4j.simulation.gui.javafx;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

public class MultiPanel extends Accordion implements ViewItem {

	public MultiPanel(ViewItem... items) {
		this(Arrays.asList(items));
	}

	public MultiPanel(List<ViewItem> items) {
		TitledPane tp;
		for (ViewItem it : items) {
			this.getPanes().add(tp = new TitledPane(it.getTitle(), it.getDisplay()));
			this.setExpandedPane(tp);
		}
	}

	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public Node getDisplay() {
		return this;
	}

}
