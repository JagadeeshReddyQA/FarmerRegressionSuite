package com.farmer.scripts.AdvancePayment;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;

public class TC_007_AP_Verify_Filter_Operation_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Loan_Amt;
	boolean aTR_Status_Diaplayed;

	@Test
	public void advancePayments_Filter_Operation() {
		System.out.println("TC_007_AP_Verify_Filter_Operation_Test");
		try {
			extentreport=extent.createTest("A_P_FILTER_OPERATION"," Verifying user is able to Filter the List");
			//extentreport.createNode("Creating Node", "Node Description");
			//extentreport.assignCategory("AP_FILTER_OPERATION");
			//Remove 
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);


			try {
				farmerAdvancePayment.Filter.click();
				extentreport.log(Status.PASS, "Status Of Open Records");
				farmerAdvancePayment.Status_Open.click();
				farmerAdvancePayment.Apply_Filter.click();
				atr_Details();

				farmerAdvancePayment.Filter.click();
				extentreport.log(Status.PASS, "Status Of Approved Records");
				farmerAdvancePayment.Status_Approved.click();
				farmerAdvancePayment.Apply_Filter.click();
				atr_Details();

				farmerAdvancePayment.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Processed Records");
				farmerAdvancePayment.Status_Processed.click();
				farmerAdvancePayment.Apply_Filter.click();
				atr_Details();

				farmerAdvancePayment.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Disbursed Records");
				farmerAdvancePayment.Status_Disbursed.click();
				farmerAdvancePayment.Apply_Filter.click(); 
				atr_Details();

				farmerAdvancePayment.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Expired Records");
				farmerAdvancePayment.Status_Expired.click();
				farmerAdvancePayment.Apply_Filter.click(); 
				atr_Details();

				farmerAdvancePayment.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Not Approved Records");
				farmerAdvancePayment.Status_NotApproved.click();
				farmerAdvancePayment.Apply_Filter.click(); 
				atr_Details();

				//Date
				farmerAdvancePayment.Filter.click();
				farmerAdvancePayment.ResetBtn.click();
				//extentreport.info("Testing");
				extentreport.log(Status.PASS,"Filter through Start Date and End Date");
				farmerAdvancePayment.StartDate.click();
				farmerAdvancePayment.PreviousMonth.click();
				farmerAdvancePayment.SelectDate_Start.click();
				farmerAdvancePayment.Cal_OKBtn.click();
				farmerAdvancePayment.EndDate.click();
				farmerAdvancePayment.Cal_OKBtn.click();
				farmerAdvancePayment.Apply_Filter.click();
				atr_Details();

				//search ATR Number
				farmerAdvancePayment.Filter.click();
				extentreport.log(Status.PASS,"Filter through Search ATR Number");
				farmerAdvancePayment.Search_ATR_NBR.sendKeys(aTR_ID);
				farmerAdvancePayment.Apply_Filter.click(); 
				atr_Details();
				navigateBack();

			} catch (Exception e) {
				System.out.println("FILTER DISABLED");
				extentreport.log(Status.INFO, "FILTER DISABLED");
				navigateBack();	
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);


		}	
	}


	public void atr_Details() throws IOException {
		try {
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);
			if (farmerAdvancePayment!=null && farmerAdvancePayment.ATR_ID!=null &&farmerAdvancePayment.ATR_Status.isDisplayed()==true) {
				aTR_ProductName= farmerAdvancePayment.ATR_ProductName.getText();
				aTR_Status= farmerAdvancePayment.ATR_Status.getText();
				aTR_ID= farmerAdvancePayment.ATR_ID.getText();
				aTR_CreatedDate= farmerAdvancePayment.ATR_CreatedDate.getText();
				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
			}
		} catch (Exception e) {
			extentreport.log(Status.INFO, "No Records Found");
			//extentreport.addScreenCaptureFromPath(captureScreenShot("FarmerApp.jpg"));
			System.out.println("No Records Found");
		}
	}
}
