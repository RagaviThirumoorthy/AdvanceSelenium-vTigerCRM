package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.createSheet("Sheet5");
		int rowCount=0;
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("url1", "https://demowebshop.tricentis.com/");
		map.put("email1", "aarakavi27@gmail.com");
		map.put("password1", "Ragavi@DemoWeb");
		
		for(Entry<String, String> m : map.entrySet()) {
			Row row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(m.getKey());
			row.createCell(1).setCellValue(m.getValue());
		}
		
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\testdata.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.flush();
		
		
	}

}
