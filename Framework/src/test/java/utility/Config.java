package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Config extends AbstractWebDriverEventListener {

	public static WebDriver driver1;
	public static Config eventListner;
	public static EventFiringWebDriver driver;
	public static String testCaseName;
	public static String testpath;
	public static int i = 0;
	public static File outputFile;
	public static Properties propFile;
	public static FileInputStream objRepoFile;
	public static File repoFile;
	public static int timeOut;
	public static String url;
	public static Reports objReports = new Reports();
	public static WebDriver setup(String testName) {
		testCaseName = testName;
		Config.folderSetup(testCaseName);
		Config.setObjRepo();
		Reports.createReports(testpath+"\\"+"extent.html",testCaseName);
		Config.setBrowser();
		return driver;

	}

	public static void folderSetup(String testCaseName) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		outputFile = new File("C:\\Users\\vijay\\git\\framework\\Framework\\test-output\\vijay-report\\" + timeStamp);
		if (!outputFile.exists()) {

			outputFile.mkdir();
			System.out.println("Parent Folder Created: "+outputFile);
		}

		testpath = outputFile.getAbsolutePath();

		outputFile = new File(testpath + "//" + testCaseName);

		if (!outputFile.exists()) {

			outputFile.mkdir();
			System.out.println("Test Case Folder Created: "+outputFile);

		}
		
		//testpath = outputFile.getAbsolutePath();

	}

	public static void setObjRepo() {

		try {
			repoFile = new File("C:\\Users\\vijay\\git\\framework\\Framework\\objectRepo.properties");

			objRepoFile = new FileInputStream(repoFile);
			propFile = new Properties();
			propFile.load(objRepoFile);
			
			System.out.println("Object Property Loaded");

		}

		catch (Exception e) {

			System.out.println("Error in reading Object Repositaries File");
		}
	}

	public static void setBrowser() {

		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		driver1 = new ChromeDriver();
		eventListner = new Config();
		driver = new EventFiringWebDriver(driver1);
		((EventFiringWebDriver) driver).register(eventListner);
	    driver.manage().window().maximize();
	    timeOut = Integer.parseInt(propFile.getProperty("propTime"));
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		url = propFile.getProperty("propUrl");
		System.out.println("Url: "+url);
		System.out.println("TiimeOut: "+timeOut);
		driver.get(url);
		

	}
	
	public void beforeNavigateTo(String url, WebDriver driver1) {
		System.out.println("Navigating to :"+url);
		
	}
	
	public void afterNavigateTo(String url, WebDriver driver1) {
		
		System.out.println("Navigated to :"+url);
		try {
			objReports.log("Navigated To Url"+url,"PASS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error has been occured re baba");
			e.printStackTrace();
		}
	}
	
	public void beforeClickOn(WebElement element ,WebDriver driver1) {
		
		System.out.println("Trying to Click on: "+element.getText());
	}
	
	public void afterClickOn(WebElement element, WebDriver driver1) {
		
		System.out.println("Clicked on: "+element.toString());
		try {
			objReports.log("Clicked on"+element.toString(),"PASS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver1, CharSequence[] keysToSend) {
		
		System.out.println("Test Entered Successfully"+keysToSend.hashCode());
		try {
			objReports.log("Value has been entered","PASS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void endSetup() {
		
	 Reports.end();
	}

}
