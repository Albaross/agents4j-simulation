package org.albaross.agents4j.simulation.gui.javafx;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPane extends HBox {

	protected Map<String, Button> buttons = new LinkedHashMap<>();

	public ControlPane(String... keys) {
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setSpacing(8);
		this.setPadding(new Insets(8));

		Button bt;
		for (String key : keys) {
			bt = new Button(key);
			bt.setPrefWidth(100);
			buttons.put(key, bt);
			this.getChildren().add(bt);
		}
	}

	public Button getButton(String key) {
		return buttons.get(key);
	}

}
