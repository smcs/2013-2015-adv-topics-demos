
/* implement Thread instead of extending ActiveObject */
public class ThreadExample implements Thread {
	
	public ThreadExample() {
		/* ... do some stuff ... */
		
		start();
	}
	
	public void run() {
		while (/* some condition */) {
			/* ... do the thread stuff ... */
			
			/* use sleep() instead of paus() */
			sleep(/* some decent interval */);
	}
}
