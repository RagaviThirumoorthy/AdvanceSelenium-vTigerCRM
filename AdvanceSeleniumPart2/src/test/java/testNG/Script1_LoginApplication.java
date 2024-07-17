package testNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.DataUtility;
import genericLibrary.IConstant;
import genericLibrary.WebDriverUtility;

public class Script1_LoginApplication {
	
	@Test
	public void launch() throws IOException {
		WebDriver driver = new ChromeDriver();
		DataUtility dataUtil = new DataUtility();
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.implicitWait(driver);
		driver.get(dataUtil.getDataFromProperties("url"));
		Reporter.log("Launch with TestNG", true);
	}
}
