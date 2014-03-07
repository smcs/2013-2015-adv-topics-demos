import ij.*;
import ij.io.*;

public class ImageJAsALibrary {

	public static void main(String[] args) {
		Opener file = new Opener();
		ImagePlus a = file.openImage("images/A.png");
		ImagePlus b = file.openImage("images/B.png");
		int[] pixelData = a.getPixel(36, 25);
		System.out.println(pixelData[0] + " " + pixelData[1] + " " + pixelData[2] + " " + pixelData[3]);
	}

}
