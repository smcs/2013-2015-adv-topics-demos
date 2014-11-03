
/* implement Thread instead of extending ActiveObject */
public class ThreadExample implements Runnable {
	
	public ThreadExample() {
		/* ... initialize stuff ... */
		
		/* create a new thread that is a copy of what we just set up and start it */
		new Thread(new ThreadExample(this)).start();
	}
	
	public ThreadExample(ThreadExample original) {
		/* copy original into this new thread */
	}
	
	public void run() {
		while (/* some condition */) {
			/* ... do the thread stuff ... */
			
			/* use sleep() instead of paus() */
			sleep(/* some decent interval */);
	}
}
