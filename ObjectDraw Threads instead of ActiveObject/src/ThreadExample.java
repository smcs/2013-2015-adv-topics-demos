
/* implement Runnable instead of extending ActiveObject */
public class ThreadExample implements Runnable {
	
	public ThreadExample() {
		/* ... initialize stuff ... */
		
		/* create a new thread that is a copy of what we just set up and start it */
		new Thread(this).start();
	}
	
	public void run() {
		while (/* some condition */) {
			/* ... do the thread stuff ... */
			
			/* use sleep() instead of pause() */
			try {
				Thread.sleep(/* some decent interval */);
			} catch (InterruptedException e) {
				// ignore the exception -- we don't care
			}
		}
	}
}
