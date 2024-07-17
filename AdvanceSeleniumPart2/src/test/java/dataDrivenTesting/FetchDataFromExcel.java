package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
//		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(2).getCell(1).getNumericCellValue());
//		System.out.println(sheet.getRow(3).getCell(3).getBooleanCellValue());
		
		Cell cell1 = sheet.getRow(0).getCell(0);
		Cell cell2 = sheet.getRow(2).getCell(1);
		Cell cell3 = sheet.getRow(3).getCell(3);
		
		DataFormatter data = new DataFormatter();
		System.out.println(data.formatCellValue(cell1));
		System.out.println(data.formatCellValue(cell2));
		System.out.println(data.formatCellValue(cell3));

	}

}
