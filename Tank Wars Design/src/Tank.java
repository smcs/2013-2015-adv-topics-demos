public class Tank {

	/* instance variables */
	
	private Location centerPoint;
	private double angle;
	private double speed = 0;
	private double health = 1;
	private double overheat = 0;
	/**
	 * ...and some Drawable2D components that will visually represent our tank
	 */
	
	/* constructor(s) */
	
	/**
	 * Constructor for a new tank, sets: 1. Initial health (very healthy to
	 * begin) 2. Overheating value (not overheating yet)
	 * 
	 * @param start
	 *            starting location on the board
	 * @param forward
	 *            direction in which the tank is facing initially
	 * @param canvas
	 *            DrawingCanvas on which the tank is drawn
	 */
	public Tank(Location start, double forward, DrawingCanvas canvas) {

	}

	/* mutator methods */
	
	/**
	 * Move the tank in the direction in which it is facing, one unit of
	 * movement multiplied by the speed (positive or negative)
	 * 
	 * @param speed
	 *            forward is positive, back is negative
	 */
	public void move(int speed) {

	}

	/**
	 * Turn the tank around its center point, one unit of turn divided by the
	 * speed (hmm... the relationship between forward speed and turning speed
	 * needs careful consideration)
	 * 
	 * @param speed
	 *            left is negative and right is positive
	 */
	public void turn(int speed) {

	}

	/**
	 * 
	 */
	public void incrementOverheat() {

	}

	public void decrementOverheat() {

	}
}
