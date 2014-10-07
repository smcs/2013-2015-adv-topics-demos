package _2014_09_22;

public class BooleanStuff {

	public static void main(String[] args) {

		int a = 2, b = -12;

		/* short-circuit evaluation */
		if ((b != 0) && (3 / b > 0)) {
			System.out.println("true!");
		}

		if (b != 0) {
			if (3 / b > 0) {
				System.out.println("true!");
			} else {
				System.out.println("hi Jacoby!");
			}
		} else {
			System.out.println("false!");
		}
		
		
		if (a < 2) {
			
		} else {
			if (a < 5) {
				
			} else {
				if (a < 14) {
					
				} else {
					System.out.println("i give up");
				}
			}
		}
		
		if (a < 2) {
			
		}else if (a < 5) {
			
		} else if (a < 14) {
			
		} else {
			System.out.println("i give up");
		}
		
		if (a == 2) {
			
		} else if (a == 5) {
		
		} else if (a == 14) {
			
		} else {
			
		}

		switch (a) {
		case 2:
			System.out.println("A");
			break;
		case 5:
			System.out.println("B");			
			break;
		case 14:
			System.out.println("C");
			break;
		default:
			System.out.println("i give up");
		}
		
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		
		System.out.println("a = " + a + ", b = " + b);
	}

}
