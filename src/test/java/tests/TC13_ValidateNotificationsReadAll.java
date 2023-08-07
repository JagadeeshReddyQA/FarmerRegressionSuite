package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmersNotificationsPage;

public class TC13_ValidateNotificationsReadAll extends BaseTest {

	@Test
	public void validateNotificationsReadAll() throws Exception {
		System.out.println("TC13_ValidateNotificationsReadAllButton");

		extentreport = extent.createTest("Read All Notifications", "Validating Read All in Notifications Page");
		Thread.sleep(2000);
		try {
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickNotificationIcon();
			Thread.sleep(3000);
			FarmersNotificationsPage farmersNotificationsPage = new FarmersNotificationsPage(device_driver);
			farmersNotificationsPage.clickReadAll();

			try {
				String msg = farmersNotificationsPage.snackBarMsg.getText();
				System.out.println(msg);
				extentreport.log(Status.PASS,"Message Displayed"+ msg);
				extentreport.log(Status.INFO,"Test Case Executed Successfully");

			} catch (Exception e) {
				System.out.println("No Message Displayed");
				extentreport.log(Status.INFO, "No Message Displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		
		device_NavigateBack();
	}

}
