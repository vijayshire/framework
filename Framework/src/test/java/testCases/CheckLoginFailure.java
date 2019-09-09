package testCases;

import org.testng.annotations.Test;

import commonClasses.Login;
import utility.Config;
import utility.TestData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CheckLoginFailure {
	
	WebDriver driver ;
	
	
	@Test(dataProvider = "login")
	public void loginFail(String userName, String password) throws IOException {

			Assert.assertEquals(Login.txtBoxUserName(driver, userName), true, "Error in inserting username");
			Assert.assertEquals(Login.txtBoxPassword(driver, password), true, "Error in inserting Password");
			Assert.assertEquals(Login.btnLogin(driver), true, "Error in clicking Login button");
			Assert.assertEquals(Login.verifyLoginFailed(driver), false, "User able to login with Invalid credential");
			
		}

	@DataProvider(name = "login")

	public Object[][] login() {

		Object[][] test = TestData.getTestData(
				"C:\\Users\\vijay\\git\\framework\\Framework\\src\\test\\java\\utility\\TestData.xlsx", "sheet1",
				this.getClass().getSimpleName());

		return test;
	}
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = Config.setup(this.getClass().getSimpleName());
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
	  Config.endSetup();
  }

}
