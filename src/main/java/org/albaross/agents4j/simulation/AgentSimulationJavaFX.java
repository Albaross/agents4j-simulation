package org.albaross.agents4j.simulation;

import org.albaross.agents4j.simulation.gui.javafx.SimulationPane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class AgentSimulationJavaFX extends Application {

	private ConfigurableApplicationContext springContext;
	private SimulationPane sim;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		this.springContext = SpringApplication.run(AgentSimulationJavaFX.class);
		this.sim = new SimulationPane();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Agents4J Simulation");
		Scene scene = new Scene(sim);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
