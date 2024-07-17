package testNG.helperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;

public class A2_InvocationCount {
	
	@Test(invocationCount = 2,priority = 1)
	public void launchApplication() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.implicitWait(driver);
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(invocationCount = 5,priority = -1)
	public void demo() {
		Reporter.log("TestNG",true);
	}

}
