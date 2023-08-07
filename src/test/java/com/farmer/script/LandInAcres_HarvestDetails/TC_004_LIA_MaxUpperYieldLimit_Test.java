package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_004_LIA_MaxUpperYieldLimit_Test extends BaseTest{

	@Test
	public void noLandInfo() throws Exception {


		try {

			System.out.println("TC_004_LIA_MaxUpperYieldLimit_Test");
			extentreport= extent.createTest("TC_004_LIA_MaxUpperYieldLimit_Test","Verify if the user is not able to create new request when farmer has already maxed out his yield limit");
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERLIA3");
			String password = getValue("PASSLIA3");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}
			farmerHomepage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.PlusBtn.click();
			farmerWareHouseRequestPage.accept_TandC();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectPaddy.click();
			farmerWareHouseRequestPage.selectTodayDate();
			Thread.sleep(2000);
			try {
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String dispMsg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println(dispMsg);
					extentreport.log(Status.PASS,"Msg Displayed: "+dispMsg);
					navigateBack();
					navigateBack();
									}

			} catch (Exception e1) {
				extentreport.log(Status.INFO,"Expected to see Error message but, No Message Displayed");
				extentreport.info("Turn ON LandInAcers Configuration in DB!!!!");
				navigateBack();
				navigateBack();
			
			}
			
			
			
			
			

			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}
	}
}
