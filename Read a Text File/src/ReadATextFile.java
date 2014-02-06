import java.io.*;

public class ReadATextFile {

	public static void main(String[] args) throws IOException {
		/*
		 * hook a buffered reader up to the file to do all the heavy
		 * pre-processing for us
		 */
		BufferedReader reader = new BufferedReader(new FileReader(
				"My Text File.txt"));

		/* keep reading so long as there's text waiting for us in the file */
		while (reader.ready()) {
			/* store the next line into a string */
			String currentLine = reader.readLine();

			/*
			 * do whatever we want with that string -- e.g. split apart the
			 * words! In this case, we're telling the string to split apart on
			 * matches to the regular expression \s, which means "whitespace"
			 */
			String[] words = currentLine.split("\\s");
			for (int i = 0; i < words.length; i++) {
				System.out.println(words[i]);
			}
		}

		/* it's good form to release the file when we're done with it */
		reader.close();
	}
}
