import ij.*;
import ij.io.*;
import ij.process.ImageProcessor;

public class ImageJAsALibrary {

	public static void main(String[] args) {
		/* An ImagePlus is an object that represents the loaded image. IJ is the ImageJ application. */
		ImagePlus image = IJ.openImage("images/A.png");

		/* display the image we're working with in its own window -- this also puts ImageJ's focus on this image, so that subsequent commands will run on this image. */
		image.show();
		
		/*
		 * the pixel data represents the pixel as RGBA (Red, Green, Blue and
		 * Alpha) channels, where each channel has a value 0-255, and alpha
		 * represents transparency (0 is opaque, 255 is completely transparent)
		 */
		int[] pixelData = image.getPixel(36, 25);
		System.out.println(pixelData[0] + " " + pixelData[1] + " "
				+ pixelData[2] + " " + pixelData[3]);
		
		/* convert the current image to 8-bit -- calling the command by its exact name in the menu */
		IJ.run("8-bit");
	}

}
