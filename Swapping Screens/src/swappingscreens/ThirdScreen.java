package swappingscreens;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ThirdScreen extends JPanel {

	private ScreenSwapper screenSwapper;
	
	/**
	 * Create the panel.
	 */
	public ThirdScreen() {
		setBackground(Color.BLUE);
		screenSwapper = new ScreenSwapper(this);
		
		JButton btnNewButton = new JButton("Go 2");
		screenSwapper.registerScreen("Go 2", SecondScreen.class);
		btnNewButton.addActionListener(screenSwapper);
		btnNewButton.setBounds(99, 129, 117, 29);
		add(btnNewButton);

	}

}
