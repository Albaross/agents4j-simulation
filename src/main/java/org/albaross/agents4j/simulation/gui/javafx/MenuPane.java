package org.albaross.agents4j.simulation.gui.javafx;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuPane extends MenuBar {

	protected Map<String, Menu> menus = new LinkedHashMap<>();

	public MenuPane(String... keys) {
		Menu mn;
		for (String key : keys) {
			mn = new Menu(key);
			menus.put(key, mn);
			this.getMenus().add(mn);
		}
	}

	public Menu getMenu(String key) {
		return menus.get(key);
	}

}
