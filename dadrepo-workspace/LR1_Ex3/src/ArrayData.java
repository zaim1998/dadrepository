import java.util.List;
import java.util.Arrays;
import java.util.Collections;


public class ArrayData implements Runnable {

	String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
	int repeat= 10;
	int dataSize = data.length;
	int newSize = dataSize*repeat;
	
	String[] result = new String[newSize];
	
	public void printArray () {
		String text = "";
		for(int i=0; i<repeat; i ++) {
			result[i] = data[i%dataSize];
			text = text + " "+ result[i];
			System.out.println(text);
		}
	
	} 
	
	public void randomData(String currentThread) {
		try {
			
			String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
			
			List<String> list = Arrays.asList(data);
			Collections.shuffle(list);
			list.toArray(data);
			for(String element:data) {
							
			System.out.println(currentThread + "->"+element);
			
			//Suspend the current thread for 5 milliseconds
			Thread.sleep(5000);
							
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void run() {
		//Get current thread
		Thread currentThread = Thread.currentThread();
		
		//Execute task
		printArray();
		randomData(currentThread.getName());
		
	}
	
}