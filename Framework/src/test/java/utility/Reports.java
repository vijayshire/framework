package utility;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	public static void createReports(String testName, String testCaseName) {
		try {
			
			File fl = new File(testName);
		if(fl.exists()) {
			reporter.setAppendExisting(true); }
		
		else {
		reporter = new ExtentHtmlReporter(testName);
		reporter.loadXMLConfig("C:\\Users\\vijay\\git\\framework\\Framework\\src\\test\\java\\utility\\extent-config.xml");
		report = new ExtentReports();
		report.attachReporter(reporter);}
		logger = report.createTest(testCaseName);
		
		System.out.println("Report created at: " +testName);
		}
	catch(Exception e)	{
		
		System.out.println("Error in creating test"+e);
	}
	}
	
	public void log(String status, String a) throws IOException {
		
		logger.log(Status.valueOf(a),status, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijay\\Desktop\\IMG_20180312_154632.jpg").build());
	
		
	}
    
	public static void end() {
		
	
		report.flush();
	}
}
