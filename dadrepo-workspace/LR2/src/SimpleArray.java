import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
	
		private final  int[] sharedData;
		private int currentIndex = 0;
		private final static SecureRandom random = new SecureRandom();
	
		public SimpleArray(int size) {
			
			sharedData = new int[size];
			
		}
		
		public synchronized void add(int value) {
			
			int pos = currentIndex;
			Thread currentThread = Thread.currentThread();

			try {
				
				Thread.sleep(random.nextInt(500));
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
		
			sharedData[pos] = value;
			System.out.printf("%s wrote %2d to element %d.\n",
					currentThread.getName(), value, pos);
			
			++currentIndex;
			System.out.printf("Next index to write is %d\n", currentIndex);
		}
		
		public String toString() {
			
			return Arrays.toString(sharedData);
			
		}

	}