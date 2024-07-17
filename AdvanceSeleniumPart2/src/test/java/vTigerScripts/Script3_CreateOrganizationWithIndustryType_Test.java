package vTigerScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.OrganizationsPage;


public class Script3_CreateOrganizationWithIndustryType_Test extends BaseClass{
	
	@Test(groups = {"organization"})
	public void script3_createOrganizationWithIndustryType() throws EncryptedDocumentException, IOException, InterruptedException {
		
		OrganizationsPage org = new OrganizationsPage(driver);
		SoftAssert sa = new SoftAssert();
		org.getOrganizationLink().click();
		sa.assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		org.getCreateOrganizationLink().click();
		sa.assertEquals(org.getCreateOrganizationText().isDisplayed(), true);
		JavaUtility javaUtil = new JavaUtility();
		String orgName = dataUtil.getDataFromExcelDF("Organizations", 5, 0)+javaUtil.getRandomNumber();
		org.getNameTextfield().sendKeys(orgName);
		sa.assertEquals(org.getNameTextfield().getAttribute("value"), orgName);
		WebElement dropdown =  org.getIndustryDropdown();
		WebDriverUtility.selectDropdownByValue(dropdown, dataUtil.getDataFromExcelDF("Industry", 0, 0));
		org.getPhoneTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 3, 0));
		org.getSaveButton().click();
		sa.assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		Thread.sleep(2000);
		sa.assertAll();
	
	}

}
