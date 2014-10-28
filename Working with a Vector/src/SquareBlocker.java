import java.util.Vector;
import objectdraw.*;

public class SquareBlocker extends OTOS {

	public SquareBlocker(double x, double y, DrawingCanvas canvas, Vector<OTOS> everyoneElse) {
		super(everyoneElse);
		new FilledRect(x, y, x+10, y+10, canvas);
	}

}
