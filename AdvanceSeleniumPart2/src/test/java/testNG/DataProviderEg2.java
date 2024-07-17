package testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;
import pomRepo.LoginPage;
import pomRepo.OrganizationsPage;

public class DataProviderEg2 {

	@DataProvider
	public String[][] testData() throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("OrgData");
		int rowNo =  sheet.getPhysicalNumberOfRows();
		int cellNo = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rowNo][cellNo];
		DataFormatter df = new DataFormatter();
		for(int i=0;i<rowNo;i++) {
			for(int j=0;j<cellNo;j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	@Test(dataProvider = "testData")
	public void organization(String[] data) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		DataUtility dataUtil = new DataUtility();
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.implicitWait(driver);
		driver.get(dataUtil.getDataFromProperties("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTextfield().sendKeys(dataUtil.getDataFromProperties("username"));
		lp.getPasswordTextfield().sendKeys(dataUtil.getDataFromProperties("password"));
		lp.getLoginButton().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrganizationLink().click();
		op.getCreateOrganizationLink().click();
		op.getNameTextfield().sendKeys(data[0]);
		op.getPhoneTextfield().sendKeys(data[1]);
		op.getEmailTextfield().sendKeys(data[2]);
		
	}

}
