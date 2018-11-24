package testCases;

import java.util.concurrent.TimeUnit;
import commonClasses.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestData;

public class NewTest {

	WebDriver driver = null;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "login")
	public void login(String userName, String password) {

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

		driver.close();
	}
}