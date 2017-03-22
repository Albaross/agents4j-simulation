package org.albaross.agents4j.simulation.gui.javafx;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPane extends HBox {

	protected Button btStep;
	protected Button btRun;

	public ControlPane() {
		this.setStyle("-fx-background-color: #888C8F;");
		btStep = new Button("Step");
		btRun = new Button("Run");
		this.getChildren().addAll(btStep, btRun);
	}

}
