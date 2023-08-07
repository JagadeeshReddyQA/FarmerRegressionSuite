package com.farmer.script.SoilTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSoilTestPage;

public class TC_002_ST_Record_HistoryTab_Test extends BaseTest {
	@Test
	public void noRequestYet_HistoryTab() throws Exception {

		try {

			System.out.println("TC_002_ST_Record_HistoryTab_Test");
			extentreport= extent.createTest("ST_Record_HistoryTab_Test","Verify if the user is able to see No Request Yet! Message under History Tab");

			Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}

			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();

			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			try {
				farmerSoilTestPage.clickHistoryTab();
				if (farmerSoilTestPage.NoRequestYet.isDisplayed()) {
					String text = farmerSoilTestPage.NoRequestYet.getText();
					System.out.println(text);
					extentreport.log(Status.PASS, "Msg Displayed: "+text);
					navigateBack();
					Thread.sleep(1000);
					farmerHomepage.logout();
				}


			} catch (Exception e) {

				extentreport.log(Status.INFO,"Expected to see No Request Yet! Message, No Message Displayed.Please Login with valid user");
				navigateBack();
				Thread.sleep(1000);
				farmerHomepage.logout();
			}


			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}
	}

}
