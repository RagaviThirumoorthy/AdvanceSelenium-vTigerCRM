package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement userNameTextfield;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='poweredBy']")
	private WebElement tigerText;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logoutButton;

	public WebElement getUserNameTextfield() {
		return userNameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getTigerText() {
		return tigerText;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	

}
