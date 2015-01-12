/**
 * Calculate the Fibonacci sequence
 * 
 * 1, 1, 2, 3, 5, 8, 13, 21...
 * f(n) = f(n-1) + f(n-2); f(1) = 1; f(0) = 1
 * 
 * @author Everyone
 */
public class Fibonacci {

	/**
	 * O(2^n)
	 * @precondition n >= 0
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {
		// enforcing precondition
		assert(n>=0);
		
		// base case -- does not call itself recursively, is simple enough to solve ourselves
		if (n == 1 || n == 0) return 1;
		
		// recursive case -- MUST make the problem (incrementally) smaller, or at least different
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	/**
	 * O(n)
	 * @param n
	 * @param numbers Our memory
	 * @return
	 */
	public static int reminiscentFibonacci(int n, int[] numbers) {
		if (numbers == null) {
			numbers = new int[n+1];
		} 

		if (numbers[n] > 0) {
			return numbers[n];
		}
		
		if (n == 1 || n == 0) {
			numbers[n] = 1;
		} else {
			numbers[n] = reminiscentFibonacci(n-1, numbers) + reminiscentFibonacci(n-2, numbers);
		}
		
		return numbers[n];
	}
	
	/**
	 * O(n) -- slightly faster, smaller memory footprint than reminiscentFibonacci()
	 * @param n
	 * @return
	 */
	public static int linearFibonacci(int n) {
		int f0 = 1;
		int f1 = 1;
		int current = 0;
		for (int i = 0; i < n; i++) {
			current = f1;
			f1 = f0 + f1;
			f0 = current;
		}
		return current;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonacci(13));
		System.out.println(linearFibonacci(13));
		System.out.println(reminiscentFibonacci(13, null));
	}

}
