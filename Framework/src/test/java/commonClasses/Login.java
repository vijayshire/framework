package commonClasses;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	FileInputStream objRepoFile = new FileInputStream("C:\\Users\\vijay\\git\\framework\\Framework\\objectRepo.properties");

	public static boolean txtBoxUserName(WebDriver driver, String userName) {

		try {

			if (driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]")).isEnabled()) {

				driver.findElement(By.xpath("html/body/div[2]/div/div/button")).click();
			}

			driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div/div[3]/div[1]/div/a")).click();

			driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"))
					.sendKeys(userName);

			return true;

		}

		catch (Exception e) {

			System.out.println("Error Occurred" + e);
			return false;
		}
	}

	public static boolean txtBoxPassword(WebDriver driver, String password) {

		try {

			driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"))
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

			driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			return true;
		}

		catch (Exception e) {
			System.out.println("Error Occurred" + e);
			return false;

		}
	}
}
