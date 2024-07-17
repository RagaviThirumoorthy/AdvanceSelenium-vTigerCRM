package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganizationLink;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement createOrganizationText;
	
	@FindBy(name = "accountname")
	private WebElement nameTextfield;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "(//input[@name='assigntype'])[1]")
	private WebElement assignToUserRadioBtn;
	
	@FindBy(id = "phone")
	private WebElement phoneTextfield;
	
	@FindBy(id = "email1")
	private WebElement emailTextfield;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getCreateOrganizationLink() {
		return createOrganizationLink;
	}

	public WebElement getCreateOrganizationText() {
		return createOrganizationText;
	}

	public WebElement getNameTextfield() {
		return nameTextfield;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getAssignToUserRadioBtn() {
		return assignToUserRadioBtn;
	}

	public WebElement getPhoneTextfield() {
		return phoneTextfield;
	}
	
	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

}
