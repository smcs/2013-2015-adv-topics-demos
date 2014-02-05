import java.util.*;

public class Node {

	private int id;
	private int p;
	private int Z;
	private int Element;
	private Vector<Bond> bonds;

	public Node() {
		bonds = new Vector<Bond>();
	}
	
	public String toString() {
		return id + " " + Element;
	}

	public void addBond(Bond b) {
		bonds.add(b);
	}
	
	public int getBondCount() {
		/* NOTA BENE: we are completely ignoring order here */
		return bonds.size();
	}
}
