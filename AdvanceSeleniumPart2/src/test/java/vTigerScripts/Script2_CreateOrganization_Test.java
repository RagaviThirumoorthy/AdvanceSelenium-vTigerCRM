package vTigerScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.OrganizationsPage;

public class Script2_CreateOrganization_Test extends BaseClass {
	
	@Test(groups = {"organization"})
	public void script2_createOrganization() throws EncryptedDocumentException, IOException, InterruptedException {
		
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getOrganizationLink().click();
		Assert.assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		org.getCreateOrganizationLink().click();
		Assert.assertEquals(org.getCreateOrganizationText().isDisplayed(),true);
		JavaUtility javaUtil = new JavaUtility();
		String orgName = dataUtil.getDataFromExcelDF("Organizations", 3, 0)+javaUtil.getRandomNumber();
		org.getNameTextfield().sendKeys(orgName);
		Assert.assertEquals(org.getNameTextfield().getAttribute("value"), orgName);
		org.getPhoneTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 2, 0));
		org.getSaveButton().click();
		Assert.assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		Thread.sleep(2000);
	}

}
