package swappingscreens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel homeScreen;
	private ScreenSwapper screenSwapper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		homeScreen = new JPanel();
		homeScreen.setBackground(Color.GREEN);
		homeScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(homeScreen);
		homeScreen.setLayout(null);
		screenSwapper = new ScreenSwapper(homeScreen);
		
		JLabel lblHomeScreen = new JLabel("Home Screen");
		lblHomeScreen.setBounds(115, 69, 101, 16);
		homeScreen.add(lblHomeScreen);
		
		JButton btnNewButton = new JButton("Second Screen");
		screenSwapper.registerScreen("Second Screen", SecondScreen.class);
		btnNewButton.addActionListener(screenSwapper);
		btnNewButton.setBounds(99, 129, 117, 29);
		homeScreen.add(btnNewButton);
	}
}
