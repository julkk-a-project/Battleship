package main;

public class Waiter {

	private Object o1 = new Object();
	private Object o2 = new Object();
	private boolean wait = true;
	
	public synchronized void waiter() {
		wait = true;
		//synchronized(o1) {
		while (wait) {
			try {
				System.out.println("waiting");
				wait();
				wait = false;
				System.out.println("waited");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		//}
		
		
	}
	public synchronized void waker() {
		//synchronized(o2) {
			System.out.println("asd");
			notifyAll();
			System.out.println("asd2");

	}

}
