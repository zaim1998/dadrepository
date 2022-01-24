public class arrayThread implements Runnable{
	
	public void printData (String currentThread) {
			
			try {
				
				String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
				int repeat= 10;
				int dataSize = data.length;
				int newSize = dataSize*repeat;
				String[] result = new String[newSize];
				
					String text = "";
					for(int i=0; i<repeat; i ++) {
						result[i] = data[i%dataSize];
						text = text + " "+ result[i];
						System.out.println(currentThread + "->"+ text);
						
					}
				
				
				
				
			}
			
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	@Override
	public void run() {
		
		Thread currentThread = Thread.currentThread();
		printData(currentThread.getName());
		
	}

}