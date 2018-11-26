package commonClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.*;

public class Login {
	
	static Reports obj = new Reports();
	
	/*public static File objFile;
	public static FileInputStream objRepo;
	public static Properties propFile;*/
	
		public static boolean txtBoxUserName(WebDriver driver, String userName) {
		
			/*objFile = new File("objectRepo.properties");
			objRepo = new FileInputStream(objFile);
			propFile = new Properties();
			propFile.load(objRepo);*/

		try {
			
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

	public static boolean txtBoxPassword(WebDriver driver, String password) {

		try {

			driver.findElement(By.xpath(Config.propFile.getProperty("loginPassowrd")))
					.sendKeys(password);
			return true;
		}

		catch (Exception e) {

			System.out.println("Error Occurred" + e);
			return false;
		}

	}

	public static boolean btnLogin(WebDriver driver) {

		try {

			driver.findElement(By.xpath(Config.propFile.getProperty("loginBtn"))).click();
			return true;
		}

		catch (Exception e) {
			System.out.println("Error Occurred" + e);
			return false;

		}
	}
}
