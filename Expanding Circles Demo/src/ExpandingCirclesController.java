import objectdraw.*;
import java.awt.*;

public class ExpandingCirclesController extends WindowController {
	
	private CircleCollection circles;
	
	public void onMouseClick(Location click) {
		Circle c = new Circle(click, 5, circles, canvas);
		if (!circles.overlap(c)) {
			circles.add(c);
		} else {
			c.removeFromCanvas();
		}
	}
	
	public void begin() {
		circles = new CircleCollection();
	}

}
