package com.farmer.scripts.SaleRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;

public class TC_001_SR_Verify_Screen_If_No_Records_Are_Avaliable_Test extends BaseTest{
	String noRecordMsg;


	@Test

	public void salesRequest_NoRecord() throws Exception {
		try {
			System.out.println("TC_001_SR_Verify_Screen_If_No_Records_Are_Avaliable_Test");

			extentreport= extent.createTest("S_R_NoRecord","Verify Sales Request Screen If No Records Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
			try {
				if (farmerSalesRequest.NoRequest.isDisplayed()) {
					noRecordMsg = farmerSalesRequest.NoRequest.getText();
					System.out.println(noRecordMsg);
					extentreport.log(Status.PASS,noRecordMsg);
					navigateBack();
				}

			} catch (Exception e) {
				if (farmerSalesRequest.PlusBtn!=null && farmerSalesRequest.PlusBtn.isDisplayed()) {
					extentreport.log(Status.INFO, "Farmer Have Sale Request Record");
					navigateBack();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}
