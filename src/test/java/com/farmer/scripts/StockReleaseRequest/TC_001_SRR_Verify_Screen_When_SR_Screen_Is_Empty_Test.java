package com.farmer.scripts.StockReleaseRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;

public class TC_001_SRR_Verify_Screen_When_SR_Screen_Is_Empty_Test extends BaseTest{

	@Test
	
	private void stockRelease_NoRecord() throws Exception {

		try {
			System.out.println("TC_001_SSR_stockRelease_NoRecord");
			extentreport= extent.createTest("Stock Release_No Record","Verify Stock Release Request Screen If No Records Are Avaliable");
			AppiumGeneric.quickActionSwipe();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.QuickActionStockRelease.click();
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			
			//Scenario: When there are No Stock Release Requests 
			//Verify  Stock Release Requests  Screen If No Records Are Available
			try {
				if (farmerStockReleaseRequestsPage.NoRequests!=null && farmerStockReleaseRequestsPage.NoRequests.isDisplayed()==true) {
					String text = farmerStockReleaseRequestsPage.NoRequests.getText();
					extentreport.log(Status.PASS,"MSG Displayed: "+ text);
				}

			} catch (Exception e) {
				//Verify Advance Payment Request Screen If  Records Are Available
				if (farmerStockReleaseRequestsPage.PlusBtn!=null && farmerStockReleaseRequestsPage.PlusBtn.isDisplayed()==true) {
					extentreport.log(Status.INFO, "Farmer Have Stock Release Record");
				}

			}

			navigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}

}

