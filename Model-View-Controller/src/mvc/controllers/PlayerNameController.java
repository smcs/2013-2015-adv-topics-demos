package mvc.controllers;

import java.awt.event.*;

import javax.swing.*;

import mvc.models.*;
import mvc.views.*;

public class PlayerNameController implements ActionListener {
	private World world;
	private Player player;
	private JFrame home;
	private JTextField playerName;
	private static int nextPlayerNumber = 1;
	private int playerNumber;

	public PlayerNameController(World world, JFrame home, JTextField playerName) {
		this.world = world;
		this.home = home;
		this.playerName = playerName;

		playerNumber = nextPlayerNumber++;
		player = new Player();
		this.world.addPlayer(player);
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (player.validateName(playerName.getText())) {
			player.setName(playerName.getText());
			JPanel next;
			if (playerNumber == world.getPlayerCount()) {
				next = new InitialRucksack(world, home);
			} else {
				next = new PlayerName(world, home);
			}
			home.setContentPane(next);
			next.revalidate();
			next.repaint();
		} else {
			JOptionPane.showMessageDialog(home,
					"Please enter a name for your player.", "Try again",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
