import java.util.*;

public class Bar {
	private int x, y, z;
	private double a, b, c;

	public Bar() {
		Random rand = new Random();
		setX(rand.nextInt());
		setY(rand.nextInt());
		setZ(rand.nextInt());
		setA(rand.nextDouble());
		setB(rand.nextDouble());
		setC(rand.nextDouble());
	}

	public Bar(int x, int y, int z, double a, double b, double c) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int setX(int newValue) {
		int oldValue = x;
		x = newValue;
		return oldValue;
	}

	public int setY(int newValue) {
		int oldValue = y;
		y = newValue;
		return oldValue;
	}

	public int setZ(int newValue) {
		int oldValue = z;
		z = newValue;
		return oldValue;
	}

	public double setA(double newValue) {
		double oldValue = a;
		a = newValue;
		return oldValue;
	}

	public double setB(double newValue) {
		double oldValue = b;
		b = newValue;
		return oldValue;
	}

	public double setC(double newValue) {
		double oldValue = c;
		c = newValue;
		return oldValue;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public String toString() {
		return new String("(" + x + ", " + y + ", " + z + "; " + a + ", " + b
				+ ", " + c + ")");
	}
}