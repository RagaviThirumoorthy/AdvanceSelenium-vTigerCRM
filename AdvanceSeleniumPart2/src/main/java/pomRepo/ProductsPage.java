package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductsLink;
	
	@FindBy(name = "productname")
	private WebElement productNameTextfield;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCreateProductsLink() {
		return createProductsLink;
	}

	public WebElement getProductNameTextfield() {
		return productNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	

}
