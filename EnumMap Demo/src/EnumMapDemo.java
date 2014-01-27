import java.util.*;

public class EnumMapDemo {

	/* declare your enumerated type and list all possible values */
	public enum CompassDirection {
		NORTH, SOUTH, EAST, WEST
	}

	public static void main(String[] args) {
		/*
		 * map your enumerated type on to some other relevant value -- e.g. a
		 * booleamn value
		 */
		EnumMap<CompassDirection, Boolean> directionTest = new EnumMap<CompassDirection, Boolean>(
				CompassDirection.class);

		/* set all of the directions to false, initially */
		for (CompassDirection dir : CompassDirection.values()) {
			directionTest.put(dir, false);
		}

		/* set a specific direction to true */
		directionTest.put(CompassDirection.NORTH, true);
		
		/* test a specific direction */
		if (directionTest.get(CompassDirection.EAST)) {
			/* do the East-y thing */
		}

	}

}
