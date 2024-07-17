package genericLibrary;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(100);
		return number;
	}

}
