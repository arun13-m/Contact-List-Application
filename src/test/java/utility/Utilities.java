package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;

public class Utilities {
	
	public static WebDriver driver;
	public static WebElement ele;
	public static String expectedResult;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String sheetName;
	public String testName, testDescription, testAuthor;
	public static Alert a;
	

	//launch the browser and url
	public void browserAndURL(String browser) {
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		
		driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	//creating the report in the location
	public void reptInitilization() {
		String path = "C:\\Users\\arunp\\eclipse-workspace\\ContactListApp\\Reports\\ContactListApp-Report\\Contact_List_App.html";
		//to crate a report in given location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setReportName("Contact List App");
				
		//to capture the data
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	//Giving the test details
	public void tDetails() {
	    test = report.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
	}
	
	//excel reading code
	public static String[][] excelData(String sheetName) throws IOException  {
	XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\arunp\\eclipse-workspace\\ContactListApp\\src\\test\\resources\\TestData\\ContactListAppTestData.xlsx");
	XSSFSheet sheet = book.getSheet(sheetName);
	int rowCount = sheet.getLastRowNum();
	int columnCount = sheet.getRow(0).getLastCellNum();
	String[][] data = new String[rowCount][columnCount];		
	for(int i=1;i<=rowCount;i++) {
		XSSFRow row = sheet.getRow(i);
		for(int j=0;j<columnCount;j++) {
			XSSFCell col =  row.getCell(j);
			data[i-1][j] = col.getStringCellValue();
		    }
	    }
	System.out.println(sheet.getSheetName());
	book.close();
	return data;
	}
	
	//screenshot method for failed testcase
	public String screenShot(String name) throws IOException {
		String path = "C:\\Users\\arunp\\eclipse-workspace\\ContactListApp\\Pictures\\"+name+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	//common logout
	public HomePage logOut() {
		driver.findElement(By.id("logout")).click();
		return new HomePage(driver);
	}
		
	//closing the browser
	public void browserClose() {
		driver.close();
	}	
}