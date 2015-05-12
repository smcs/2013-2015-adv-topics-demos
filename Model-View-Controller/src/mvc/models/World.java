package mvc.models;

import java.util.*;

public class World {

	private Vector<Player> players;
	private Vector<Tool> tools;
	private int playerCount = 1;

	public World() {
		players = new Vector<Player>();
		tools = new Vector<Tool>();
	}

	public boolean addPlayer(Player p) {
		if (!players.contains(p)) {
			players.add(p);
			return true;
		}
		return false;
	}

	public Player getPlayer(int index) {
		if (index < players.size()) {
			return players.get(index);
		}
		return null;
	}

	public boolean validatePlayerCount(int count) {
		return count > 0;
	}

	public int setPlayerCount(int newCount) {
		int oldCount = playerCount;
		if (validatePlayerCount(newCount)) {
			playerCount = newCount;
			
			/* make sure that we have enough tools for all the players to pick 3 */
			if (tools.size() < playerCount * 3 + 1) {
				for (int i = tools.size(); i < playerCount * 3 + 1; i++) {
					addTool(new Tool("Tool " + (i + 1)));
				}
			}
		}
		return oldCount;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public Vector<Tool> availableTools() {
		return tools;
	}

	public boolean addTool(Tool tool) {
		if (!tools.contains(tool)) {
			tools.add(tool);
			return true;
		}
		return false;
	}

	public boolean removeTool(Tool tool) {
		if (tools.contains(tool)) {
			tools.removeElement(tool);
			return true;
		}
		return false;
	}
}
