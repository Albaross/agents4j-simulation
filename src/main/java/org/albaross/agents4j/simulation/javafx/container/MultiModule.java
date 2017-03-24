package org.albaross.agents4j.simulation.javafx.container;

import java.util.Arrays;
import java.util.List;

import org.albaross.agents4j.simulation.javafx.ViewModule;

import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

public class MultiModule extends Accordion implements ViewModule {

	public MultiModule(ViewModule... items) {
		this(Arrays.asList(items));
	}

	public MultiModule(List<ViewModule> items) {
		TitledPane tp;
		for (ViewModule it : items) {
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
