public class AppArrayOverload {

	public static void main(String[] args) {
		
		Runnable statement = new ArrayData();
		Thread statementThread = new Thread(statement);
		statementThread.setName("word1");
	
		statementThread.start();


	}

}