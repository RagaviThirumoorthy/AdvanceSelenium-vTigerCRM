package vTigerScripts;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.BaseClass;
import pomRepo.ContactsPage;

public class Script4_CreateContacts_Test extends BaseClass{
	
	@Test
	public void script4_createContacts() throws EncryptedDocumentException, IOException, InterruptedException {
			
		ContactsPage contact = new ContactsPage(driver);
		contact.getContactsLink().click();
		test.log(Status.INFO, "User entered Contacts Page");
		contact.getCreateContactsLink().click();
		contact.getFirstNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Firstname", 0, 0));
		test.log(Status.INFO, "User entered First Name");
		contact.getLastNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Lastname", 0, 0));
		test.log(Status.INFO, "User entered Last Name");
		contact.getAddOrganizationLink().click();
		
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		for(String id: allId) {
			driver.switchTo().window(id);
		}
		contact.getSearchBox().sendKeys(dataUtil.getDataFromExcelDF("Organizations", 5, 0),Keys.ENTER);
		Thread.sleep(2000);
		contact.getOrganizationName().click();
		test.log(Status.INFO, "User added Organization");
		driver.switchTo().window(parentId);
		
		contact.getMobileTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 0, 0));
		test.log(Status.INFO, "User entered Mobile Number");
		contact.getSaveButton().click();
		test.log(Status.INFO, "User created New Contact!");
		Thread.sleep(3000);
		
		
	}

}
