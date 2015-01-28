import java.util.*;
import net.sourceforge.sizeof.*;

/**
 * @see <a href="http://sizeof.sourceforge.net/">java.SizeOf</a> (SourceForge)
 * @see <a
 *      href="http://www.javaworld.com/article/2077408/core-java/sizeof-for-java.html">Sizeof
 *      for Java</a> (JavaWorld, 2003)
 * @see <a
 *      href="http://stackoverflow.com/questions/52353/in-java-what-is-the-best-way-to-determine-the-size-of-an-object">In
 *      Java, what is the best way to determine the size of an object?</a>
 *      (Stack Overflow)
 * 
 * @author Seth Battis <sethbattis@stmarksschool.org>
 */
public class SizeOfExample {

	public static void main(String[] args) {
		SizeOf.skipStaticField(true); /*
									 * java.sizeOf will not compute static
									 * fields
									 */
		SizeOf.skipFinalField(true); /*
									 * java.sizeOf will not compute final fields
									 */

		int i = 3;
		String s = "Hello world";
		Vector<Integer> v = new Vector<Integer>(10);
		int a[] = new int[10];

		System.out.print("int i = " + i + " (");
		System.out.print(SizeOf.deepSizeOf(i));
		System.out.println(" bytes)");
		
		System.out.print("String s = \"" + s + "\" (");
		System.out.print(SizeOf.deepSizeOf(s));
		System.out.println(" bytes)");
		
		System.out.print("Vector<Integer> v = " + v + " (");
		System.out.print(SizeOf.deepSizeOf(v));
		System.out.println(" bytes)");
		
		System.out.print("int a[] = " + a + " (");
		System.out.print(SizeOf.deepSizeOf(a));
		System.out.println(" bytes)");


	}
}
