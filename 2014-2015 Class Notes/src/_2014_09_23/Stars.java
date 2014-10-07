package _2014_09_23;

public class Stars {

	public static void stars(int n) {
		for (int row = 0; row < n; row++) {
			for (int spaces = 0; spaces < row; spaces++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			stars(i);
		}
	}
}
