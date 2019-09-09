package commonClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.*;

public class Login {
	
	static Reports obj = new Reports();
	
	/*public static File objFile;
	public static FileInputStream objRepo;
	public static Properties propFile;*/
	
		public static boolean txtBoxUserName(WebDriver driver, String userName) throws IOException {
		
			/*objFile = new File("objectRepo.properties");
			objRepo = new FileInputStream(objFile);
			propFile = new Properties();
			propFile.load(objRepo);*/

		try {
			
			WebDriverWait wait = new WebDriverWait(driver,50);
			
					
				
			if (driver.findElement(By.xpath(Config.propFile.getProperty("loginDialog"))).isEnabled()) {

				driver.findElement(By.xpath(Config.propFile.getProperty("loginDialogClose"))).click();
			}

			driver.findElement(By.xpath(Config.propFile.getProperty("loginLink"))).click();

			driver.findElement(By.xpath(Config.propFile.getProperty("loginUserName")))
					.sendKeys(userName);
			
			return true;

		}

		catch (Exception e) {
			obj.log("Failed to enter username", "FAIL");
			System.out.println("Error Occurred" + e);
	        
			return false;
		}
	}

	public static boolean txtBoxPassword(WebDriver driver, String password) throws IOException {

		try {

			driver.findElement(By.xpath(Config.propFile.getProperty("loginPassowrd")))
					.sendKeys(password);
			return true;
		}

		catch (Exception e) {

			System.out.println("Error Occurred" + e);
			obj.log("Failed to enter Password", "FAIL");
			return false;
		}

	}

	public static boolean btnLogin(WebDriver driver) throws IOException {

		try {

			driver.findElement(By.xpath(Config.propFile.getProperty("loginBtn"))).click();
			return true;
		}

		catch (Exception e) {
			System.out.println("Error Occurred" + e);
			obj.log("Failed to click on Login button", "FAIL");
			return false;

		}
	}
	
			public static boolean verifyLoginFailed(WebDriver driver) throws IOException {
				
				
				try {
				String result = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).getText();
				
				if(result.equalsIgnoreCase("Please enter valid Email ID/Mobile number"))
					{obj.log("Login Invalid Verified", "PASS");
					return false;}
				else {
				obj.log("Test Case Failed...", "FAIL");
				return true;
				}
				
				}
				
				catch(Exception e) {
					
					System.out.println(e);
					obj.log("Test Case Failed...", "FAIL");
					return true;
				}
								
			}
				
	}

