import ij.*;
import ij.io.*;

public class ImageJAsALibrary {

	public static void main(String[] args) {
		/*
		 * An opener is just a utility object to open images -- it could easily
		 * be connected to an open dialog instead of a hard-coded file path
		 */
		Opener opener = new Opener();

		/* An ImagePlus is an object that represents the loaded image */
		ImagePlus a = opener.openImage("images/A.png");

		/*
		 * the pixel data represents the pixel as RGBA (Red, Green, Blue and
		 * Alpha) channels, where each channel has a value 0-255, and alpha
		 * represents transparency (0 is opaque, 255 is completely transparent)
		 */
		int[] pixelData = a.getPixel(36, 25);
		System.out.println(pixelData[0] + " " + pixelData[1] + " "
				+ pixelData[2] + " " + pixelData[3]);
	}

}
