package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchDataFromJson {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src//test//resources//JsonFile.json");
		
		ObjectMapper jsonData = new ObjectMapper();
		
		JsonNode node = jsonData.readTree(fis);
		
		System.out.println(node.get("url").asText());
		System.out.println(node.get("email").asText());
		System.out.println(node.get("password").asText());
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(node.get("url").asText());
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();		
		driver.findElement(By.id("Email")).sendKeys(node.get("email").asText());
		driver.findElement(By.id("Password")).sendKeys(node.get("password").asText());
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.quit();

	}

}
