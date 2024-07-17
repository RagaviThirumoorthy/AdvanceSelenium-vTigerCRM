package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromProperties {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\testdata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("email"));
		System.out.println(prop.getProperty("password"));

	}

}
