package org.albaross.agents4j.simulation.javafx.container;

import java.util.Arrays;
import java.util.List;

import org.albaross.agents4j.simulation.javafx.ViewModule;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabModule extends TabPane implements ViewModule {

	public TabModule(ViewModule... items) {
		this(Arrays.asList(items));
	}

	public TabModule(List<ViewModule> items) {
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		for (ViewModule it : items) {
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
