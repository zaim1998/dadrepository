public class ArrayThreadApp {

public static void main(String[] args) {
		
		Runnable numerable = new ArrayThread();
		Thread numberThread = new Thread(numerable);
		numberThread.setName("text");
		
		Runnable statement = new RandomText();
		Thread statementThread = new Thread(statement);
		statementThread.setName("word1/word2");
		
		numberThread.start();
		statementThread.start();


	}

}