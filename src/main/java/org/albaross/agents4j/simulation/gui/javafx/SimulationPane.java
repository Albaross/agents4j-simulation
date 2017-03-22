package org.albaross.agents4j.simulation.gui.javafx;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class SimulationPane extends GridPane {

	private ControlPane control;
	private ItemPane items;
	private OutputPane output;

	public SimulationPane() {
		this.setPrefSize(800, 600);
		this.setStyle("-fx-background-color: #575B5E;");
		control = new ControlPane();
		this.add(control, 0, 0, 2, 1);
		setHgrow(control, Priority.ALWAYS);
		items = new ItemPane();
		this.add(items, 0, 1);
		setVgrow(items, Priority.ALWAYS);
		this.output = new OutputPane();
		this.add(output, 1, 1);
		setHgrow(output, Priority.ALWAYS);
		setVgrow(output, Priority.ALWAYS);
	}

}
