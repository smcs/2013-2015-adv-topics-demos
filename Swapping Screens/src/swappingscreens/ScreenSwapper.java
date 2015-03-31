package swappingscreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenSwapper implements ActionListener {

	/* the window in which we're swapping out the Jpanel */
	private JFrame mainWindow;

	/* a list of button commands and their associated JPanels */
	private Map<String, Class> screens;

	public ScreenSwapper(JFrame window) {
		mainWindow = window;
		screens = new HashMap<String, Class>();
	}

	/**
	 * Swap in a JPanel based on the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*
			 * look up which JPanel to create and get a new instance of it based
			 * on the actionCommand
			 */
			JPanel replacement = (JPanel) screens.get(e.getActionCommand())
					.newInstance();

			/*
			 * swap in the new JPanel, remembering to repaint it so that we can
			 * see it
			 */
			mainWindow.setContentPane(replacement);
			replacement.revalidate();
			replacement.repaint();

			/*
			 * this may generate either an IllegalAccessException or an
			 * InstantiationException
			 */
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Register a new actionCommand/JPanel pairing
	 * @param actionCommand
	 * @param screen
	 */
	public void registerScreen(String actionCommand, Class screen) {
		screens.put(actionCommand, screen);
	}

}
