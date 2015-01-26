
public class LinkedList<T> {
	private Node<T> head;
	
	public LinkedList() {
		head = null;
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if(head != null) {
			Node<T> finger = head;
			while (finger.next() != null) {
				finger = finger.next();
			}
			finger.next(newNode);
		} else {
			head = new Node(data);
		}
	}
	
	public T get(int index) {
		Node<T> finger = head;
		for (int i = 0; i < index && finger != null; i++) {
			finger = finger.next();
		}
		if (finger != null) {
			return finger.getData();
		} else {
			return null;
		}
	}
	
	public T set(int index, T data) {
		Node<T> finger = head;
		for (int i = 0; i < index && finger != null; i++) {
			finger = finger.next();
		}
		if (finger != null) {
			return finger.setData(data);
		} else {
			return null;
		}
	}
	
	public String toString() {
		return head.toString();
	}

	public Node<T> getHead() {
		return head;
	}
}
