package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataIntoProperties {

	public static void main(String[] args) throws IOException {
	
		Properties prop = new Properties();
		
		prop.setProperty("url", "https://demowebshop.tricentis.com/");
		prop.setProperty("email", "aarakavi27@gmail.com");
		prop.setProperty("password", "Ragavi@DemoWeb");
		
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\test.properties");
		prop.store(fos, "test");
		System.out.println("Values inserted");

	}

}
