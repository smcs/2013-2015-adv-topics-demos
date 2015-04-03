package swappingscreens;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.BevelBorder;

public class SecondScreen extends JPanel {

	private ScreenSwapper screenSwapper;
	
	/**
	 * Create the panel.
	 */
	public SecondScreen() {
		setBackground(Color.RED);
		setLayout(null);
		screenSwapper = new ScreenSwapper(this);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox.setBounds(6, 6, 333, 158);
		add(horizontalBox);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JLabel lblSecondScreen = new JLabel("Centered!");
		verticalBox.add(lblSecondScreen);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		JButton btnNewButton = new JButton("Third Screen");
		screenSwapper.registerScreen("Third Screen", ThirdScreen.class);
		btnNewButton.addActionListener(screenSwapper);
		btnNewButton.setBounds(99, 129, 117, 29);
		add(btnNewButton);


	}
}
