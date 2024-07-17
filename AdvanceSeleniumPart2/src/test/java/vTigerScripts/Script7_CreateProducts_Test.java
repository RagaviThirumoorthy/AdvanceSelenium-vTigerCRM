package vTigerScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaUtility;
import pomRepo.ProductsPage;

public class Script7_CreateProducts_Test extends BaseClass{
	
	@Test
	public void script7_createProducts() throws EncryptedDocumentException, IOException, InterruptedException {
		ProductsPage product = new ProductsPage(driver);
		product.getProductsLink().click();
		product.getCreateProductsLink().click();
		JavaUtility javaUtil = new JavaUtility();
		product.getProductNameTextfield().sendKeys(dataUtil.getDataFromExcelDF("Products", 1, 0)+javaUtil.getRandomNumber());
		product.getSaveButton().click();
		Thread.sleep(3000);
		
	}

}
