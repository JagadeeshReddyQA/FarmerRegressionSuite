package com.farmer.scripts.StockReleaseRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;

public class TC_009_SSR_Cancel_Request_Test  extends BaseTest{
	@Test

	public void stockReleaseRequest_CancelRequest() throws Exception {
		System.out.println("TC_009_SSR_Cancel_Request_Test");
		try {
			extentreport= extent.createTest("Stock Release Cancel Request","Verify Cancel Request");
			AppiumGeneric.quickActionSwipe();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickStockRelease();
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			try {
				if (farmerStockReleaseRequestsPage.CancelBtn.isDisplayed()) {
					farmerStockReleaseRequestsPage.CancelBtn.click();
					String msg = farmerStockReleaseRequestsPage.SnackBar.getText();
					System.out.println(msg);
					extentreport.log(Status.PASS, msg);

					navigateBack();	
				}
			} catch (Exception e) {
				System.out.println("Cancel Button Not Displayed");
				extentreport.log(Status.INFO, "Cancel Button Not Displayed");
				navigateBack();	
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}

	}

}
