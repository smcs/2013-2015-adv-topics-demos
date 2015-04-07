import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/*
	 * a list of widgets that we'll use later -- this could be
	 * declared/instantiated/populated anywhere, so long as we have a reference
	 * to it when we go to assign it as a combobox data model later on
	 */
	private Vector<Widget> listOfWidgets;

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
		/*
		 * instantiating your vector could happen anywhere -- you just need a
		 * vector of stuff to be the data model
		 */
		listOfWidgets = new Vector<Widget>();
		listOfWidgets.add(new Widget("Banana"));
		listOfWidgets.add(new Widget("Watermelon"));
		listOfWidgets.add(new Widget("Gnu"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(57, 101, 301, 27);

		/*
		 * assign the list of widgets as the "data model" that this combobox
		 * draws on for its list of items
		 */
		comboBox.setModel(new DefaultComboBoxModel(listOfWidgets));

		contentPane.add(comboBox);

		/* if we update the vector, the combobox is automagically updated! */
		listOfWidgets.add(new Widget(
				"I as added after the data model was assigned"));
	}
}
