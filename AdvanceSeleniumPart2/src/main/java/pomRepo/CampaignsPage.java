package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")	
	private WebElement createCampaignsLink;
	
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextfield;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getCreateCampaignsLink() {
		return createCampaignsLink;
	}

	public WebElement getCampaignNameTextfield() {
		return campaignNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

}
