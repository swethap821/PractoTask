package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	public static EdgeDriver driver;
	public static ExtentSparkReporter htmlreport;
	public static ExtentReports report;
	public static ExtentTest test;
	
//	@BeforeSuite
	public void setUp() {
		htmlreport=new ExtentSparkReporter(new File("C:\\Users\\SwethaP\\Downloads\\eclipse-java-2024-06-R-win32-x86_64\\eclipse\\practo.html"));
		htmlreport.config().setReportName("Saucedemo");
		htmlreport.config().setDocumentTitle("Saucedemo Test");
		htmlreport.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.setSystemInfo("Environment", "TestEnv");
		report.setSystemInfo("TesterName", "Swetha");
		report.attachReporter(htmlreport); 
		

	}
	public void openUrl() throws IOException {
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//getting url by using properties class from config.properties file
		
		Properties prop=new Properties();
		FileInputStream propertiesFile=new FileInputStream("src/main/java/config/config.properties");
		prop.load(propertiesFile);
		String url1=prop.getProperty("url");
		driver.get(url1);
	}
	public void closeBrowser() {
		driver.close();
	}
//	@AfterSuite 
	public void saveReports() {
		report.flush();
	}
}
