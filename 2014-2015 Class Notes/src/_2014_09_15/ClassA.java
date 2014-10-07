package _2014_09_15;

public class ClassA {
	private int x; /* x is always positive */
	
	/**
	 * Accessor
	 * @return the current value of x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Mutator
	 * @param newValue the new value for x
	 */
	public void setX(int newValue) {
		int x = 2;
		
		if (this.x > 0) {
			this.x = newValue;			
		}
	}
	
	private char c;
}
