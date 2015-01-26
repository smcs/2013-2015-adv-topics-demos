
public class Node<T> {
	private T data;
	private Node next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node(T data, Node n) {
		this.data = data;
		this.next = n;
	}
	
	public Node<T> next() {
		return next;
	}

	public void next(Node<T> newNode) {
		if (next == null) {
			next = newNode;
		} else {
			Node<T> temp = next;
			next = newNode;
			Node<T> finger = newNode.next();
			while (finger.next() != null) {
				finger = finger.next();
			}
			finger.next(temp);
		}
	}

	public T getData() {
		return data;
	}
	
	public T setData(T data) {
		T temp = this.data;
		this.data = data;
		return temp;
	}
	
	public String toString() {
		if (next == null) {
			return data.toString() + " . ";
		} else {
			return data.toString() + " -> " + next.toString();
		}
	}
}
