package crmScripts;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.ContactsPage;
import pomRepo.LoginPage;

public class Script4_CreateContacts {

	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		
		ContactsPage contactsPage = new ContactsPage(driver);
		
		contactsPage.getContactsLink().click();
		contactsPage.getCreateContactsLink().click();
		contactsPage.getFirstNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Firstname", 0, 0));
		contactsPage.getLastNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Lastname", 0, 0));
		contactsPage.getAddOrganizationLink().click();
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		String childId = allId.iterator().next();
		driver.switchTo().window(childId);
		for(String id:allId) {
			driver.switchTo().window(id);
		}
		contactsPage.getSearchBox().sendKeys("Purplle");
		contactsPage.getOrganizationName().click();
		driver.switchTo().window(parentId);
		contactsPage.getMobileTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 2, 0));
		contactsPage.getSaveButton().click();
		
		Thread.sleep(3000);

	}

}