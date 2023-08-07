package com.farmer.scripts.SaleRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;

public class TC_004_SR_Verify_Sale_Request_History_Tab_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;


	@Test

	public void salesRequest_HistoryTab() throws InterruptedException {

		System.out.println("TC_004_SR_Verify_Sale_Request_History_Tab_Test");

		extentreport= extent.createTest("S_R_HistoryTab ","Verify Sales Request Screen Under History Tab");
		FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
		//farmerHomePage.waitTillNameisDisplayed();
		AppiumGeneric.quickActionSwipe();
		farmerHomePage.QuickActionSalesRequest.click();
		FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
		farmerSalesRequest.clickHistoryTab();
		Thread.sleep(1000);
		try {
			//If Product Avaliable get details
			if (farmerSalesRequest.ATR_ID.isDisplayed()) {
				aTR_ProductName= farmerSalesRequest.ATR_ProductName.getText();
				aTR_Status= farmerSalesRequest.ATR_Status.getText();
				aTR_ID= farmerSalesRequest.ATR_ID.getText();
				aTR_CreatedDate= farmerSalesRequest.ATR_CreatedDate.getText();
				extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
				extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);

				System.out.println(aTR_ProductName);
				System.out.println(aTR_Status);
				System.out.println(aTR_ID);
				System.out.println(aTR_CreatedDate);
				navigateBack();
			}

		} catch (Exception e) {
			// No product Navigate Back
			System.out.println("No Record Found");
			extentreport.log(Status.INFO,"No Record Is Avaliable");
			navigateBack();

		}



	}

}
