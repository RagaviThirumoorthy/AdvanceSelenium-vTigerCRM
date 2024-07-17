package genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataUtility {

	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstant.propertiesFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	public String getDataFromExcel(String sheet,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheet).getRow(rowNumber).getCell(cellNumber).toString(); 
		return value;
	}
	
	public String getDataFromExcelDF(String sheet,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Cell cell = workbook.getSheet(sheet).getRow(rowNumber).getCell(cellNumber);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(cell);
		return value;
	}
	
	public String getDataFromJSON(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstant.jsonFilePath);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(fis);
		String value = node.get(key).asText();
		return value;
	}
	
	public static String getCurrentDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.toString().replace(':', '-');
		return date;
	}

}
