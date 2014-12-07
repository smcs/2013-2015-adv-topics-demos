import objectdraw.*;
import java.awt.*;

/**
 * A threaded object that uses a separate (thread-safe) collection to check for
 * collisions with other, similar threaded objects.
 * 
 * Note that a number of accessor and mutator methods of a Blob are synchronized
 * to prevent inconsistent responses and calculations.
 * 
 * @author Seth Battis
 */
public class Blob extends ActiveObject {

	private BlobCollection blobs;
	private FilledOval icon;
	private double heading;
	private double speed;
	private double diameter;
	private boolean alive = true;

	/**
	 * Create a randomly-sized, randomly-colored blob headed in a random
	 * direction at a random speed on the canvas.
	 * 
	 * @param canvas
	 *            The DrawingCanvas on which to display the blob
	 * @param blobs
	 *            The collection of blobs to reference when calculating
	 *            collisions
	 */
	public Blob(DrawingCanvas canvas, BlobCollection blobs) {
		this.blobs = blobs;
		heading = Math.random() * Math.PI * 2.0;
		speed = Math.random() * 10.0 + 1.0;
		diameter = Math.random() * 10.0 + 1.0;
		icon = new FilledOval((canvas.getWidth() - diameter) * Math.random(),
				(canvas.getHeight() - diameter) * Math.random(), diameter,
				diameter, canvas);
		/*
		 * maxing out color values at 200 so that the colors will remain
		 * relatively visible and not become "white"
		 */
		icon.setColor(new Color((int) (Math.random() * 200), (int) (Math
				.random() * 200), (int) (Math.random() * 200)));
		blobs.add(this);
		start();
	}

	/**
	 * Advance at speed along current heading, then check for any collisions,
	 * with lesser blobs being absorbed by greater blobs.
	 */
	public void run() {
		while (alive) {
			/* move in direction of heading */
			icon.move(Math.cos(heading) * speed, Math.sin(heading) * speed);

			/* bounce of sides of window */
			if (icon.getX() < 0
					|| icon.getX() > icon.getCanvas().getWidth() - diameter) {
				heading = (Math.PI - heading) % (Math.PI * 2.0);
			}
			if (icon.getY() < 0
					|| icon.getY() > icon.getCanvas().getWidth() - diameter) {
				heading = (Math.PI + (Math.PI - heading)) % (Math.PI * 2.0);
			}

			/* check for collisions */
			blobs.checkForCollisions(this);

			/* wait a decent interval */
			pause(100);
		}
		icon.removeFromCanvas();
	}

	/**
	 * Is this blob "greater" than another blob, meaning that its combined speed
	 * and diameter is larger?
	 * 
	 * @param other
	 *            The Blob for comparison
	 * @return true iff this is greater than other
	 */
	public synchronized boolean isGreaterThan(Blob other) {
		if (diameter * speed > other.diameter * other.speed) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Are these blobs "equal", meaning that their combined speed and diameter
	 * are the same?
	 * 
	 * @param other
	 *            The blob for comparison
	 * @return true iff the two blobs are equal
	 */
	public synchronized boolean equals(Blob other) {
		return diameter * speed == other.diameter * other.speed;
	}

	/**
	 * Does this Blob visually overlap another one?
	 * 
	 * @param other
	 *            The Blob to check for overlap
	 * @return true iff the blobs overlap each other.
	 */
	public synchronized boolean overlaps(Blob other) {
		return Math.sqrt(Math.pow(icon.getX() + getRadius() - other.icon.getX()
				+ other.getRadius(), 2)
				+ Math.pow(icon.getY() + getRadius() - other.icon.getY()
						- other.getRadius(), 2)) < (getRadius() + other
				.getRadius());
	}

	/**
	 * @return The radius of this blob
	 */
	public synchronized double getRadius() {
		return diameter / 2.0;
	}

	/**
	 * Adjust this blob visually to reflect the absorption of the other Blob
	 * 
	 * @param other
	 *            The Blob to be absorbed
	 */
	public synchronized void absorb(Blob other) {
		double old = diameter;
		diameter = 2.0 * Math.sqrt(Math.pow(getRadius(), 2)
				+ Math.pow(other.getRadius(), 2));
		icon.setSize(diameter, diameter);
		icon.move((old - diameter) / 2.0, (old - diameter) / 2.0);
		other.kill();
	}

	/**
	 * Mark this Blob to be removed (it has been absorbed)
	 */
	public synchronized void kill() {
		alive = false;
	}
}
