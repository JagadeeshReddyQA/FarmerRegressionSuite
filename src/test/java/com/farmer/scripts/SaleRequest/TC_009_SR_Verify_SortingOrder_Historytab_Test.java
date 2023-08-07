package com.farmer.scripts.SaleRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;

public class TC_009_SR_Verify_SortingOrder_Historytab_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;

	@Test

	public void salesRequest_SortHistoryTab() throws InterruptedException {

		System.out.println("TC_009_SR_Verify_SortingOrder_Historytab_Test");
		try {
			extentreport= extent.createTest("SortBy_HistoryTab","Verify Sort By Under History Tab");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);

			farmerSalesRequest.clickHistoryTab();
			Thread.sleep(1000);
			try {
				//If Sort By Avaliable 
				if (farmerSalesRequest.SortBy!=null && farmerSalesRequest.SortBy.isDisplayed()) {
					farmerSalesRequest.clickSortBy();
					sortOldRequest();
					farmerSalesRequest.clickSortBy();
					sortLatestRequest();
					navigateBack();
				}

			} catch (Exception e) {
				// If Sorting Disaled  Navigate Back
				System.out.println("SORT BY DISABLED");
				navigateBack();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}

	}

	public void sortOldRequest() throws InterruptedException {
		FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
		farmerSalesRequest.clickOldRequest();
		Thread.sleep(1000);
		atr_Details();
	}
	public void sortLatestRequest() throws InterruptedException {
		FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
		farmerSalesRequest.clickRecentRequest();
		Thread.sleep(1000);
		atr_Details();
	}

	public void atr_Details() {
		FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
		try {
			if (farmerSalesRequest.ATR_ID.isDisplayed()&&farmerSalesRequest.ATR_Status.isDisplayed()) {
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
			}

		} catch (Exception e) {
			System.out.println("No Data Found");
			extentreport.log(Status.INFO, "Sort By: No Data Found");
		}

	}
}
