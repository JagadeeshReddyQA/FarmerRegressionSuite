package generic;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import dataproviders.ConfigFileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileDeleteStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.TestUtils;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
	public static AndroidDriver<AndroidElement> device_driver;
	public static ExtentReports extent;
	ExtentSparkReporter spark;
	public static ExtentTest extentreport;
	ConfigFileReader configFileReader;
	public static double paddyMarketPrice;
	public static double wheatMarketPrice;
	public static double maizeMarketPrice;
	public static String propertyFilePath= (System.getProperty("user.dir")+"/Configs/Configuration.properties");
	//public static String Download_Filepath=(System.getProperty("user.dir")+"/src/test/resources/apps");
	//public static String Download_Filepath=("C:\\Users\\Testing\\FarmerAppiumRegression\\farmertestautomation\\src\\test\\resources\\apps");

	public static ChromeDriver chdriver;
	//File app;



	@BeforeSuite 
	public void reportSetup(){ 
		spark = new ExtentSparkReporter("./test-output/ExtentReport.html"); 
		extent = new ExtentReports(); 
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Appium Extent Reports");
		spark.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.EXCEPTION , ViewName.TEST}).apply();
		extent.attachReporter(spark); 
	}

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {

		System.out.println("Launch GrainBank Farmers App");
		try {
			//Comment filePath() if Executing from Local APK
			//filePath();
			//File app = new File(System.getProperty("user.dir")+"/src/test/resources/apps/abd14af8-248c-4157-ac3c-5fd6602ac24f.apk");
			File app = new File(System.getProperty("user.dir")+"/src/test/resources/apps/app(32).apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("unicodeKeyboard", false);
			capabilities.setCapability("resetKeyboard", false);
			capabilities.setCapability("deviceName",TestUtils.DEVICENAME);
			capabilities.setCapability(CapabilityType.VERSION, TestUtils.VERSION);
			capabilities.setCapability("isHeadless", false);
			capabilities.setCapability("platformName",TestUtils.PLATFORMNAME);
			capabilities.setCapability("newCommandTimeout", 100000);
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("fullReset", "false");
			capabilities.setCapability("app", app.getAbsolutePath());
			device_driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			device_driver.manage().timeouts().implicitlyWait(TestUtils.ITO, TimeUnit.SECONDS);
			System.out.println("Launch GrainBank Farmers App Launched Successfully");

		} catch (Exception e) {
			System.out.println("Failed To Launch Grain Bank Application");
		}
	}



	@AfterMethod 
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = getScreenshot1(result.getName());
			extentreport.fail(result.getThrowable());
			extentreport.addScreenCaptureFromPath(screenShotPath);
		}
	}


	@AfterTest
	public void tearDown() {
		extent.flush();
	}


	@AfterSuite
	public void uninstallApp() throws Exception {
		System.out.println("UnInstalling GrainBank App");
		//device_driver.removeApp("com.GrainbankFarmer.app");

		if (device_driver!=null) {
			device_driver.quit();
		}
		//delete_APK_Files();
	}

//	public void delete_APK_Files() throws Exception {
//
//		try {
//			System.out.println("Deleting APK File!!!!");
//			Thread.sleep(5000);
//			File folder = new File(Download_Filepath);
//			File[] listOfFiles = folder.listFiles();
//			int total_num_of_files=listOfFiles.length; 
//			for (int i=0; i<total_num_of_files; ++i) {
//				if (listOfFiles[i].getName().endsWith("apk")) {
//					FileDeleteStrategy.FORCE.delete(listOfFiles[i]);	
//				}
//
//				System.out.println(listOfFiles[i].getName());	
//				System.out.println("Deleted");
//			}
//
//		} catch (InterruptedException e) {
//			System.out.println("Failed To Delete APK File");
//			throw (e);
//		}
//	}

//	public void filePath() {
//		File folder1 = new File(Download_Filepath);
//		File[] listOfFiles = folder1.listFiles();
//		String fname;
//		fname = listOfFiles[0].getName();
//		System.out.println("FileName-->" + fname);
//		app = new File(Download_Filepath + "/" + fname);
//
//	}


	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(device_driver,TestUtils.WAITS);
		wait.until(ExpectedConditions.visibilityOf(e));
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));

	}
	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void refreshed(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(device_driver,TestUtils.WAITS);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));
	}


	public static String getScreenshot1(String string) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) device_driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + dateName + ".png";
		System.out.println(destination);
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}


	public static String getValue(String key) throws IOException {
		FileInputStream fileInputStream=null;
		String value="";
		Properties p=new Properties();
		try {
			fileInputStream = new FileInputStream(propertyFilePath);
			p.load(fileInputStream);
			value=p.getProperty(key);
		}
		catch (Exception e) {

		}
		finally {
			if (fileInputStream!=null) {
				fileInputStream.close();
			}
		}
		return value;
	}

	public void navigateBack() {
		MobileElement back = device_driver.findElement(By.id("com.GrainbankFarmer.app:id/action_back"));
		click(back);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void navigateBackFromSandwichMenu() {
		device_driver.findElement(By.id("com.GrainbankFarmer.app:id/imageViewGoBack")).click();
	}
	public String currentDate() {
		String date = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
		return date;	
	}
	public void device_NavigateBack() {
		device_driver.navigate().back();
	}


}