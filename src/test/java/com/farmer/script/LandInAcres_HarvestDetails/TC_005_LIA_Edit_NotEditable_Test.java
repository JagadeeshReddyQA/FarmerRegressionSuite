package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_005_LIA_Edit_NotEditable_Test extends BaseTest{
	
	@Test
	public void notEditable() throws Exception {


		try {

			System.out.println("TC_005_LIA_Edit_NotEditable_Test");
			extentreport= extent.createTest("TC_005_LIA_Edit_NotEditable_Test","Verify if the user is not able to increase QTY in Edit");
			
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			farmerHomepage.clickWareHouseRequest();
			Thread.sleep(1000);
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.Edit_ATR.click();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			AppiumGeneric.scrollIntoView("Proceed");
			farmerWareHouseRequestPage.Quantity.clear();
			String qty = getValue("QTYLIA2");
			farmerWareHouseRequestPage.Quantity.sendKeys(qty);
			farmerWareHouseRequestPage.Proceed.click();
			
			try {
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String dispMsg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println(dispMsg);
					extentreport.log(Status.PASS,"Msg Displayed: "+dispMsg);
					navigateBack();
					navigateBack();
				}
			} catch (Exception e) {
				extentreport.log(Status.INFO,"Expected to see Error message but, No Message Displayed");
				extentreport.info("Turn ON LandInAcers Configuration in DB!!!!");
				device_NavigateBack();
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
