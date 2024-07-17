package crmHardCodeScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Script4_CreateContacts {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream("./src//test//resources//CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//1. Fetch common data from properties file
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		
		//2. Login
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		//3. Create Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Ragavi");
		driver.findElement(By.name("lastname")).sendKeys("T");
		
		//4. Add Organization
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		String childId = allId.iterator().next();
		driver.switchTo().window(childId);
		for(String id:allId) {
			driver.switchTo().window(id);
		}
		driver.findElement(By.id("search_txt")).sendKeys("Apple",Keys.ENTER);
		driver.findElement(By.linkText("Apple")).click();
		
		//5. Save it
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		
		//6. Log out
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out"));
		Thread.sleep(2000);
		
		//7.Close the browser
		driver.quit();
		
	}

}
