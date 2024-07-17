package vTigerScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.CampaignsPage;

public class Script5_CreateCampaigns_Test extends BaseClass{
	
	@Test
	public void script5_createCampaigns() throws EncryptedDocumentException, IOException, InterruptedException {
		
		CampaignsPage camPage = new CampaignsPage(driver);
		WebElement link = camPage.getMoreLink();
		WebDriverUtility.moveToElement(driver, link);
		camPage.getCampaignsLink().click();
		camPage.getCreateCampaignsLink().click();
		JavaUtility javaUtil = new JavaUtility();
		camPage.getCampaignNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Campaigns", 3, 0)+javaUtil.getRandomNumber());
		camPage.getSaveButton().click();
		Thread.sleep(3000);
		
	}

}
