package mvc.models;

import java.util.*;

public class Player {

	protected Vector<Tool> rucksack;
	protected String name;
	
	public Player() {
		rucksack = new Vector<Tool>();
	}
	
	public boolean validateName(String name) {
		return name.length() > 0;
	}
	
	public String setName(String newName) {
		String oldName = name;
		if (validateName(newName)) {
			name = newName;
		}
		return oldName;
	}
	
	public String getName() {
		return name;
	}

	public boolean addTool(Tool tool) {
		if (!rucksack.contains(tool)) {
			rucksack.add(tool);
			return true;
		}
		return false;
	}
	
	public boolean removeTool(Tool tool) {
		if (rucksack.contains(tool)) {
			rucksack.remove(tool);
			return true;
		}
		return false;
	}
	
	public Vector<Tool> getRucksack() {
		return rucksack;
	}
}
