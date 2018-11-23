package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestData;

public class NewTest{
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		
		  System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.flipkart.com");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test (dataProvider = "login")
	public void login(String userName, String password) {
		
		if (driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]")).isEnabled()) {
			
			  driver.findElement(By.xpath("html/body/div[2]/div/div/button")).click();}
			
			driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div/div[3]/div[1]/div/a")).click();
			
			
			driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(userName);
			driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(password);
			driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		
	}
	
	@DataProvider(name="login")
	
	public Object[][] login(){
		
		
		Object[][] test = TestData.getExcelArray("C:\\Users\\vijay\\git\\framework\\Framework\\src\\test\\java\\utility\\TestData.xlsx", "sheet1", this.getClass().getSimpleName());
		
		return test;
	}
	
	
	@AfterMethod
	
	public void clear() {
		
		driver.close();
	}
}