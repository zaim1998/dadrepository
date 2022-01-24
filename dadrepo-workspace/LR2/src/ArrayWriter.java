public class ArrayWriter implements Runnable {
	
	private final SimpleArray sharedSimpleArray;
	private int startValue;

	public ArrayWriter(int value, SimpleArray simpleArray) {
		
		startValue = value;
		sharedSimpleArray = simpleArray;
	
	}

	@Override
	public void run() {
		
		for(int i= startValue; i < startValue + 3; i++) {
			sharedSimpleArray.add(i);
		}
		
	}
	
	
	

}