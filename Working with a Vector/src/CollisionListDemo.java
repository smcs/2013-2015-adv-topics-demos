import java.util.*;
import objectdraw.*;

public class CollisionListDemo extends WindowController {
	
	private Vector<OTOS> everything;
	
	public void begin() {
		everything = new Vector<OTOS>();
		RollyPolly molly = new RollyPolly(everything);
		
		for (int i = 0; i < 100; i++) {
			new SquareBlocker(0, i*12, canvas, everything);
		}
	}

}
