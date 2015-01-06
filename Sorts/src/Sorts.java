import java.util.*;

public class Sorts {
	
	/**
	 * Perform a a bubble sort on an array of presumptively unsorted integers
	 * 
	 * @param unsorted
	 *            the array to be sorted
	 * @return a sorted array
	 * @pre unsorted is unsorted, all elements in unsorted are assigned integer
	 *      values
	 * @post unsorted is unchanged
	 */
	public static Vector<Integer> bubbleSort(Vector<Integer> unsorted, Statistic stat) {
		Vector<Integer> sorted = new Vector<Integer>(unsorted);
		stat.updateStorage(unsorted.size());
		boolean didISwap = false;
		int bubbleThumb;

		/* keep repeating until we have no more swaps to make */
		stat.startTimer();
		do {
			didISwap = false;
			/*
			 * one pass through the array, floating the current highest value to
			 * the end
			 */
			for (bubbleThumb = 0; bubbleThumb < sorted.size() - 1; bubbleThumb++) {
				assert (sorted.get(bubbleThumb) != null);
				assert (sorted.get(bubbleThumb + 1) != null);
				stat.addRead();
				stat.addRead();
				if (sorted.get(bubbleThumb) > sorted.get(bubbleThumb + 1)) {
					didISwap = true;
					int temp = sorted.get(bubbleThumb);
					stat.updateStorage(sorted.size() + 1);
					sorted.set(bubbleThumb, sorted.get(bubbleThumb + 1));
					stat.addRead();
					stat.addRead();
					stat.addWrite();
				sorted.set(bubbleThumb + 1, temp);
				} else {
					// thumb moves over 1, without a swap
				}
			}
		} while (didISwap);
		stat.stopTimer();
		return sorted;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Vector<Integer> mess = Sorting.randomVector(1000);
			Sorting.printArray(mess);
			Statistic stat = new Statistic("Bubble Sort", mess.size(), 0, 0);
			Sorting.printArray(bubbleSort(mess, stat));
			System.out.println(stat);
		}
	}
}
