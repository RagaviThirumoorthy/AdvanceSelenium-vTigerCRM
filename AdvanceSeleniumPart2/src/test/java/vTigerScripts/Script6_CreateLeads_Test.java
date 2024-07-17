package vTigerScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import pomRepo.LeadsPage;

public class Script6_CreateLeads_Test extends BaseClass {
	
	@Test
	public void script6_createLeads() throws EncryptedDocumentException, IOException, InterruptedException {
		
		LeadsPage lead = new LeadsPage(driver);
		lead.getLeadsLink().click();
		lead.getCreateLeadsLink().click();
		lead.getFirstNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Firstname", 0, 0));
		lead.getLastNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Lastname", 0, 0));
		lead.getCompanyTextfield().sendKeys(dataUtil.getDataFromExcelDF("Company",3 , 0));
		lead.getMobileTextfield().sendKeys(dataUtil.getDataFromExcelDF("Contacts", 0, 0));
		lead.getSaveButton().click();
		Thread.sleep(3000);
		
	}

}
