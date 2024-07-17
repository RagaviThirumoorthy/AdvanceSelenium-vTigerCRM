package testNG.helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class A5_DependsOnMethod {
	
	@Test
	public void login() {
		Reporter.log("Login Application",true);
	}
	
	@Test(dependsOnMethods = "login")
	public void addToCart() {
		Reporter.log("Add the products to Cart",true);
	}
	
	@Test(dependsOnMethods = "login")
	public void logout() {
		Reporter.log("Logout Application",true);
	}
}
