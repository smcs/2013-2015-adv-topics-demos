import java.awt.*;
import java.awt.event.*;
import java.util.*;
import objectdraw.*;

public class Dotter extends WindowController implements KeyListener {

	private LinkedList<FilledOval> myDots;
	
	public void begin() {
		myDots = new LinkedList<FilledOval>();
		this.addKeyListener(this);
		canvas.addKeyListener(this);
	}
	
	public void onMousePress(Location l) {
		FilledOval dot = new FilledOval(l.getX(), l.getY(), 5, 5, canvas);
		myDots.add(dot);
	}

	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_R) {
			ListIterator<FilledOval> myDotsIterator = myDots.listIterator();
			while (myDotsIterator.hasNext()) {
				FilledOval o = myDotsIterator.next();
				o.setColor(Color.red);
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
	
}
