package genericLibrary;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pomRepo.LoginPage;

@Listeners(ListenersUtil.class)
public class BaseClass {
	
	public static WebDriver driver;
	public DataUtility dataUtil = new DataUtility();
	LoginPage loginPage;
	public static ExtentSparkReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		Reporter.log("Report Generation", true);
		reporter = new ExtentSparkReporter(IConstant.reportPath);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(@Optional("chrome") String bname) throws IOException {
		if(bname.contains("chrome")) {
			driver = new ChromeDriver();
		}else if(bname.contains("edge")) {
			driver = new EdgeDriver();
		}
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.implicitWait(driver);
		driver.get(dataUtil.getDataFromProperties("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) throws IOException {
		test = reports.createTest(method.getName());
		Reporter.log(method.getName(), true);
		loginPage = new LoginPage(driver);
		loginPage.getUserNameTextfield().sendKeys(dataUtil.getDataFromProperties("username"));
		loginPage.getPasswordTextfield().sendKeys(dataUtil.getDataFromProperties("password"));
		loginPage.getLoginButton().click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		loginPage = new LoginPage(driver);
		loginPage.getAdminIcon().click();
		loginPage.getLogoutButton().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		WebDriverUtility.closeBrowser(driver);
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		Reporter.log("Close Report", true);
		reports.flush();
	}
}
