package com.farmer.scripts.StockReleaseRequest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;


public class TC_008_SRR_Verify_Filter_Operation_Test extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Loan_Amt;
	boolean aTR_Status_Diaplayed;

	@Test
	public void stockReleaseRequest() throws Exception {

		System.out.println("TC_008_SRR_Verify_Filter_Operation_Test");

		try {
			extentreport=extent.createTest("FILTER OPERATION"," Verifying user is able to Filter the List");
			//extentreport.createNode("Creating Node", "Node Description");
			//extentreport.assignCategory("SRR_FILTER_OPERATION");
			AppiumGeneric.quickActionSwipe();
			//Remove 
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.QuickActionStockRelease.click();
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);


			try {
				farmerStockReleaseRequestsPage.Filter.click();
				extentreport.log(Status.PASS, "Status Of Open Records");
				farmerStockReleaseRequestsPage.Status_Open.click();
				farmerStockReleaseRequestsPage.Apply_Filter.click();
				atr_Details();

				farmerStockReleaseRequestsPage.Filter.click();
				extentreport.log(Status.PASS, "Status Of Approved Records");
				farmerStockReleaseRequestsPage.Status_Approved.click();
				farmerStockReleaseRequestsPage.Apply_Filter.click();
				atr_Details();

				farmerStockReleaseRequestsPage.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Processed Records");
				farmerStockReleaseRequestsPage.Status_Processed.click();
				farmerStockReleaseRequestsPage.Apply_Filter.click();
				atr_Details();

				farmerStockReleaseRequestsPage.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Rejected Records");
				farmerStockReleaseRequestsPage.Status_Rejected.click();
				farmerStockReleaseRequestsPage.Apply_Filter.click(); 
				atr_Details();

				farmerStockReleaseRequestsPage.Filter.click(); 
				extentreport.log(Status.PASS,"Status Of Completed Records");
				farmerStockReleaseRequestsPage.Status_Completed.click();
				farmerStockReleaseRequestsPage.Apply_Filter.click(); 
				atr_Details();

				//Date
				farmerStockReleaseRequestsPage.Filter.click();
				farmerStockReleaseRequestsPage.ResetBtn.click();
				//extentreport.info("Testing");
				extentreport.log(Status.PASS,"Filter through Start Date and End Date");
				farmerStockReleaseRequestsPage.StartDate.click();
				farmerStockReleaseRequestsPage.PreviousMonth.click();
				farmerStockReleaseRequestsPage.SelectDate_Start.click();
				farmerStockReleaseRequestsPage.Cal_OKBtn.click();
				farmerStockReleaseRequestsPage.EndDate.click();
				farmerStockReleaseRequestsPage.Cal_OKBtn.click();
				farmerStockReleaseRequestsPage.Apply_Filter.click();
				atr_Details();

				//search ATR Number
				farmerStockReleaseRequestsPage.Filter.click();
				extentreport.log(Status.PASS,"Filter through Search ATR Number");
				farmerStockReleaseRequestsPage.Search_ATR_NBR.sendKeys(aTR_ID);
				farmerStockReleaseRequestsPage.Apply_Filter.click(); 
				atr_Details();
				navigateBack();

			} catch (Exception e) {
				System.out.println("FILTER DISABLED");
				extentreport.log(Status.INFO, "FILTER DISABLED");
				navigateBack();	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}
	}


	public void atr_Details() throws IOException {
		try {
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			//if (farmerStockReleaseRequestsPage!=null && farmerStockReleaseRequestsPage.ATR_ID!=null &&farmerStockReleaseRequestsPage.ATR_Status.isDisplayed()==true) {	
			if (farmerStockReleaseRequestsPage.ATR_Status.isDisplayed()==true) {
				aTR_ProductName= farmerStockReleaseRequestsPage.ATR_ProductName.getText();
				aTR_Status= farmerStockReleaseRequestsPage.ATR_Status.getText();
				aTR_ID= farmerStockReleaseRequestsPage.ATR_ID.getText();
				aTR_CreatedDate= farmerStockReleaseRequestsPage.ATR_CreatedDate.getText();
				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
			}
		} catch (Exception ex) {
			extentreport.log(Status.INFO, "No Records Found");
			System.out.println("No Records Found");
		}
	}

}
