import java.util.*;

public class KnowItAll {

	/* a list shared by all instances of KnowItAll at the class level */
	protected static Vector<KnowItAll> everyone;

	public KnowItAll() {
		/*
		 * if no one else has started the everyone list, create one at the class
		 * level
		 */
		if (KnowItAll.everyone == null) {
			KnowItAll.everyone = new Vector<KnowItAll>();
		}

		/* do my own initialization */

		/* add myself to the shared everyone list */
		KnowItAll.everyone.add(this);
	}
}
