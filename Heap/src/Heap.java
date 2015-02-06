import java.util.*;

public class Heap<T extends Comparable<T>> {
	private Vector<T> heap;

	public Heap() {
		heap = new Vector<T>();
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return index * 2 + 1;
	}

	private int rightChild(int index) {
		return index * 2 + 2;
	}

	private void swap(int indexA, int indexB) {
		T temp = heap.get(indexA);
		heap.set(indexA, heap.get(indexB));
		heap.set(indexB, temp);
	}

	public void add(T data) {
		heap.addElement(data);

		int newElementIndex = heap.size() - 1;
		for (int parentIndex = parent(newElementIndex); newElementIndex > 0
				&& (heap.get(newElementIndex).compareTo(heap.get(parentIndex)) > 0); parentIndex = parent(newElementIndex)) {
			swap(newElementIndex, parentIndex);
			newElementIndex = parentIndex;
		}
	}

	public T decapitate() {
		T returnValue = heap.get(0);

		// get last and put on top
		heap.set(0, heap.remove(heap.size() - 1));

		// compare our "current" node to children, if current node is bigger...
		// we're done!
		// however, if either child is bigger, swap with the larger child
		int currentIndex = 0;
		while ((leftChild(currentIndex) < heap.size() && heap.get(currentIndex)
				.compareTo(heap.get(leftChild(currentIndex))) < 0)
				|| (rightChild(currentIndex) < heap.size() && heap.get(
						currentIndex).compareTo(
						heap.get(rightChild(currentIndex))) < 0)) {
			if (rightChild(currentIndex) < heap.size()
					&& heap.get(rightChild(currentIndex)).compareTo(
							heap.get(leftChild(currentIndex))) > 0) {
				swap(currentIndex, rightChild(currentIndex));
				currentIndex = rightChild(currentIndex);
			} else {
				swap(currentIndex, leftChild(currentIndex));
				currentIndex = leftChild(currentIndex);
			}
		}

		return returnValue;
	}

	public String toString() {
		// find widest number by converting @ number to string and keeping the
		// maximum
		String temp;
		int maxWidth = 1;
		for (int i = 0; i < heap.size(); i++) {
			temp = heap.get(i).toString();
			if (temp.length() > maxWidth) {
				maxWidth = temp.length();
			}
		}

		String result = "";

		int numWidth = maxWidth + 1;
		for (
				int level = (int) (Math.log(heap.size()) / Math.log(2));
				level >= 0;
				level--
			) {
			String row = "";
			String connectors = "";
			boolean connectorToRight = true;
			for (
					int node = (int) (Math.pow(2, level) - 1);
					node < Math.pow(2, level + 1) - 1 && node < heap.size();
					node++
				) {
				if (node == (int) (Math.pow(2, level))) {
					numWidth = (int) (numWidth * 1.5);
				} else if (node == (int) (Math.pow(2, level) - 1)) {
					numWidth = (int) (numWidth * (4.0/3.0));
				}
				row += String.format("%1$" + numWidth + "s", heap.get(node).toString());
				if (connectorToRight) {
					connectors += String.format("%1$" + numWidth + "s", "/");
				} else {
					connectors += String.format("%1$" + numWidth + "s", "\\");
				}
				connectorToRight = !connectorToRight;
			}
			if (level == 0) {
				result = row + "\n" + result;
			} else {
				result = connectors + "\n" + row + "\n" + result;
			}

		}

		return result;
	}
}
