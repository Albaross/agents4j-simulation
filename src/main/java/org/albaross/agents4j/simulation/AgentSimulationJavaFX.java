package org.albaross.agents4j.simulation;

import org.albaross.agents4j.simulation.javafx.SimulationPane;
import org.albaross.agents4j.simulation.javafx.container.TabModule;
import org.albaross.agents4j.simulation.javafx.units.ConsoleModule;
import org.albaross.agents4j.simulation.javafx.units.TreeModule;
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
		this.sim = new SimulationPane(new TreeModule<>("Agents"), new TabModule(new ConsoleModule()));
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Agents4J Simulation");
		stage.setScene(new Scene(sim));
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
