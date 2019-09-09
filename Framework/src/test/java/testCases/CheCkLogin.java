package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import commonClasses.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.*;

public class CheCkLogin {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
    
		driver = Config.setup(this.getClass().getSimpleName());
	   
	}

	@Test(dataProvider = "login")
	public void login(String userName, String password) throws IOException {

			Assert.assertEquals(Login.txtBoxUserName(driver, userName), true, "Error in inserting username");
			Assert.assertEquals(Login.txtBoxPassword(driver, password), true, "Error in inserting Password");
			Assert.assertEquals(Login.btnLogin(driver), true, "Error in clicking Login button");
			
			
		
		 
	}

	@DataProvider(name = "login")

	public Object[][] login() {

		Object[][] test = TestData.getTestData(
				"C:\\Users\\vijay\\git\\framework\\Framework\\src\\test\\java\\utility\\TestData.xlsx", "sheet1",
				this.getClass().getSimpleName());

		return test;
	}

	@AfterMethod

	public void clear() {
		
		driver.quit();
		Config.endSetup();
	}
	
	@AfterTest
	
	public void flush() {
		
		
	}
}