import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo1 {

public static void main(String[] args) {
		
		
		SimpleArray sharedArray = new SimpleArray(6);
		
		ArrayWriter w1 = new ArrayWriter(1, sharedArray);
		ArrayWriter w2 = new ArrayWriter(11, sharedArray);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(w1);
		executor.execute(w2);
		executor.shutdown();
		
		try {
		
			boolean endFlag = executor.awaitTermination(1, TimeUnit.MINUTES);
			
			if(endFlag) {
				
				
				System.out.println("\nContent of SimpleArray");
				System.out.println(sharedArray);
				
			}else {
				
				System.out.println("Timed out while waiting for tasks to finish");
			}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		
	}

}