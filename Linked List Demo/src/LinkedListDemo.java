
public class LinkedListDemo {
	
	public static void main(String args[]) {
		LinkedList<Integer> myList = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			myList.add(i);
		}
		System.out.println(myList.getHead());
		
		Node<Integer> a, b, c;
		a = new Node<Integer>(42);
		b = new Node<Integer>(17);
		c = new Node<Integer>(-3);
		
		a.next(c);
		c.next(b);
		
		System.out.println(a);
		
		a.next(myList.getHead());
		System.out.println(a);
	}
}
