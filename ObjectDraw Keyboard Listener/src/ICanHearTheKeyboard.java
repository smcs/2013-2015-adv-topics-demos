import java.awt.Color;
import java.awt.event.*;

import objectdraw.*;

public class ICanHearTheKeyboard extends WindowController implements KeyListener {
	public void begin() {
		canvas.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			FilledRect r = new FilledRect(10,10,100,100,canvas);
			r.setColor(Color.GREEN);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			FilledRect r = new FilledRect(10,10,100,100,canvas);
			r.setColor(Color.RED);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
