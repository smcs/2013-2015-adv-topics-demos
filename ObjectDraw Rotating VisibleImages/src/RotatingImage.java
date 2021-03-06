import objectdraw.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class RotatingImage extends WindowController implements KeyListener {

	/*
	 * important to set the BufferedImage to null initially to avoid errors due
	 * to an uninitialized variable!
	 */
	private BufferedImage originalImage = null;
	private VisibleImage displayedImage;
	private double rotation = 0;

	/**
	 * Rotates an image by an arbitrary amount of degrees around its center. A
	 * positive value for degrees will rotate the image clockwise, a negative
	 * value counterclockwise. An image will be returned with a size that
	 * exactly fits the rotated image.
	 * 
	 * 2014-11-11 SDB modified from source to set background color as well
	 * 
	 * @link http://udojava.com/tag/awt-image-rotation/
	 * 
	 * @param src
	 *            The source image to rotate.
	 * @param degrees
	 *            The amount in degrees to rotate, a positive value rotates
	 *            clockwise, a negative counterclockwise.
	 * @param backgroundColor
	 *            The background color of the bounding rectangle.
	 * @return A new BufferdImage with a new size that exactly fits the rotated
	 *         image.
	 */
	public static BufferedImage rotateImage(BufferedImage src, double degrees,
			Color backgroundColor) {
		double radians = Math.toRadians(degrees);
		int srcWidth = src.getWidth();
		int srcHeight = src.getHeight();
		double sin = Math.abs(Math.sin(radians));
		double cos = Math.abs(Math.cos(radians));
		int newWidth = (int) Math.floor(srcWidth * cos + srcHeight * sin);
		int newHeight = (int) Math.floor(srcHeight * cos + srcWidth * sin);
		BufferedImage result = new BufferedImage(newWidth, newHeight,
				src.getType());
		Graphics2D g = result.createGraphics();
		g.setPaint(backgroundColor);
		g.fillRect(0, 0, result.getWidth(), result.getHeight());
		g.translate((newWidth - srcWidth) / 2, (newHeight - srcHeight) / 2);
		g.rotate(radians, srcWidth / 2, srcHeight / 2);
		g.drawRenderedImage(src, null);
		return result;
	}

	public void begin() {
		try {
			originalImage = ImageIO.read(new File(
					"portable-network-graphic.png"));
		} catch (IOException e) {
			// ignore any exceptions
		}
		/*
		 * it seems that you can load images from the web, so long as the URL is
		 * not "complicated" -- that is, so long as it doesn't involve say,
		 * #anchors or ?form=requests
		 */
		displayedImage = new VisibleImage(originalImage, 75, 75, canvas);
		
		canvas.addKeyListener(this);
	}

	/**
	 * Rotate the image 5 degrees around its center every time the mouse is
	 * clicked.
	 */
	public void onMousePress(Location click) {
		rotation += 5;

		/* store the location and dimensions of the current image */
		Location oldOrigin = displayedImage.getLocation();
		double oldWidth = displayedImage.getWidth();
		double oldHeight = displayedImage.getHeight();

		/*
		 * generate a new rotated image based on the original image (to avoid an
		 * infinitely expanding bounding box). Note that setting a color with an
		 * alpha of zero makes it transparent -- so we are setting a transparent
		 * background for our bounding box.
		 */
		displayedImage.setImage(rotateImage(originalImage, rotation, new Color(
				0, 0, 0, 0)));

		/*
		 * adjust the new displayed image to keep the center in the same
		 * location as the previous rotation
		 */
		displayedImage.move((oldWidth - displayedImage.getWidth()) / 2.0,
				(oldHeight - displayedImage.getHeight()) / 2.0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'j') {
			rotation += 5;
		} else if (e.getKeyChar() == 'l') {
			rotation -= 5;
		}
		
		/* store the location and dimensions of the current image */
		Location oldOrigin = displayedImage.getLocation();
		double oldWidth = displayedImage.getWidth();
		double oldHeight = displayedImage.getHeight();

		/*
		 * generate a new rotated image based on the original image (to avoid an
		 * infinitely expanding bounding box). Note that setting a color with an
		 * alpha of zero makes it transparent -- so we are setting a transparent
		 * background for our bounding box.
		 */
		displayedImage.setImage(rotateImage(originalImage, rotation, new Color(
				0, 0, 0, 0)));

		/*
		 * adjust the new displayed image to keep the center in the same
		 * location as the previous rotation
		 */
		displayedImage.move((oldWidth - displayedImage.getWidth()) / 2.0,
				(oldHeight - displayedImage.getHeight()) / 2.0);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}