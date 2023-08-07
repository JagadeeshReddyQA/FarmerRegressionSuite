package com.farmer.scripts.StockReleaseRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;

public class TC_004_SRR_ATR_View_Details_Test  extends BaseTest{
	@Test

	public void stockReleaseRequest_ViewDetails() throws Exception {
		System.out.println("TC_004_SSR_stockReleaseRequest_ViewDetails");
		try {
			extentreport= extent.createTest("Stock Release View Details","Verify View Details Button");
			AppiumGeneric.quickActionSwipe();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.QuickActionStockRelease.click();
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			try {
				if (farmerStockReleaseRequestsPage.ViewDetails.isDisplayed()) {
					farmerStockReleaseRequestsPage.ViewDetails.click();

					extentreport.log(Status.PASS, "Product: "+farmerStockReleaseRequestsPage.V_D_ProductName.getText());
					extentreport.log(Status.PASS, "ATR-ID: "+farmerStockReleaseRequestsPage.V_D_ATR_ID.getText());
					extentreport.log(Status.PASS, "R-Date: "+farmerStockReleaseRequestsPage.V_D_RequriedDate.getText());
					extentreport.log(Status.PASS, "QTY: "+farmerStockReleaseRequestsPage.V_D_Quantity.getText());
					extentreport.log(Status.PASS, "PURPOSE TYPE: "+farmerStockReleaseRequestsPage.V_D_Purpose_Type.getText());
					//extentreport.log(Status.PASS, "REMARKS: "+farmerStockReleaseRequestsPage.V_D_Remarks.getText());

					System.out.println(farmerStockReleaseRequestsPage.V_D_ProductName.getText());
					System.out.println(farmerStockReleaseRequestsPage.V_D_ATR_ID.getText());
					System.out.println(farmerStockReleaseRequestsPage.V_D_RequriedDate.getText());
					System.out.println(farmerStockReleaseRequestsPage.V_D_Quantity.getText());
					System.out.println(farmerStockReleaseRequestsPage.V_D_Purpose_Type.getText());
					//System.out.println(farmerStockReleaseRequestsPage.V_D_Remarks.getText());
					device_NavigateBack();
					navigateBack();	
				}
			} catch (Exception e) {
				System.out.println("No Record with View Details Option");
				extentreport.log(Status.INFO, "No Record with View Details Option");
				navigateBack();	
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}

	}

}
