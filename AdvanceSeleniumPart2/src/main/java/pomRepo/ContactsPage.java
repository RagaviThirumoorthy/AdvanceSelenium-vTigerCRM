package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactsLink;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextfield;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextfield;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement addOrganizationLink;
	
	@FindBy(id = "search_txt")
	private WebElement searchBox;
	
	@FindBy(xpath = "//a[contains(@onclick,'set_return_contact_address')]")
	private WebElement organizationName;
	
	@FindBy(id = "mobile")
	private WebElement mobileTextfield;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCreateContactsLink() {
		return createContactsLink;
	}

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getAddOrganizationLink() {
		return addOrganizationLink;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getMobileTextfield() {
		return mobileTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
