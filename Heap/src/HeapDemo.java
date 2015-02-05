
public class HeapDemo {

	public static void main(String[] args) {
		Heap<Integer> h = new Heap<Integer>();
		
		h.add(42);
		h.add(17);
		h.add(23);
		h.add(13);
		h.add(7);
		h.add(19);
		h.add(11);
		h.add(2);
		h.add(1);
		h.add(-213);
		h.add(4);
		
		System.out.println(h);

	}

}
