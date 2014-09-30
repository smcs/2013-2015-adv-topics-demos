import objectdraw.*;

public class Circle extends ActiveObject {

	private Location center;
	private double radius;
	private FramedOval circle;

	public Circle(Location center, double radius, DrawingCanvas canvas) {
		circle = new FramedOval(center.getX() - radius, center.getY() - radius,
				2 * radius, 2 * radius, canvas);
		
		this.center = center;
		this.radius = radius;
		
		start(); // tell my active object (me!) to start up
	}
	
	public void run() {
		while (true) {
			radius++;
			circle.setSize(radius * 2, radius * 2);
			circle.move(-1, -1);
			pause(100);
		}
	}
}