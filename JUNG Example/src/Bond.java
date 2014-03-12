public class Bond {
	private Atom start, end;
	private double weight;

	public Bond(Atom start, Atom end) {
		this(start, end, 1.0);
	}

	public Bond(Atom start, Atom end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public Bond(Bond other) {
		this.start = other.start;
		this.end = other.end;
		this.weight = other.weight;
	}

	public Atom getStart() {
		return start;
	}

	public Atom getEnd() {
		return end;
	}

	public double getWeight() {
		return weight;
	}
	
	public String toString() {
		return Double.toString(weight);
	}
}
