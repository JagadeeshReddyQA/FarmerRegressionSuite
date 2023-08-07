package com.farmer.script.SoilTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSoilTestPage;

public class TC_006_ST_ViewDetails_FailedStatus_History_Test extends BaseTest {
	@Test
	public void statusFailed_HistoryTab() throws Exception {


		try {

			System.out.println("TC_006_ST_ViewDetails_FailedStatus_History_Test");
			extentreport= extent.createTest("ST_ViewDetails_FailedStatus_History_Test","Verify if the user is able to see Status Failed under History Tab");

			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();

			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);

			farmerSoilTestPage.clickHistoryTab();
			farmerSoilTestPage.Failed_V_D.click();
			Thread.sleep(1000);
			try {	
				String text = farmerSoilTestPage.SnackBar.getText();
				extentreport.log(Status.PASS,"Message Displayed: "+ text);
				System.out.println(text);
				navigateBack();
				Thread.sleep(1000);
				//farmerHomepage.logout();

			} catch (Exception e) {

				extentreport.log(Status.INFO,"Expected to see Soil Test Report Title,Title not displayed");
				navigateBack();
				Thread.sleep(1000);
				//farmerHomepage.logout();
			}


			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}
}
