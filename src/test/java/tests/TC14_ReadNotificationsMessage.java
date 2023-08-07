package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmersNotificationsPage;

public class TC14_ReadNotificationsMessage extends BaseTest {

	@Test
	public void validateNotificationsMessage() throws Exception {
		System.out.println("TC14_ReadNotificationsMessage");

		extentreport = extent.createTest("Notifications Message Content", "Validating Notification Messege Content");
		Thread.sleep(2000);
		try {
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickNotificationIcon();
			Thread.sleep(3000);
			FarmersNotificationsPage farmersNotificationsPage = new FarmersNotificationsPage(device_driver);
			try {
				if (farmersNotificationsPage.collapseOrExpandBtn.isDisplayed()) {
					String msg = farmersNotificationsPage.msgContent.getText();
					System.out.println(msg);
					extentreport.log(Status.INFO,msg);
					extentreport.log(Status.INFO,"Test Case Executed Successfully");
				}


			} catch (Exception e) {
				System.out.println("No Message Displayed");
				extentreport.log(Status.INFO, "No Message Displayed");
			}

			device_NavigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

}
