import java.util.Scanner;

public class ConsoleIO {

	public static void main(String[] args) {
		/* set up a scanner to parse the default input stream for us */
		Scanner in = new Scanner(System.in);

		/* Ask the scanner for the "next" whatever you want */
		System.out.print("Enter a sentence: ");
		String sentence = in.nextLine();
		System.out.println("You wrote '" + sentence + "'");

		/* Scanners can parse numbers for you, which is handy */
		System.out.print("Enter a number: ");
		Double number = in.nextDouble();
		System.out.println("You entered " + number + " (3 + " + number + " = "
				+ (3 + number) + ")");

		/*
		 * but be aware that you only get what you ask for -- and the default is
		 * a string!
		 */
		System.out.print("Enter a word: ");
		String notReallyANumber = in.next();
		System.out.println("You entered " + notReallyANumber + " (3 + "
				+ notReallyANumber + " = " + (3 + notReallyANumber) + ")");
	}

}
