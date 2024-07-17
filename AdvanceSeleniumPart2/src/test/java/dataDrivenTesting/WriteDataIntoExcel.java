package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.createSheet("Sheet3");

		Row row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("url");
		row1.createCell(1).setCellValue("https://demowebshop.tricentis.com/");
		
		Row row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("email");
		row2.createCell(1).setCellValue("aarakavi27@gmail.com");
		
		Row row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("password");
		row3.createCell(1).setCellValue("Ragavi@DemoWeb");
		
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\testdata.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}

}
