package demo.doubledrawingcanvas;

import java.awt.*;
import java.awt.event.*;

import objectdraw.*;

public class CanvasController implements MouseListener, MouseMotionListener {

	private DrawingCanvas canvas;
	private FilledRect rect;
	private boolean clicked = false;
	private Point lastLoc;
	
	public CanvasController(DrawingCanvas canvas, FilledRect r, Color c) {
		this.canvas = canvas;
		this.rect = r;
		r.setColor(c);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (clicked) {
			rect.move(e.getX() - lastLoc.getX(), e.getY() - lastLoc.getY());
		}
		lastLoc = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Location l = new Location(e.getX(), e.getY());
		if (rect.contains(l)) {
			clicked = true;
		} else {
			clicked = false;
		}
		lastLoc = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clicked = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
