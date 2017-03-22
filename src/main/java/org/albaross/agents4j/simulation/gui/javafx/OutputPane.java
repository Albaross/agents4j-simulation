package org.albaross.agents4j.simulation.gui.javafx;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class OutputPane extends VBox {

	protected TextArea tConsole;

	public OutputPane() {
		tConsole = new TextArea();
		tConsole.setWrapText(true);
		setPadding(new Insets(10));
		this.getChildren().add(tConsole);
	}

}
