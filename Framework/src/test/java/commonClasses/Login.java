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
			Thread.sleep(5000);

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
			Thread.sleep(5000);
			
			return true;
		}

		catch (Exception e) {
			System.out.println("Error Occurred" + e);
			obj.log("Failed to click on Login button", "FAIL");
			return false;

		}
		
			
	}
	public static boolean chknLogin(WebDriver driver) throws IOException{
		try {
			
			String txt = driver.findElement(By.xpath(Config.propFile.getProperty("chkLogin"))).getText();
			
			String error1 = "Please enter valid Email ID/Mobile number";
			String error2 = "Your username or password is incorrect";
			if(txt.equalsIgnoreCase(error1) || txt.equalsIgnoreCase(error2))
				return false;
			else
				return true;
			
						
		}

		catch (Exception e) {
			System.out.println("Error Occurred" + e);
			obj.log("Failed to validate", "FAIL");
			return false;

		}
		
	}
	
							
	}

