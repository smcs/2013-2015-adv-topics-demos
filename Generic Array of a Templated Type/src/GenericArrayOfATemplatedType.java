import java.util.*;

public class GenericArrayOfATemplatedType {

	public static void main(String[] args) {

		/*
		 * In my dream world, I would be able to make the seemingly logical
		 * declaration below:
		 */
		LinkedList<AwesomeObject>[] arrayOfATemplatedType;

		/*
		 * Granted, the line compiles, but the trouble comes when I try to
		 * instantiate it:
		 */
		// arrayOfATemplatedType = new LinkedList<AwesomeObject>[100];

		/*
		 * Turns out that, syntactically, I can't have a generic array of a
		 * templated type, since I'm allocating memory without calling any
		 * constructors. So, what to do? Enter inheritance! I'll simply create a
		 * class that extends the templated type of which I wanted to have an
		 * array.
		 */
		LinkedListOfAwesomeObjects[] anotherArrayOfATemplatedType;

		/*
		 * This, I can instantiate -- since all non-templated types are
		 * subclasses of the original Object, they have a default constructor
		 * that will be used to instantiate the elements of this array!
		 */
		anotherArrayOfATemplatedType = new LinkedListOfAwesomeObjects[100];

		/* And, I can treat it as I would my original arrayOfATemplatedType! */
		anotherArrayOfATemplatedType[17].add(new AwesomeObject());
		Iterator<AwesomeObject> iterator = anotherArrayOfATemplatedType[12]
				.iterator();
		// ...and so forth and so on.
	}

}
