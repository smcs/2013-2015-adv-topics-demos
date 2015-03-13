package demo.doubledrawingcanvas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import objectdraw.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class DoubleDrawingCanvas extends JFrame {

	private JPanel contentPane;
	private CanvasController c1, c2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoubleDrawingCanvas frame = new DoubleDrawingCanvas();
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
	public DoubleDrawingCanvas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 438, 266);
		contentPane.add(tabbedPane);
		
		DrawingCanvas canvas1 = new JDrawingCanvas();
		tabbedPane.addTab("Canvas 1", null, (Component) canvas1, null);
		
		DrawingCanvas canvas2 = new JDrawingCanvas();
		tabbedPane.addTab("Canvas 2", null, (Component) canvas2, null);
		
		c1 = new CanvasController(canvas1, new FilledRect(10, 10, 100, 100, canvas1), Color.RED);
		c2 = new CanvasController(canvas2, new FilledRect(100, 100, 10, 10, canvas2), Color.GREEN);
		
		JTextPane textPane = new JTextPane();
		tabbedPane.addTab("Text", null, textPane, null);
		
		JButton btnDoSomething = new JButton("Do Something");
		btnDoSomething.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDoSomething.setText("Did it");
			}
		});
		btnDoSomething.setBounds(156, 305, 117, 29);
		contentPane.add(btnDoSomething);
	}

}
