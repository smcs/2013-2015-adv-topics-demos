import java.util.*;

public class BubbleSort {

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
	public static Vector<Integer> bubbleSort(Vector<Integer> unsorted) {
		Vector<Integer> sorted = new Vector<Integer>(unsorted);
		boolean didISwap = false;
		int bubbleThumb;

		/* keep repeating until we have no more swaps to make */
		do {
			didISwap = false;
			/*
			 * one pass throug the array, floating the current highest value to
			 * the end
			 */
			for (bubbleThumb = 0; bubbleThumb < sorted.size() - 1; bubbleThumb++) {
				assert (sorted.get(bubbleThumb) != null);
				assert (sorted.get(bubbleThumb + 1) != null);
				if (sorted.get(bubbleThumb) > sorted.get(bubbleThumb + 1)) {
					didISwap = true;
					int temp = sorted.get(bubbleThumb);
					sorted.set(bubbleThumb, sorted.get(bubbleThumb + 1));
				sorted.set(bubbleThumb + 1, temp);
				} else {
					// thumb moves over 1, without a swap
				}
			}
		} while (didISwap);
		return sorted;
	}

	public static void main(String[] args) {
		Vector<Integer> mess = Sorting.randomVector(20);
		Sorting.printArray(mess);
		Sorting.printArray(bubbleSort(mess));
	}
}
