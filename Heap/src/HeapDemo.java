
public class HeapDemo {

	public static void main(String[] args) {
		Heap<Integer> h = new Heap<Integer>();
		
		h.add(17);
		System.out.println(h);
		h.add(19);
		System.out.println(h);
		h.add(21);
		System.out.println(h);
		h.add(3);
		System.out.println(h);
		h.add(42);
		System.out.println(h);		

	}

}
