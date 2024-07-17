package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("TestCaseData");
		int rowsCount = sheet.getPhysicalNumberOfRows();
		int cellsCount =  sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0;i<rowsCount;i++){
			for(int j=0;j<cellsCount;j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				DataFormatter df = new DataFormatter();
				System.out.println(df.formatCellValue(cell));;
			}
		}

	}

}
