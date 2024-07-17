package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEg1 {

	@DataProvider
	public String[][] getData(){
		
		String[][] data = new String[2][3];
		data[0][0] = "Ragavi";
		data[0][1] = "B+";
		data[0][2] = "Ragavi@gmail.com";
		
		data[1][0] = "Navani";
		data[1][1] = "A+";
		data[1][2] = "Navani@gmail.com";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void printData(String[] testdata) {
		for(int i=0;i<testdata.length;i++) {
			System.out.println(testdata[i]);
		}
	}
}
