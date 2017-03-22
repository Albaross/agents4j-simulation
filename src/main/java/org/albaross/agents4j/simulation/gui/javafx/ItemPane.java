package org.albaross.agents4j.simulation.gui.javafx;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class ItemPane extends VBox {

	public ItemPane() {
		AgentPane agent1 = new AgentPane("Agent1");
		AgentPane agent2 = new AgentPane("Agent2");
		AgentPane agent3 = new AgentPane("Agent3");
		setPadding(new Insets(10, 0, 10, 10));
		setSpacing(10);
		this.getChildren().addAll(agent1, agent2, agent3);
	}

}
