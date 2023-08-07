package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;


public class TC_001_LIA_NoLandInfo_Test extends BaseTest{


	@Test
	public void noLandInfo() throws Exception {

		try {

			System.out.println("TC_001_LIA_NoLandInfo_Test");
			extentreport= extent.createTest("TC_001_LIA_NoLandInfo_Test","Verify if the user is able to create new sell request when there is no land is described");
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERLIA1");
			String password = getValue("PASSLIA1");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

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
			try {
				// If Error Msg :: Your agriculture land area is not defined.Please Contact Your VC.
				String msg = farmerWareHouseRequestPage.ErrorMsg.getText();
				System.out.println("Message Displayed:"+msg);

				if(msg.contains("Your agriculture land area is not defined")) {
					extentreport.log(Status.PASS,"Message Displayed: "+msg);
					System.out.print(msg);
					navigateBack();
					navigateBack();
					farmerHomepage.logout();
				}

			} catch (Exception e) {
				extentreport.log(Status.INFO,"Expected to see message but, No Message Displayed");
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
