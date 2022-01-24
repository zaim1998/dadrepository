
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class ThreadClass extends Thread {
	
	public void printNumbers (String currThread) {
		
		LocalTime time = LocalTime.now();
		DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String threadTime = time.format(tf);
		
		for(int i=0; i<10; i++)
		{
			System.out.println("No. " + i + " : " + currThread + " at " + threadTime);;
		}
		
	}
	
	public void run() {
		
		// Get current thread
		Thread nowThread = Thread.currentThread();
		
		printNumbers(nowThread.getName());
	}

}