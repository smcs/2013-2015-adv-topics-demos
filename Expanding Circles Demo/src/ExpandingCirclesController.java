import objectdraw.*;
import java.awt.*;

public class ExpandingCirclesController extends WindowController {
	
	public void onMouseClick(Location click) {
		new Circle(click, 5, canvas);
	}

}
