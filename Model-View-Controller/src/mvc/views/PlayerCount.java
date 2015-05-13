package mvc.views;

import javax.swing.*;

import mvc.controllers.*;
import mvc.models.*;

import java.awt.*;
import java.awt.event.*;

public class PlayerCount extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerCount(World world, JFrame home) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				JLabel lblPlayerCount = new JLabel("How many players?");
				add(lblPlayerCount);

		JTextField playerCount = new JTextField();
		add(playerCount);
		playerCount.setColumns(10);

		JButton btnDone = new JButton("Get creatin'");
		
		btnDone.addActionListener(new PlayerCountController(world, home, playerCount));
		add(btnDone);

	}
}
