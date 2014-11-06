import objectdraw.*;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class NotTheController {

	public NotTheController(DrawingCanvas canvas) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("joint-photographic-experts-group.jpg"));
		} catch (IOException e) {
			// ignore any exceptions
		}
		
		new VisibleImage(img, 100, 100, canvas);
	}
}
