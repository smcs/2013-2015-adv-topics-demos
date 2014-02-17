import java.util.*;

public class Foo {
	private String[] subject = { "aardvark", "buffalo", "cat", "dog",
			"elephant", "fox", "goose", "horse", "ibex", "jackalope", "K", "L",
			"mongoose", "nutria", "octopus", "peacock", "Q", "rooster",
			"snake", "turkey", "U", "viper", "wombat", "X", "yak", "zebra" };
	private String[] verb = { "eats", "squashes", "stomps", "throws",
			"resuscitates" };
	private String[] object = { "apple", "banana", "cherry", "dogbone", "E",
			"fondue", "ghee" };

	private String value;

	public Foo() {
		Random rand = new Random();
		value = new String("The "
				+ subject[Math.abs(rand.nextInt()) % subject.length] + " "
				+ verb[Math.abs(rand.nextInt()) % verb.length] + " the "
				+ object[Math.abs(rand.nextInt()) % object.length] + ".");
	}
	
	public Foo(String value) {
		this.value = new String(value);
	}

	public String setValue(String s) {
		String oldValue = value;
		value = new String(s);
		return oldValue;
	}

	public String getValue() {
		return new String(value);
	}
	
	public String toString() {
		return new String("\"" + value + "\"");
	}
}