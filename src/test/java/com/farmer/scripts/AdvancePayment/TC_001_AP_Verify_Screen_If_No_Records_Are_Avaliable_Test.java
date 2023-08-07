package com.farmer.scripts.AdvancePayment;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;

public class TC_001_AP_Verify_Screen_If_No_Records_Are_Avaliable_Test  extends BaseTest{

	@Test

	private void advancePaymentRequest_NoRecord() {

		try {
			System.out.println("TC_001_AP_advancePaymentRequest_NoRecord");
			extentreport= extent.createTest("A_P_NoRecord","Verify Advance Payment Request Screen If No Records Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);

			//Scenario: When there are No advance payment requests 
			//Verify Advance Payment Request Screen If No Records Are Avaliable
			try {
				if (farmerAdvancePayment.NoRequests!=null && farmerAdvancePayment.NoRequests.isDisplayed()==true) {
					String text = farmerAdvancePayment.NoRequests.getText();
					extentreport.log(Status.PASS, text);
				}
			} catch (Exception e) {
				//Verify Advance Payment Request Screen If  Records Are Avaliable
				if (farmerAdvancePayment.PlusBtn!=null && farmerAdvancePayment.PlusBtn.isDisplayed()==true) {
					extentreport.log(Status.INFO, "Farmer Have Advance Payments Record");
				}
			}

			navigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}
	}
}