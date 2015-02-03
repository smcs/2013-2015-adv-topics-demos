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
	
	private void swap (int indexA, int indexB) {
		T temp = heap.get(indexA);
		heap.set(indexA, heap.get(indexB));
		heap.set(indexB, temp);
	}

	public void add(T data) {
		heap.addElement(data);
		int newElementIndex = heap.size() - 1;
		int parentIndex = parent(newElementIndex);
		while (newElementIndex > 0 && heap.get(newElementIndex).compareTo(heap.get(parentIndex)) > 0) {
			swap(newElementIndex, parentIndex);
			newElementIndex = parentIndex;
		}
	}
	
	public T decapitate() {
		
	}
}
