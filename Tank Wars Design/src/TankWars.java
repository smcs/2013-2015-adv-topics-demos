import java.util.*;

import objectdraw.*;

public class TankWars extends WindowController {
	private Vector<ObjectThatOccupiesSpace> everything;

	public void begin() {
		everything = new Vector<ObjectThatOccupiesSpace>();
		
		Tank tank1 = new Tank(new Location(100, 100), 45, canvas);
		Tank tank2 = new Tank(new Location(150, 150), 135, canvas);
		
		everything.add(tank1);
		everything.add(tank2);
		
		if (everything.get(1).getClass() == Tank.class) {
			
		}
	}
}
