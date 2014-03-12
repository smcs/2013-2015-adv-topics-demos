public class Atom {
	private String name;
	private String symbol;
	private double weight;

	public Atom() {
		this("Hydrogen", "H", 1.00794);
	}

	public Atom(String name, String symbol, double weight) {
		this.name = name;
		this.symbol = symbol;
		this.weight = weight;
	}

	public Atom(Atom other) {
		this.name = new String(other.name);
		this.symbol = new String(other.symbol);
		this.weight = other.weight;
	}
	
	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getWeight() {
		return weight;
	}
	
	public String toString() {
		return symbol;
	}
}
