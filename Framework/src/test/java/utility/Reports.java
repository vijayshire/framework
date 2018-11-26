package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	public static void createReports(String testName) {
		try {
		reporter = new ExtentHtmlReporter(testName);
		reporter.loadXMLConfig("C:\\Users\\vijay\\git\\framework\\Framework\\src\\test\\java\\utility\\extent-config.xml");
		report = new ExtentReports();
		logger = report.createTest("My Test");
		report.attachReporter(reporter);
		System.out.println("Report created at: " +testName);
		}
	catch(Exception e)	{
		
		System.out.println("Error in creating test"+e);
	}
	}
	
	public void log(String status) {
		
		logger.log(Status.PASS, status);

	}
    
	public static void end() {
		
		report.flush();
	}
}
