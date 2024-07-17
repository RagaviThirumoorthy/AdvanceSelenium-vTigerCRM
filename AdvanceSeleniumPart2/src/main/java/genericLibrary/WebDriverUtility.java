package genericLibrary;

/*
* @author Ragavi T
*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void refreshThePage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public static void goForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public static void goBackward(WebDriver driver) {
		driver.navigate().back();
	}
	
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void explicitWaitForElementClickability(WebDriver driver,By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void explicitWaitForElementVisibility(WebDriver driver,By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void switchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public static void switchBackToParentPage(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public static void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void selectDropdownByValue(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}
	
	public static void selectDropdownByVisibleText(WebElement dropdown, String text) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}
	
	public static void deSelectDropdownByVisibleText(WebElement dropdown, String text) {
		Select select = new Select(dropdown);
		select.deselectByVisibleText(text);
	}
	
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public static void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public static void moveToElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void clickOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	
	public static void doubleClickOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public static void contextClickOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public static void scrollUp(WebDriver driver) {
		Actions act = new Actions(driver);
		act.scrollByAmount(0, -500);
	}
	
	public static void scrollDown(WebDriver driver) {
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500);
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
