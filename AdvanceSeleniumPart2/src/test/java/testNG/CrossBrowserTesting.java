package testNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;

public class CrossBrowserTesting {
	
	WebDriver driver;
	DataUtility dataUtil=new DataUtility();

	@Parameters("browser")
	@Test
	public void launchBrowser(String bname) throws IOException {     //@Optional("chrome") -->its for executing the entire test in one browser from script
		
		if(bname.contains("chrome")) {
			driver = new ChromeDriver();
			WebDriverUtility.maximizeBrowser(driver);
			WebDriverUtility.implicitWait(driver);
			driver.get(dataUtil.getDataFromProperties("url"));
		}
		else if(bname.contains("firefox")) {
			driver = new FirefoxDriver();
			WebDriverUtility.maximizeBrowser(driver);
			WebDriverUtility.implicitWait(driver);
			driver.get(dataUtil.getDataFromProperties("url"));
		}else if(bname.contains("edge")) {
			driver = new EdgeDriver();
			WebDriverUtility.maximizeBrowser(driver);
			WebDriverUtility.implicitWait(driver);
			driver.get(dataUtil.getDataFromProperties("url"));
		}
	}

}
