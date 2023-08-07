package com.farmer.scripts.SaleRequest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;


public class TC_010_SR_Verify_FilterOperation_Historytab_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;

	@Test

	public void salesRequest_FilterOperation_HistoryTab() throws InterruptedException {

		System.out.println("TC_010_SR_Verify_FilterOperation_Historytab_Test");
		try {
			extentreport= extent.createTest("S_R_Historytab_Filter","Verify Filter Operation Under History Tab");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
			farmerSalesRequest.clickHistoryTab();
			Thread.sleep(1000);
			try {
				//If Filter is enabled
				if (farmerSalesRequest.Filter.isDisplayed()) {
					farmerSalesRequest.Filter.click();
					extentreport.log(Status.PASS, "Status Of Expired Records");
					farmerSalesRequest.Status_Expired.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();

					farmerSalesRequest.Filter.click();
					extentreport.log(Status.PASS, "Status Of Completed Records");
					farmerSalesRequest.Status_Completed.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();
					farmerSalesRequest.Filter.click();
					extentreport.log(Status.PASS, "Status Of Rejected Records");
					farmerSalesRequest.Status_Rejected.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();

					farmerSalesRequest.Filter.click(); 
					extentreport.log(Status.PASS,"Status Of Qty Full Filled Records");
					farmerSalesRequest.Status_Qty_Full_Filled.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();

					//Date
					farmerSalesRequest.Filter.click();
					farmerSalesRequest.ResetBtn.click();

					extentreport.log(Status.PASS,"Filter through Start Date and End Date");
					farmerSalesRequest.StartDate.click();
					farmerSalesRequest.PreviousMonth.click();
					farmerSalesRequest.SelectDate_Start.click();
					farmerSalesRequest.Cal_OKBtn.click();
					farmerSalesRequest.EndDate.click();
					farmerSalesRequest.Cal_OKBtn.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();

					//try {
					//search ATR Number
					//farmerSalesRequest.Filter.click();
					//farmerSalesRequest.Search_ATR_NBR.sendKeys(aTR_ID);
					//extentreport.log(Status.PASS,"Filter through Search SR Number");
					//farmerSalesRequest.Apply_Filter.click(); 
					//atr_Details();

					//}
					//catch(Exception e){

					//}

					device_driver.navigate().back();
				}

			} catch (Exception e) {
				// 
				System.out.println("Filter is Disabled");
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
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
			if (farmerSalesRequest!=null && farmerSalesRequest.ATR_ID!=null &&farmerSalesRequest.ATR_Status.isDisplayed()) {
				aTR_ProductName= farmerSalesRequest.ATR_ProductName.getText();
				aTR_Status= farmerSalesRequest.ATR_Status.getText();
				aTR_ID= farmerSalesRequest.ATR_ID.getText();
				aTR_CreatedDate= farmerSalesRequest.ATR_CreatedDate.getText();

				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
			}
		} catch (Exception e) {
			extentreport.log(Status.PASS, "No Records Found");
			System.out.println("No Records Found");

		}
	}
}
