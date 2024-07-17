package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadsLink;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextfield;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextfield;
	
	@FindBy(name = "company")
	private WebElement companyTextfield;
	
	@FindBy(name = "mobile")
	private WebElement mobileTextfield;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getCreateLeadsLink() {
		return createLeadsLink;
	}

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getCompanyTextfield() {
		return companyTextfield;
	}

	public WebElement getMobileTextfield() {
		return mobileTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	

}
