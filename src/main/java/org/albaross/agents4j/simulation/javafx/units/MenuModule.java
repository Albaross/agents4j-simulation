package org.albaross.agents4j.simulation.javafx.units;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuModule extends MenuBar {

	protected Map<String, Menu> menus = new LinkedHashMap<>();

	public MenuModule(String... keys) {
		Menu mn;
		for (String key : keys) {
			menus.put(key, mn = new Menu(key));
			this.getMenus().add(mn);
		}
	}

	public Menu getMenu(String key) {
		return menus.get(key);
	}

}
