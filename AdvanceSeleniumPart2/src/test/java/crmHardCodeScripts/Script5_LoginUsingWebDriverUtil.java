package crmHardCodeScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;

public class Script5_LoginUsingWebDriverUtil {

	public static void main(String[] args) throws IOException {
		DataUtility dataUtil = new DataUtility();
		
		WebDriver driver = new ChromeDriver();
		driver.get(dataUtil.getDataFromProperties("url"));
		
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.implicitWait(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(dataUtil.getDataFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(dataUtil.getDataFromProperties("password"));
		driver.findElement(By.id("submitButton")).click();

	}

}
