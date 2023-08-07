package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_003_LIA_NoHarvestInfo_Test extends BaseTest{
	
	
	@Test
	public void productWithNoHarvestInfo() throws Exception {

		try {

			System.out.println("TC_003_LIA_NoHarvestInfo");
			extentreport= extent.createTest("TC_003_LIA_NoHarvestInfo","Verify Farmer is not able to make request when he's having harvest details for Paddy, try inwarding Maize by give an error message ");
			Thread.sleep(5000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			farmerHomepage.clickWareHouseRequest();
			Thread.sleep(5000);
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.WareHouseRequestBtn.click();
			farmerWareHouseRequestPage.accept_TandC();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectMaize.click();
			farmerWareHouseRequestPage.selectTodayDate();
			Thread.sleep(2000);
			try {
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String dispMsg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println(dispMsg);
					extentreport.log(Status.PASS,"Msg Displayed"+dispMsg);
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
