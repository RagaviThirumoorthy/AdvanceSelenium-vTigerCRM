package crmScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibrary.DataUtility;
import genericLibrary.JavaUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.LoginPage;
import pomRepo.OrganizationsPage;

public class Script2_CreateOrganization {

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
		
		OrganizationsPage orgPage = new OrganizationsPage(driver);

		orgPage.getOrganizationLink().click();
		orgPage.getCreateOrganizationLink().click();
		JavaUtility javaUtil = new JavaUtility();
		int rNum = javaUtil.getRandomNumber();
		orgPage.getNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Organizations", 0, 0)+rNum);
		orgPage.getAssignToUserRadioBtn().click();
		orgPage.getPhoneTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 0, 0));
		orgPage.getSaveButton().click();	
		

	}

}
