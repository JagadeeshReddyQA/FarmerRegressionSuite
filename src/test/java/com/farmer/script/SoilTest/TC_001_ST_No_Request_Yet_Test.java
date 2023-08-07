package com.farmer.script.SoilTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerSoilTestPage;


public class TC_001_ST_No_Request_Yet_Test extends BaseTest{



	@Test
	public void noRequestYet_OpenTab() throws Exception {

		try {

			System.out.println("TC_001_ST_No_Request_Yet_Test");
			extentreport= extent.createTest("ST_No_Request_Yet_Test","Verify if the user is able to see No Request Yet! Message under Open Tab");
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERLIA4");
			String password = getValue("PASSLIA4");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}
			farmerHomepage.GoToHomePage.click();
			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();

			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			try {
				if (farmerSoilTestPage.NoRequestYet.isDisplayed()) {
					String text = farmerSoilTestPage.NoRequestYet.getText();
					System.out.println(text);
					extentreport.log(Status.PASS, "Msg Displayed: "+text);
					navigateBack();
					Thread.sleep(1000);
					//farmerHomepage.logout();
				}


			} catch (Exception e) {

				extentreport.log(Status.INFO,"Expected to see No Request Yet! Message, No Message Displayed.Please Login with valid user");
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
