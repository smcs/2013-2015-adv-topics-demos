import java.util.*;

public class Sorting {

	public static Vector<Integer> randomVector(int size) {
		Vector<Integer> returnValue = new Vector<Integer>();
		for(int i = 0; i < size; i++) {
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
}
