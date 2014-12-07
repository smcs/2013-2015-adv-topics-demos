import objectdraw.*;
import java.util.*;

/**
 * A thread-safe collection of threaded objects that will be updated in
 * real-time by the thread objects themselves.
 * 
 * What makes this thread-safe? Note that, while a java.util.Vector is
 * inherently thread-safe (each of its methods is synchronized) any operations
 * that involve traversals of the vector are not thread-safe, as those
 * traversals are not themselves synchronized. This collection encapsulates
 * those traversals in its own, synchronized, methods.
 * 
 * @author Seth Battis
 */
public class BlobCollection {
	private Vector<Blob> blobs;
	private Text display;

	/**
	 * Create a new empty collection of Blobs, displaying a counter of Blobs in
	 * the collection in the top-left corner of the DrawingCanvas.
	 * 
	 * @param canvas
	 *            DrawingCanvas on which to display the current count of Blobs
	 *            in the collection.
	 */
	public BlobCollection(DrawingCanvas canvas) {
		blobs = new Vector<Blob>();
		display = new Text(blobs.size(), 0, 0, canvas);
	}

	/**
	 * Add a new Blob to the collection, updating the size display on the
	 * DrawingCanvas.
	 * 
	 * @param blob
	 *            The Blob to be added to the collection.
	 * @return true iff the Blob is successfully added to the collection.
	 */
	public synchronized boolean add(Blob blob) {
		boolean result = blobs.add(blob);
		if (result) {
			display.setText(blobs.size());
		}
		return result;
	}

	/**
	 * If blob is present in the collection, remove it from the collection,
	 * uypdating the size display on the DrawingCanvas.
	 * 
	 * @param blob
	 *            The blob to be removed from the collection.
	 * @return true iff the Blob is removed from the collection.
	 */
	public synchronized boolean remove(Blob blob) {
		boolean result = blobs.remove(blob);
		if (result) {
			display.setText(blobs.size());
		}
		return result;
	}

	/**
	 * Starting with startingBlob, check to see if any other Blobs overlap
	 * startingBlob. If so, the greater blob "wins" and absorbs the lesser blob,
	 * removing the lesser blob from the simulation. If startingBlobg is not the
	 * greater blob, the focus of this traversal shifts to the "winner".
	 * 
	 * @param startingBlob
	 *            The Blob to start with as our focus of this traversal, looking
	 *            for collisions.
	 */
	public synchronized void checkForCollisions(Blob startingBlob) {
		/*
		 * store the initial size of the collection, in case we need to update
		 * the display later
		 */
		int count = blobs.size();

		/*
		 * start an (empty) list of Blobs that have been killed, to be deleted
		 * from the collection after the traversal. (Deleting them
		 * mid-traversal, while logically reasonable, creates a danger of losing
		 * our place in the collection during the traversal itself.)
		 */
		Vector<Blob> deleteLater = new Vector<Blob>();

		/*
		 * start our focus on startingBlob -- if startingBlob is "killed", our
		 * focus will shift to that "winner" for the remainder of this traversal
		 * (until there is a new "winner", at least)
		 */
		Blob focalBlob = startingBlob;

		/*
		 * traverse the collection, looking for overlaps in the space around
		 * startingBlob
		 */
		Iterator<Blob> blobsThumb = blobs.iterator();
		while (blobsThumb.hasNext()) {
			Blob currentBlob = blobsThumb.next();
			if (startingBlob != currentBlob && focalBlob.overlaps(currentBlob)) {
				if (focalBlob.isGreaterThan(currentBlob)) {
					focalBlob.absorb(currentBlob);
					deleteLater.add(currentBlob);
				} else if (currentBlob.isGreaterThan(focalBlob)) {
					currentBlob.absorb(focalBlob);
					deleteLater.add(focalBlob);
					focalBlob = currentBlob;
				} else if (focalBlob.equals(currentBlob)) {
					deleteLater.add(currentBlob);
				}
			}
		}

		/*
		 * work through our list of "killed" Blobs and remove them from the
		 * collection
		 */
		while (deleteLater.size() > 0) {
			Blob a = deleteLater.get(0);
			blobs.remove(a);
			deleteLater.remove(a);
		}

		/* if the size of the collection has changed, update the display */
		if (count > blobs.size()) {
			display.setText(blobs.size());
		}
	}
}
