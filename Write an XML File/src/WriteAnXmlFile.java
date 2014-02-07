import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class WriteAnXmlFile {
	public static void main(String[] args) {
		/* just building some (lots of) dummy data... */
		Random rand = new Random();
		Foo[] lotsOfFoo = new Foo[Math.abs(rand.nextInt()) % 100 + 10];
		for (int i = 0; i < lotsOfFoo.length; i++) {
			lotsOfFoo[i] = new Foo();
		}
		Bar[] lotsOfBar = new Bar[Math.abs(rand.nextInt()) % 100 + 10];
		for (int i = 0; i < lotsOfBar.length; i++) {
			lotsOfBar[i] = new Bar();
		}

		/*
		 * this try... catch structure is basically an error-handling setup: you
		 * put it around code that throws exceptions (exceptions are errors that
		 * you can -- maybe -- catch and do something with, rather than just
		 * stopping the program
		 */
		try {
			/*
			 * create a new DOM -- Document Object Model -- using some prefab
			 * builders provided in java.xml
			 * 
			 * This is just the _model_ into which we will store a
			 * representation of our Foos and Bars -- we'll transform it into a
			 * file later.
			 */
			Document dom = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();

			/*
			 * The root element is the parent under which all of our data lives
			 * -- think of it as the top-level folder that we put everything
			 * else into
			 * 
			 * Note that, although we use the DOM to create the element, it is
			 * not yet part of the DOM until we append it!
			 */
			Element root = dom.createElement("example");
			dom.appendChild(root);

			/*
			 * Underneath our root element, we're going to have a list of
			 * foos...
			 */
			Element foos = dom.createElement("foos");
			root.appendChild(foos);
			/*
			 * ... that we'll construct by walking through our list of
			 * randomly-generated Foo objects and storing their values as the
			 * text content of the <foo> elements of the DOM
			 */
			for (int i = 0; i < lotsOfFoo.length; i++) {
				Element foo = dom.createElement("foo");
				foos.appendChild(foo);
				foo.setTextContent(lotsOfFoo[i].getValue());
			}

			/*
			 * Also underneath our root element, we're going to have our list of
			 * randomly-generated Bar objects But this time, rather than using
			 * text content, we're going to stare the multiple instance
			 * variables as attributes of the <bar> elements.
			 */
			Element bars = dom.createElement("bars");
			root.appendChild(bars);
			for (int i = 0; i < lotsOfBar.length; i++) {
				Element bar = dom.createElement("bar");
				bars.appendChild(bar);
				/*
				 * Note that we need to make sure that we're just storing String
				 * data into the DOM, which kind of makes sense, since we're
				 * generating a text file...
				 */
				bar.setAttribute("x", Integer.toString(lotsOfBar[i].getX()));
				bar.setAttribute("y", Integer.toString(lotsOfBar[i].getY()));
				bar.setAttribute("z", Integer.toString(lotsOfBar[i].getZ()));
				bar.setAttribute("a", Double.toString(lotsOfBar[i].getA()));
				bar.setAttribute("b", Double.toString(lotsOfBar[i].getB()));
				bar.setAttribute("c", Double.toString(lotsOfBar[i].getC()));
			}

			/*
			 * The transformer is a handy tool that transforms data from one
			 * format to another -- we'll need one to transform our DOM into a
			 * text file
			 */
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			/* The transformer needs a source (our DOM) */
			DOMSource source = new DOMSource(dom);

			/*
			 * And the transformer needs a place to store the result (a new file
			 * named "example.xml")
			 */
			StreamResult result = new StreamResult(new File("example.xml"));

			/* Let 'er rip! */
			transformer.transform(source, result);

			/*
			 * If we were really good, we would pay attention to these
			 * exceptions and do something constructive with them. Right now
			 * we're just using the default code, that prints out the stack of
			 * function calls that led us to the exception -- useful for
			 * debugging!
			 */
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
