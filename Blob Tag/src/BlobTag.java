import objectdraw.*;

/**
 * An example of how to construct and manage a thread-safe collection of threads
 * that needs to be updated in real-time.
 * 
 * @author Seth Battis
 */
public class BlobTag extends WindowController {

	private BlobCollection collection;

	public void begin() {

		/* resize the window */
		setSize(500, 500);

		/* create our thread-safe collection (of BlobTag threads) */
		collection = new BlobCollection(canvas);

		/* create a boat-load of BlobTag threads and let 'em rip */
		for (int i = 0; i < 100; i++) {
			new Blob(canvas, collection);
		}
	}
}
