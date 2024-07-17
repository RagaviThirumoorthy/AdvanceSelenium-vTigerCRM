package crmScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.CampaignsPage;
import pomRepo.LoginPage;

public class Script5_CreateCampaigns {

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
		
		CampaignsPage campaignPage = new CampaignsPage(driver);
		WebDriverUtility.moveToElement(driver, campaignPage.getMoreLink());
		campaignPage.getCampaignsLink().click();
		campaignPage.getCreateCampaignsLink().click();
		campaignPage.getCampaignNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Campaigns", 0, 0));
		campaignPage.getSaveButton().click();
		
	}

}
