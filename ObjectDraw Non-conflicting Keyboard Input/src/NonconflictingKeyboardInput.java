import objectdraw.*;

import java.awt.*;
import java.awt.event.*;

/**
 * An example of an approach to handling "button-mashing" keyboard input so that
 * multiple sprites can be controlled from the same keyboard without users
 * "blocking" each other.
 * 
 * @author Seth Battis
 *
 */
public class NonconflictingKeyboardInput extends WindowController {

	private KeyboardManager kbMgr;
	private ReactingObject alphonse, babette;

	public void begin() {
		kbMgr = new KeyboardManager(canvas);
		alphonse = new ReactingObject(KeyEvent.VK_A, KeyEvent.VK_D, Color.RED,
				canvas, kbMgr);
		babette = new ReactingObject(KeyEvent.VK_J, KeyEvent.VK_L, Color.BLUE,
				canvas, kbMgr);

		/* instructions are always nice */
		new Text("A or D, J or L", 70, 140, canvas);

		/*
		 * everything should be initialized... start the reacting object
		 * threads!
		 */
		alphonse.start();
		babette.start();
	}
}
