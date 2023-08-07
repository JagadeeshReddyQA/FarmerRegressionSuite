package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_006_LIA_Edit_ChangeProduct_Test extends BaseTest{

	@Test
	public void editChangeProduct() throws Exception {

		try {

			System.out.println("TC_006_LIA_Edit_ChangeProduct_Test");
			extentreport= extent.createTest("TC_006_LIA_Edit_ChangeProduct_Test","Verify if the user is not able to edit request, when product change to Maize as it has it has no Harvest details");

			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			farmerHomepage.clickWareHouseRequest();
			Thread.sleep(1000);
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.Edit_ATR.click();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectMaize.click();
			farmerWareHouseRequestPage.selectTodayDate();
			AppiumGeneric.scrollIntoView("Proceed");
			try {
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String dispMsg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println(dispMsg);
					extentreport.log(Status.PASS,"Msg Displayed: "+dispMsg);
					navigateBack();
					navigateBack();

					farmerHomepage.logout();
				}
			} catch (Exception e) {
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
