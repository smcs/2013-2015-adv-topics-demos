import objectdraw.*;

public class ActiveObjectExample extends ActiveObject {
	
	public ActiveObjectExample() {
		/* ... do some stuff ... */
		
		start();
	}
	
	public void run() {
		while (/* some condition */) {
			/* ... do the thread stuff ... */
			pause(/* some decent interval */);
		}
	}
}
