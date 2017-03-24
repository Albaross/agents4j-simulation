package org.albaross.agents4j.simulation.javafx.units;

import org.albaross.agents4j.simulation.javafx.ViewModule;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ConsoleModule extends HBox implements ViewModule {

	protected TextArea console;

	public ConsoleModule() {
		console = new TextArea();
		console.setEditable(false);

		ScrollPane scrollPane = new ScrollPane(console);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);

		this.setPadding(new Insets(8));
		HBox.setHgrow(scrollPane, Priority.ALWAYS);
		this.getChildren().add(scrollPane);
	}

	public void print(String text) {
		console.appendText(text);
	}

	public void println(String line) {
		console.appendText(line + '\n');
	}

	public void clear() {
		console.clear();
	}

	@Override
	public String getTitle() {
		return "Console";
	}

	@Override
	public Node getDisplay() {
		return this;
	}

}
