package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmersNotificationsPage;

public class TC12_ValidateNotificationsTitle extends BaseTest {
	
	@Test
	public void validateNotificationsTitle() throws Exception {
		System.out.println("TC12_ValidateNotificationsTitle");

		extentreport = extent.createTest("Notifications Title", "Validating Notifications Page Title");
		Thread.sleep(2000);
		try {
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickNotificationIcon();
			Thread.sleep(3000);

			FarmersNotificationsPage farmersNotificationsPage = new FarmersNotificationsPage(device_driver);

			String actualTitle = farmersNotificationsPage.notificationTitle.getText();
			AssertJUnit.assertEquals(actualTitle, "Notifications");
			System.out.println("Title Displayed: "+actualTitle);
			extentreport.log(Status.PASS, "Title Displayed: "+actualTitle);

			device_NavigateBack();
			extentreport.log(Status.INFO,"Test Case Executed Successfully");


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

}
