package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_007_LIA_LandWithNoHarvestInfo_Test extends BaseTest{

	@Test
	public void landWithNoHarvestInfo() throws Exception {


		try {

			System.out.println("TC_007_LIA_LandWithNoHarvestInfo_Test");
			extentreport= extent.createTest("TC_007_LIA_LandWithNoHarvestInfo_Test","Verify if the user is not able to make request when assigned land with no Harvest Details ");
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERLIA4");
			String password = getValue("PASSLIA4");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(5000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			waitForVisibility(farmerHomepage.FarmerName);
			
			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}
			farmerHomepage.GoToHomePage.click();
			farmerHomepage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.WareHouseRequestBtn.click();
			farmerWareHouseRequestPage.accept_TandC();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectPaddy.click();
			farmerWareHouseRequestPage.selectTodayDate();
			Thread.sleep(2000);
			try {
				//Error MSG:: No harvest infomation is available. Please contact your VC.
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String dispMsg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println(dispMsg);
					extentreport.log(Status.PASS,"Msg Displayed: "+dispMsg);
					navigateBack();
					navigateBack();
					farmerHomepage.logout();

				}

			} catch (Exception e1) {
				extentreport.log(Status.INFO,"Expected to see Error message but, No Message Displayed");
				extentreport.info("Turn ON LandInAcers Configuration in DB!!!!");
				navigateBack();
				navigateBack();
				farmerHomepage.logout();
			}



			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}
	}

}
