import objectdraw.*;
import java.util.*;

public class CircleCollection {

	private Vector<Circle> circles;

	public CircleCollection() {
		circles = new Vector<Circle>(); // new empty vector
	}

	private double distance(Location a, Location b) {
		
	}
	
	public boolean overlap(Circle c) {
		for (int i = 0; i < circles.size(); i++) {
			if (c != circles.get(i)) {
				if (distance(c.getCenter(), circles.get(i).getCenter()) < (
						c.getRadius() + circles.get(i).getRadius())) {
					return true;
				}
			}
		}
		return false;
	}

	public void add(Circle c) {
		circles.add(c);
	}
}
