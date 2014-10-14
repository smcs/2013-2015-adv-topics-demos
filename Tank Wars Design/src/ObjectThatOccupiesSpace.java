public class ObjectThatOccupiesSpace {
	protected Location centerPoint;

	/* also everyone needs to store their area somehow */

	public boolean overlap(ObjectThatOccupiesSpace other) {
		/* really, really hoping that all extending class override me! */
		return false;
	}

	public void draw() {
		/* stub... extending classes need to override this too! */
	}
}