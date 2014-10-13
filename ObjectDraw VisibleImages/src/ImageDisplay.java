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

		/*
		 * it seems that you can load images from the web, so long as the URL is
		 * not "complicated" -- that is, so long as it doesn't involve say,
		 * #anchors or ?form=requests
		 */
		Image web = getImage("https://en.gravatar.com/userimage/696768/f1260feccb38f9a5a3f5aad91ba6d49f.jpeg");
		new VisibleImage(png, 10, 10, canvas);
		new VisibleImage(gif, 60, 10, canvas);
		new VisibleImage(jpg, 110, 10, canvas);
	}
}
