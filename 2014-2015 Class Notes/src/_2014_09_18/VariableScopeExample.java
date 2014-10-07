package _2014_09_18;

public class VariableScopeExample {

	/**
	 * Instance variables
	 * 
	 * Useful for variables needed in more than one method
	 * 
	 * Consolidate all variables in one place (easy to find)
	 * 
	 * Remember a value between function calls
	 * 
	 * If I'd like a class that will extend me to have access to the variable
	 */
	private int x, y;
	
	public void addOne() {
		x += 1;
		y += 1;
	}
	
	public void otherStuff() {
		/**
		 * Local variables
		 * 
		 * Reduce confusion about temporary variables
		 *
		 * Reduce memory footprint
		 * 
		 * Reduce accidental variable reuse
		 */
		double x, y;
		x = 21;
		y = 101;
	}
	
	public void doYourStuff() {
		addOne();
		addOne();
		System.out.println(x);
		System.out.println(y);
	}
}
