package crmScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.LoginPage;

public class Script1_LoginApplication {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		DataUtility dataUtil = new DataUtility();
		
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.implicitWait(driver);
		driver.get(dataUtil.getDataFromProperties("url"));
		
		LoginPage loginPage = new LoginPage(driver);
			
		System.out.println(loginPage.getTigerText().getText());
		loginPage.getUserNameTextfield().sendKeys(dataUtil.getDataFromProperties("username"));;
		loginPage.getPasswordTextfield().sendKeys(dataUtil.getDataFromProperties("password"));
		loginPage.getLoginButton().click();
	}

}
