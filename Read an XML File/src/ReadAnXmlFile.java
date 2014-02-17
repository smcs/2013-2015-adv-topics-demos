import java.io.*;
import java.util.*;
import javax.xml.stream.*;

public class ReadAnXmlFile {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 *             If we try to read a file that doesn't exist
	 * @throws XMLStreamException
	 *             If our XML doesn't parse as expected
	 * @throws FactoryConfigurationError
	 *             If we connected the file to the stream reader wrong
	 */
	public static void main(String[] args) throws FileNotFoundException,
			XMLStreamException, FactoryConfigurationError {
		/*
		 * We're going to have lists and lists of Foos and Bars that we'll read
		 * out of our XML file!
		 */
		List<Foo> lotsOfFoo = new ArrayList<Foo>();
		List<Bar> lotsOfBar = new ArrayList<Bar>();

		/*
		 * Let's hook an XML reader up to a generic file reader, which is -- in
		 * turn -- connected up to our actual file
		 */
		String filename = "example.xml";
		XMLStreamReader reader = XMLInputFactory.newInstance()
				.createXMLStreamReader(new FileReader(new File(filename)));

		/* Set up some temporary variables and flags */
		Foo f = null;
		Bar b = null;
		boolean readingFoo = false; /*
									 * so we can tell if we're in the middle of
									 * reading a Foo
									 */

		/*
		 * We'll iterate through our XML file until we run out of elements to
		 * read (i.e. we get to the end)
		 */
		while (reader.hasNext()) {

			/*
			 * Get the code to interpret the reader' s current cursor position
			 * in the XML
			 */
			int parsingEvent = reader.next();

			/*
			 * Check to see if the cursor has encountered a parsing event that
			 * we actually care about and want to do something with
			 */
			switch (parsingEvent) {

			/*
			 * We've hit the beginning of a new element: <foo>, for example.
			 */
			case XMLStreamConstants.START_ELEMENT: {

				/* Ask the reader if the element we hit is a Foo */
				if ("foo".equals(reader.getLocalName())) {
					/*
					 * create a new Foo and add it to our lotsOfFoo list --
					 * we'll have to wait a moment to get it's actual value, so
					 * we'll start it out off as the empty string
					 */
					f = new Foo("");
					lotsOfFoo.add(f);
					readingFoo = true;

					/* Ask the reader if the element we hit is a Bar */
				} else if ("bar".equals(reader.getLocalName())) {
					/*
					 * create a new Bar, read its attributes out of the XML, and
					 * add it to our lotsOfBar list
					 */
					b = new Bar();
					/*
					 * note that since we don't care about any particular
					 * namespace, we leave it null when we ask for the x
					 * attribute
					 * 
					 * Also, we need to use the built-in parsers for Integer and
					 * Double to convert the strings that are read out of the
					 * XML text file into "real" numbers
					 */
					b.setX(Integer.parseInt(reader.getAttributeValue(null, "x")));
					b.setY(Integer.parseInt(reader.getAttributeValue(null, "y")));
					b.setZ(Integer.parseInt(reader.getAttributeValue(null, "z")));
					b.setA(Double.parseDouble(reader.getAttributeValue(null,
							"a")));
					b.setB(Double.parseDouble(reader.getAttributeValue(null,
							"b")));
					b.setC(Double.parseDouble(reader.getAttributeValue(null,
							"c")));
					lotsOfBar.add(b);
				}
				break;
			}

			/*
			 * we've encountered text content in between tags!
			 */
			case XMLStreamConstants.CHARACTERS: {
				/*
				 * if we're in the middle of reading a Foo, these characters
				 * must actually be its text value!
				 */
				if (readingFoo) {
					f.setValue(reader.getText());
				}
				break;
			}

			/*
			 * we've hit the end of an element: </foo>, for example
			 */
			case XMLStreamConstants.END_ELEMENT: {
				/*
				 * if we've hit the end of a Foo, we should stop waiting for
				 * content to fill it in with!
				 */
				if ("foo".equals(reader.getLocalName())) {
					readingFoo = false;
				}
				break;
			}
			}
		}

		/* Do some printing to demonstrate that we really read the data in! */
		System.out.println("Foo stored in " + filename + ":");
		for (int i = 0; i < lotsOfFoo.size(); i++) {
			System.out.println("    " + lotsOfFoo.get(i));
		}
		System.out.println("Bar stored in " + filename + ":");
		for (int i = 0; i < lotsOfBar.size(); i++) {
			System.out.println("    " + lotsOfBar.get(i));
		}
	}
}
