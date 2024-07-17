package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet3");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows: "+rowCount);
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of columns: "+colCount);
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for(int i=0;i<rowCount;i++) {
			String key = sheet.getRow(i).getCell(0).toString();
			String value = sheet.getRow(i).getCell(1).toString();
			map.put(key, value);
		}
		
		for(Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey()+" : "+m.getValue());
		}

	}

}
