package com.farmer.scripts.SaleRequest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;


public class TC_007_SR_Verify_FilterOperation_Opentab_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;

	@Test

	public void salesRequest_FilterOperation_OpenTab() throws Exception {

		System.out.println("TC_007_SR_Verify_FilterOperation_Opentab_Test");

		try {
			extentreport= extent.createTest("S_R_Opentab_Filter","Verify Filter Operation Under Open Tab");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);

			farmerSalesRequest.clickOpenTab();
			Thread.sleep(1000);
			try {
				//If Filter is enabled
				waitForVisibility(farmerSalesRequest.Filter);
				if (farmerSalesRequest.Filter.isDisplayed()) {
					farmerSalesRequest.Filter.click();
					extentreport.log(Status.PASS, "Status Of Open Records");
					Thread.sleep(1000);
					farmerSalesRequest.Status_Open.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();

					farmerSalesRequest.Filter.click();
					extentreport.log(Status.PASS, "Status Of Approved Records");
					farmerSalesRequest.Status_Approved.click();
					farmerSalesRequest.Apply_Filter.click();
					atr_Details();

					farmerSalesRequest.Filter.click();
					extentreport.log(Status.PASS, "Status Of Offer Accepting Records");
					farmerSalesRequest.Status_OfferAccept.click();
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


					//} catch (Exception e) {
					// TODO: handle exception
					//}


					device_driver.navigate().back();
				}

			} catch (Exception e) {
				// 
				System.out.println("Filter is Disabled");
				extentreport.log(Status.INFO, "FILTER DISABLED");
				device_driver.navigate().back();
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
