package testNG.helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class A1_Priority {
	
	@Test(priority = -1)
	public void login() {
		Reporter.log("Login", true);
	}
	
	@Test(priority = 0)
	public void testCase() {
		Reporter.log("Test cases", true);
	}
	
	@Test(priority = 1)
	public void logout() {
		Reporter.log("Logout", true);
	}

}
