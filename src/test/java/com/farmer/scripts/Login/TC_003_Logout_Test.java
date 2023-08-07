package com.farmer.scripts.Login;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;

public class TC_003_Logout_Test extends BaseTest{

	@Test()
	public void logout() throws Exception {

		try {

			device_driver.closeApp();
			device_driver.launchApp();
			Thread.sleep(5000);
			System.out.println("TC_003_Logout_Test");
			extentreport= extent.createTest("Logout","Verify if the user is not able to Logout");

			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			Thread.sleep(3000);
			farmerHomepage.logout();
			FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);
			try {
				Thread.sleep(2000);
				String buttonText = farmerLandingPage.accSignIn.getText();
				System.out.println(buttonText);
				AssertJUnit.assertEquals(buttonText,"Sign In");
				
			} catch (Exception e) {
				System.out.println("Failed To Logout");
				extentreport.log(Status.FAIL,"Failed To Logout");
				throw (e);
			}

			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}
	}


}
