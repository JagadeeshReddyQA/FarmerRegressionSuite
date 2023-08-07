package com.farmer.scripts.SaleRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;

public class TC_005_SR_Verify_Cancel_Option_Opentab_Test extends BaseTest{


	@Test

	public void salesRequestCancel_OpenTab() throws InterruptedException {

		System.out.println("TC_005_Verify_Cancel_Option_Opentab_Test");
		try {
			extentreport= extent.createTest("S_R_CancelRequest","Verify Cancel Request Under Open Tab");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);


			try {
				farmerSalesRequest.clickOpenTab();
				Thread.sleep(1000);
				if (farmerSalesRequest.ATR_ID.isDisplayed()&&farmerSalesRequest.ATR_Cancel.isDisplayed()) {
					farmerSalesRequest.ATR_Cancel.click();
					Thread.sleep(1000);
					farmerSalesRequest.Delete_Yes.click();
					String text = farmerSalesRequest.SnackBar.getText();
					extentreport.log(Status.PASS,text);
					System.out.println(text);
					Thread.sleep(1000);
					device_NavigateBack();
				}

			} catch (Exception e) {
				System.out.println("No Record Found");
				extentreport.log(Status.INFO,"No Record Is Avaliable");
				navigateBack();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}
	}
}
