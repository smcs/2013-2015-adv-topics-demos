import java.util.*;

public class ThreadRacerCollection {

	private Vector<ThreadRacer> collection;
	public static final int OVERTAKE = 0;
	public static final int ADD = 1;
	public static final int REMOVE = 2;

	public ThreadRacerCollection() {
		collection = new Vector<ThreadRacer>();
	}

	public synchronized void access(ThreadRacer tr, int verb) {
		switch (verb) {
		case OVERTAKE:
			overtake(tr);
			break;
		case ADD:
			add(tr);
			break;
		case REMOVE:
			remove(tr);
			break;
		}
	}
	
	private synchronized void overtake(ThreadRacer tr) {
		Iterator<ThreadRacer> i = collection.iterator();
		while (i.hasNext()) {
			ThreadRacer other = i.next();
			if (other != tr) {
				if (other.getX() < tr.getX()) {
					collection.remove(other);
				}
			}
		}
	}

	private synchronized void add(ThreadRacer tr) {
		collection.add(tr);
	}

	private synchronized void remove(ThreadRacer tr) {
		collection.remove(tr);
	}
}
