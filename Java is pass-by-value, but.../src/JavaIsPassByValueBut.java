public class JavaIsPassByValueBut {

	/*
	 * note that if I change param to final:
	 * 
	 * public static void javaPassesByValue(final double[] param()
	 * 
	 * I will _not_ be able to change the value of param -- that is, I will not
	 * be able to re-allocate the array and have param reference the new array,
	 * as I do below.
	 */
	public static void javaPassesByValue(double[] param) {
		param = new double[(int) Math.pow(param.length, 2)];
	}

	public static void arrayByReference(double[] param) {
		for (int i = 0; i < param.length; i++) {
			param[i] = i;
		}
	}

	public static void main(String[] args) {
		double[] array = new double[10];

		System.out.println("We start with an array that is " + array.length
				+ " elements long. array[3] is " + array[3]);

		/*
		 * Java passes parameters by value... but it's just that the value being
		 * passed is a reference to the array -- so the original array is
		 * referenced and changeable
		 */
		arrayByReference(array);
		System.out.println("array[3] is now " + array[3]);

		/*
		 * However, note that if I try to reference a new array within the
		 * method, it has no impact on my original parameter -- which was passed
		 * _by value_
		 */
		javaPassesByValue(array);
		System.out.println("array.length is still " + array.length);

	}

}
