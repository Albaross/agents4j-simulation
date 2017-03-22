package org.albaross.agents4j.simulation.gui.javafx;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AgentPane extends VBox {

	protected Label lbName;
	
	public AgentPane(String name) {
		lbName = new Label(name);
		lbName.setStyle("-fx-background-color: #6cB259; -fx-font");
		this.getChildren().add(lbName);
	}
	
}
