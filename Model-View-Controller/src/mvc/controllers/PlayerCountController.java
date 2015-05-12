package mvc.controllers;

import java.awt.event.*;

import javax.swing.*;

import mvc.models.*;
import mvc.views.*;

public class PlayerCountController implements ActionListener {

	private World world;

	private JFrame home;
	private JTextField playerCount;

	public PlayerCountController(World world, JFrame home,
			JTextField playerCount) {
		this.world = world;
		this.home = home;
		this.playerCount = playerCount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (world.validatePlayerCount(Integer.valueOf(playerCount.getText()))) {
			world.setPlayerCount(Integer.valueOf(playerCount.getText()));
			JPanel next = new PlayerName(world, home);
			home.setContentPane(next);
			next.revalidate();
			next.repaint();
		} else {
			JOptionPane.showMessageDialog(home,
					"Please choose at least 1 player.", "Try again",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
