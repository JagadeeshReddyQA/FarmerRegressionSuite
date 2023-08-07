package com.farmer.scripts.StockReleaseRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;

public class TC_005_SRR_ATR_Edit_Details_Test extends BaseTest{
	@Test

	public void stockReleaseRequest_EditDetails() throws Exception {
		try {

			System.out.println("TC_005_SSR_stockReleaseRequest_EditDetails");
			extentreport= extent.createTest("Stock Release Edit Details","Verify Edit Details Button");
			AppiumGeneric.quickActionSwipe();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.QuickActionStockRelease.click();
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);

			try {
				if (farmerStockReleaseRequestsPage.ATR_Edit.isDisplayed()) {
					farmerStockReleaseRequestsPage.ATR_Edit.click();
				}
				try {
					validateEdit();
				} catch (Exception e) {

				}
				try {
					if (farmerStockReleaseRequestsPage.E_Message.isDisplayed()) {
						farmerStockReleaseRequestsPage.E_EditRemarks.clear();
						farmerStockReleaseRequestsPage.E_EditRemarks.sendKeys("Editing QA");
						farmerStockReleaseRequestsPage.E_Submit.click();
						validateEdit();
						navigateBack();
						navigateBack();	
					}
				} catch (Exception e) {
					System.out.println("Edit ATR Disabled");
					extentreport.log(Status.INFO, "Edit ATR Disabled");
					navigateBack();
				}
			} catch (Exception e) {
				System.out.println("No Record");
				extentreport.log(Status.INFO, "No Record Is Avaliable");
				navigateBack();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}


	}

	public void validateEdit() {
		try {
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			extentreport.log(Status.PASS, farmerStockReleaseRequestsPage.SnackBar.getText());
			System.out.println("MSG Displayed: "+farmerStockReleaseRequestsPage.SnackBar.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}


	}
}
