package tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;

public class TC3_ValidateHamBurgerMenuTest extends BaseTest {


	@Test
	public void hamBurgerMenu() throws InterruptedException
	{
		try {
			System.out.println("TC3_ValidateHamBurgerMenuTest");
			extentreport=extent.createTest("HamBurger Menu","Validating HamBurger Menu Items");
			Thread.sleep(1000); 
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver); 

			farmerHomePage.HamburgerMenu.click(); 
			Thread.sleep(1000);

			//farmerHomePage.HamburgerMenu.click(); 
			String logout="Logout";
			device_driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
							+ logout + "\").instance(0))");
			//AppiumGeneric.scrollIntoView("Logout");
			System.out.println("Scrolled Till Logout");

			Thread.sleep(1000);

			
			String id ="Mem ID";
			WebElement ID = device_driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
							+ id + "\").instance(0))");
			ID.click();
			System.out.println("Scrolled Till ID");
			device_NavigateBack();



			extentreport.log(Status.PASS,"TC3_ValidateHamBurgerMenuTest Executed Successfully");
			System.out.println("TC3_ValidateHamBurgerMenuTest Executed Successfully");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}


	}
}