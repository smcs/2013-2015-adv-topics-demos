import objectdraw.*;

public class Circle extends ActiveObject {

	private Location center;
	private double radius;
	private FramedOval visualRepresentationOfMyself;
	private CircleCollection circles;

	public Circle(Location center, double radius, CircleCollection circles, DrawingCanvas canvas) {
		visualRepresentationOfMyself = new FramedOval(center.getX() - radius, center.getY() - radius,
				2 * radius, 2 * radius, canvas);
		
		this.center = center;
		this.radius = radius;
		this.circles = circles;
		
		start(); // tell my active object (me!) to start up
	}
	
	public void run() {
		while (!circles.overlap(this)) {
			radius++;
			visualRepresentationOfMyself.setSize(radius * 2, radius * 2);
			visualRepresentationOfMyself.move(-1, -1);
			pause(100);
		}
	}

	/* Accessor methods */
	
	public Location getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}
	
	/* Mutator methods */
	
	public void removeFromCanvas() {
		visualRepresentationOfMyself.removeFromCanvas();
	}
}