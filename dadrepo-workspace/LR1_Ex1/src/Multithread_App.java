
public class Multithread_App {
	
public static void main(String[]args) {
		
		// create thread object with current time
		Thread th1 = new ThreadClass();
		Thread th2 = new ThreadClass();
		
		
		// create thread object with name
		Thread nowThread1 = new Thread(th1, "nowThread1");
		Thread nowThread2 = new Thread(th2, "nowThread2");
		
		
		// execute the thread
		nowThread1.start();
		nowThread2.start();
		
	}

}
