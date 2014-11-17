import objectdraw.*;

import java.awt.*;

/**
 * An object that depends on keyboard input to move around the screen.
 * 
 * @author Seth Battis
 *
 */
public class ReactingObject extends ActiveObject {

	/**
	 * We need to know who's keeping track of keyboard input
	 */
	private KeyboardManager kbMgr;

	/**
	 * We need to know what our left and right keys are
	 */
	private int left, right;

	/**
	 * We need a graphic to represent ourselves
	 */
	private FilledOval avatar;

	/**
	 * Create an object that reacts to keyboard input.
	 * 
	 * @param l
	 *            The key code for the "move left" key
	 * @param r
	 *            The key code for the "move right" key
	 * @param c
	 *            The color of our avatar
	 * @param canvas
	 *            The canvas on which we should draw our avatar
	 * @param km
	 *            The keyboard manager that will tell us if our left or right
	 *            keys have been pressed
	 */
	public ReactingObject(int l, int r, Color c, DrawingCanvas canvas,
			KeyboardManager km) {
		/* save parameters into our instance variables for future reference */
		left = l;
		right = r;
		kbMgr = km;

		/* create our avatar */
		avatar = new FilledOval(100, 100, 20, 20, canvas);
		avatar.setColor(c);

		/*
		 * note that we are NOT starting our thread as part of the constructor,
		 * to avoid timing issues -- like being ready to collect input from the
		 * keyboard manager before the keyboard manager exists. Bad!
		 */
	}

	/**
	 * Every tenth of a second, find out if either of our keys are being
	 * pressed. Note that holding down both will "stretch" our avatar. :)
	 */
	public void run() {
		/* loop forever -- a.k.a an infinite loop */
		while (true) {
			/*
			 * ask the keyboard manager what's being pressed and behave
			 * suitably.
			 */
			if (kbMgr.isPressed(left) && kbMgr.isPressed(right)) {
				avatar.setWidth(avatar.getWidth() + 1);
			} else if (kbMgr.isPressed(left)) {
				avatar.move(-1, 0);
			} else if (kbMgr.isPressed(right)) {
				avatar.move(1, 0);
			}

			pause(100);
		}
	}

}
