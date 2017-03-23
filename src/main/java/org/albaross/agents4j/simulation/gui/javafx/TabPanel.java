package org.albaross.agents4j.simulation.gui.javafx;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPanel extends TabPane implements ViewItem {

	public TabPanel(ViewItem... items) {
		this(Arrays.asList(items));
	}

	public TabPanel(List<ViewItem> items) {
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		for (ViewItem it : items) {
			this.getTabs().add(new Tab(it.getTitle(), it.getDisplay()));
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
