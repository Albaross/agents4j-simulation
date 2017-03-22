package org.albaross.agents4j.simulation.gui.javafx;

import java.util.Arrays;

import javafx.scene.layout.BorderPane;

public class SimulationPane extends BorderPane {

	private MenuPane menu;
	private ContentPane content;
	private ControlPane control;

	public SimulationPane() {
		this.setPrefSize(800, 600);

		menu = new MenuPane("File", "Help");
		this.setTop(menu);

		content = new ContentPane(Arrays.asList(new AgentTreePane()), Arrays.asList(new ConsolePane()));
		this.setCenter(content);

		control = new ControlPane("Step", "Run");
		this.setBottom(control);
	}

}
