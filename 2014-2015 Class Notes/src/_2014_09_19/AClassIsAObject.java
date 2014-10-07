package _2014_09_19;

public class AClassIsAObject {

	private boolean trueOrFalse;
	private int myDataField = 17;
	private char aSingleLetterOrNumberOrWhatever;
	private float singlePrecisionFloatingPointNumber;
	private double doublePrecisionFloatingPointNumber;
	private String aBunchOfText;
	private SomeOtherFancyClass otherGuy; // has-a relationship
	
	private Integer imAnObject;
	private int imAPrimitive;
	
	private int imAnInstanceVariable;
	
	/**
	 * An accessor method
	 */
	public getImAnInstanceVariable() {
		return imAnInstanceVariable;
	}
	
	/**
	 * Constructor = Initializer
	 */
	public AClassIsAObject() {
		otherGuy = new SomeOtherFancyClass();
	}
	
	/**
	 * Method = Verb
	 */
	public void danceAJig() {
		char c = 'q';
		
		/* convert any letter to its upper case equivalent */
		c = (char) ((int) c - (int) 'a' + (int) 'A');
		
		/* if I were an alchemist... */
		Lead pb;
		pb = (Gold) pb;
		
		double pi = 3.14159;
		Integer pie = new Integer((int) pi);
		pi = pie.doubleValue();
		
		String s = pie.toString();
	}
	
	/**
	 * This does something really fancy.
	 * @param x some whole number
	 * @param y some real number
	 * @param dude the other guy that I'm working with
	 */
	public void fancyMethod(int x, double y, SomeOtherFancyClass dude) {
		
	}
}
