import objectdraw.*;

import java.awt.event.*;
import java.util.*;

/**
 * A class to track all keyboard input, particularly which keys are currently
 * being held down.
 * 
 * @author Seth Battis
 *
 */
public class KeyboardManager implements KeyListener {

	/**
	 * A list of currently pressed keys -- note that this has to be a Vector of
	 * an object, so we use the built-in Boolean object, which will autobox
	 * boolean primitives.
	 */
	private Vector<Boolean> currentlyPressedKeys;

	/**
	 * Create a new KeyBoardManager that listens to key events on the current
	 * canvas.
	 * 
	 * @param canvas
	 */
	public KeyboardManager(DrawingCanvas canvas) {

		/* register ourselves as a KeyListener */
		canvas.addKeyListener(this);

		/* instantiate our list of pressed keys -- currently empty */
		currentlyPressedKeys = new Vector<Boolean>();
	}

	/**
	 * A helper function to automagically expand the list of currently pressed
	 * keys to include whatever key code is currently being inquired about. The
	 * currentlyPressedKeys vector is resized and the key specifically being
	 * inquired about is set to false (not pressed) if it is not already set.
	 * 
	 * @param indexOfIinterest
	 */
	private void rightSize(int indexOfIinterest) {
		/*
		 * if indexOfInterest is out-of-bounds, expand the vector to make it
		 * in-bounds
		 */
		if (currentlyPressedKeys.size() <= indexOfIinterest) {
			currentlyPressedKeys.setSize(indexOfIinterest + 1);
		}

		/*
		 * if indexOfInterst is currently not set (as would be the case if the
		 * key has not yet been pressed for the first time, or if the Vector was
		 * just expanded to include this key), set it to false
		 */
		if (currentlyPressedKeys.get(indexOfIinterest) == null) {
			currentlyPressedKeys.set(indexOfIinterest, false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// do nothing
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/* make sure that our vector includes the current key */
		rightSize(e.getKeyCode());

		/* mark that the current key is being pressed */
		currentlyPressedKeys.set(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * make sure that our vector includes the current key -- one might
		 * assume that a key can only be released after it has been pressed, but
		 * we're playing it safe here
		 */
		rightSize(e.getKeyCode());

		/* mark that the current key is no longer being pressed */
		currentlyPressedKeys.set(e.getKeyCode(), false);
	}

	public boolean isPressed(int keyCode) {
		/* make sure that our vector includes the current key */
		rightSize(keyCode);

		/* return whether or not the current key is being pressed */
		return currentlyPressedKeys.get(keyCode);
	}
}
