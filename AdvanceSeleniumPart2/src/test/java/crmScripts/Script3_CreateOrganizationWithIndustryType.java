package crmScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genericLibrary.DataUtility;
import genericLibrary.JavaUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.LoginPage;
import pomRepo.OrganizationsPage;

public class Script3_CreateOrganizationWithIndustryType {

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
//		JavaUtility javaUtil = new JavaUtility();
//		int rNum = javaUtil.getRandomNumber();
		orgPage.getNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Organizations", 1, 0));
		orgPage.getAssignToUserRadioBtn().click();
		WebDriverUtility.selectDropdownByValue(orgPage.getIndustryDropdown(), dataUtil.getDataFromExcelDF("Industry", 0, 0));
		orgPage.getPhoneTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 1, 0));
		orgPage.getSaveButton().click();	

	}

}
