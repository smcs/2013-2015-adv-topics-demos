import java.util.*;

public class Sorting {

	public static Vector<Integer> randomVector(int size) {
		Vector<Integer> returnValue = new Vector<Integer>();
		for (int i = 0; i < size; i++) {
			returnValue.add((int) (Math.random() * size));
		}
		return returnValue;
	}

	public static void printArray(Vector<Integer> v) {
		for (int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Vector<Integer> v) {
		for (int i = 0; i < v.size() - 1; i++) {
			if (v.get(i) > v.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Shift all the elements from v[first+1] to v[last] to the left one space,
	 * overwriting (and losing) the value in v[first]. The element in v[last[
	 * will remain untouched (so v[last] will be a duplicate of v[last-1]).
	 * 
	 * @precondition first and last are both valid indices in v
	 * 
	 * @param v
	 * @param first
	 * @param last
	 */
	public static void shiftLeft(Vector<Integer> v, int first, int last,
			Statistic stat) {
		assert (first >= 0 && first < v.size());
		assert (last >= 0 && last < v.size());
		for (int i = first; i < last - 1; i++) {
			stat.addRead();
			stat.addWrite();
			v.set(i, v.get(i + 1));
		}
	}

	/**
	 * Shift all the elements from v[first] to v[last-1] to the right one space,
	 * overwriting (and losing) the value in v[last]. The element in v[first]
	 * will remain untouched (so v[first] will be a duplicate of v[first+1]).
	 * 
	 * @precondition first and last are both valid indices in v
	 * 
	 * @param v
	 * @param first
	 * @param last
	 * @param stat
	 */
	public static void shiftRight(Vector<Integer> v, int first, int last,
			Statistic stat) {
		assert (first >= 0 && first < v.size());
		assert (last >= 0 && last < v.size());
		for (int i = last; i > first + 1; i--) {
			stat.addRead();
			stat.addWrite();
			v.set(i, v.get(i - 1));
		}

	}
}
