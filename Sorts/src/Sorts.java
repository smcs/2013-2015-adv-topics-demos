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
				stat.addReads(2);
				if (sorted.get(bubbleThumb) > sorted.get(bubbleThumb + 1)) {
					didISwap = true;
					int temp = sorted.get(bubbleThumb);
					stat.updateStorage(sorted.size() + 1);
					sorted.set(bubbleThumb, sorted.get(bubbleThumb + 1));
					stat.addReads(2);
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
	
	public static Vector<Integer> InsertionSort(Vector<Integer> unsorted, Statistic stat) {
		return null;
	}
	
	public static Vector<Integer> SelectionSort(Vector<Integer> unsorted, Statistic stat) {
		return null;
	}
	
	public static Vector<Integer> MergeSort(Vector<Integer> unsorted, Statistic stat) {
		return null;
	}
	
	public static Vector<Integer> Quicksort(Vector<Integer> unsorted, Statistic stat) {
		Vector<Integer> sorted = new Vector<Integer>(unsorted);
		stat.startTimer();
		sorted = Quicksort(sorted, 0, sorted.size() - 1, stat);
		stat.stopTimer();
		return sorted;
	} 
	
	public static Vector<Integer> Quicksort(Vector<Integer> sorting, int first, int last, Statistic stat) {

		/* do a lot of work */
		
		return sorting;
	}

	public static void main(String[] args) {
		long storageAverage = 0;
		double runTimeAverage = 0;
		long readsAverage = 0, writesAverage = 0;
		for (int i = -1; i < 1000; i++) {
			Vector<Integer> mess = Sorting.randomVector(10000);
			//Sorting.printArray(mess);
			Statistic stat = new Statistic("Bubble Sort", mess.size(), 0, 0);
			/*Sorting.printArray(*/bubbleSort(mess, stat)/*)*/;
			System.out.println(stat);
			if (i >= 0) {
				storageAverage = (i * storageAverage + stat.getStorage()) / (i + 1);
				runTimeAverage = (i * runTimeAverage + stat.getRunTime()) / (i + 1);
				readsAverage = (i * readsAverage + stat.getReads()) / (i + 1);
				writesAverage = (i * writesAverage + stat.getWrites()) / (i + 1);
				System.out.println("After " + (i + 1) + " runs...\n" +
					"Average storage: " + storageAverage + " bytes\n" +
					"Average runtime: " + runTimeAverage + " milliseconds\n" +
					"Average reads/writes: " + readsAverage + " / " + writesAverage + "\n"
				);
			}
		}
	}
}
