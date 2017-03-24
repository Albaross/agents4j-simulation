package org.albaross.agents4j.simulation.javafx;

import java.util.Arrays;
import java.util.List;

import org.albaross.agents4j.simulation.javafx.units.ControlModule;
import org.albaross.agents4j.simulation.javafx.units.MenuModule;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

public class SimulationPane extends BorderPane {

	protected MenuModule menu;
	protected SplitPane content;
	protected ControlModule control;

	public SimulationPane(ViewModule... items) {
		this(Arrays.asList(items));
	}

	public SimulationPane(List<ViewModule> items) {
		this.setPrefSize(800, 600);

		menu = new MenuModule("File", "Help");
		this.setTop(menu);

		content = new SplitPane();
		for (ViewModule it : items) {
			content.getItems().add(it.getDisplay());
		}
		content.setDividerPositions(0.25);

		this.setCenter(content);

		control = new ControlModule("Step", "Run");
		this.setBottom(control);
	}

	public MenuModule getMenu() {
		return menu;
	}

	public SplitPane getContent() {
		return content;
	}

	public ControlModule getControl() {
		return control;
	}

}
