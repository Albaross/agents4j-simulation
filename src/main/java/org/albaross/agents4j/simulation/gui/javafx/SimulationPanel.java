package org.albaross.agents4j.simulation.gui.javafx;

import java.util.Arrays;
import java.util.List;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

public class SimulationPanel extends BorderPane {

	protected MenuPanel menu;
	protected SplitPane content;
	protected ControlPanel control;

	public SimulationPanel(ViewItem... items) {
		this(Arrays.asList(items));
	}

	public SimulationPanel(List<ViewItem> items) {
		this.setPrefSize(800, 600);

		menu = new MenuPanel("File", "Help");
		this.setTop(menu);

		content = new SplitPane();
		for (ViewItem it : items) {
			content.getItems().add(it.getDisplay());
		}
		content.setDividerPositions(0.25);

		this.setCenter(content);

		control = new ControlPanel("Step", "Run");
		this.setBottom(control);
	}

	public MenuPanel getMenu() {
		return menu;
	}

	public SplitPane getContent() {
		return content;
	}

	public ControlPanel getControl() {
		return control;
	}

}
