import objectdraw.*;
import java.awt.*;

public class ImageDisplay extends WindowController {
	public void begin() {
		/*
		 * for whatever reason, you have to store your graphics files in the
		 * same directory as your Java source files
		 */
		Image png = getImage("portable-network-graphic.png");
		Image gif = getImage("graphics-interchange-format.gif");
		Image jpg = getImage("joint-photographic-experts-group.jpg");
		new VisibleImage(png, 10, 10, canvas);
		new VisibleImage(gif, 60, 10, canvas);
		new VisibleImage(jpg, 110, 10, canvas);
	}
}
