package com.farmer.scripts.Offers;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerOffersPage;

public class TC_002_Offers_Verify_HistoryTab_Test extends BaseTest {

	String atr_ID;
	String atr_Product;
	String atr_Status;
	String atr_AvailableOn;
	String atr_ExpiryOn;
	String atr_ExptedQty;
	String atr_ReceivedQty;
	String atr_ExptdPrice;
	String atr_AcceptedQty;

	@Test

	public void offers_HistoryTab() throws Exception {

		try {
			System.out.println("TC_002_Offers_Verify_HistoryTab_Test");
			extentreport= extent.createTest("Offers_HistoryTab","Verify History Screen If Records Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickOffers();
			FarmerOffersPage farmerOffersPage = new FarmerOffersPage(device_driver);

			farmerOffersPage.clickHistoryTab();
			Thread.sleep(5000);

			try {
				if (farmerOffersPage.ATR_ProductName.isDisplayed() && farmerOffersPage.ATR_ID.isDisplayed()) {
					atr_ID = farmerOffersPage.ATR_ID.getText();
					atr_Product = farmerOffersPage.ATR_ProductName.getText();
					atr_Status = farmerOffersPage.ATR_Status.getText();
					atr_AvailableOn = farmerOffersPage.ATR_AvailableOn.getText();
					atr_ExpiryOn = farmerOffersPage.ATR_ExpiryOn.getText();
					atr_ExptedQty = farmerOffersPage.ATR_ExptdQty.getText();
					atr_ReceivedQty = farmerOffersPage.ATR_ReceivedQty.getText();
					atr_ExptdPrice = farmerOffersPage.ATR_ExptdPrice.getText();
					atr_AcceptedQty = farmerOffersPage.ATR_AcceptedQty.getText();

					extentreport.log(Status.PASS,"ATR_ID: "+atr_ID);
					extentreport.log(Status.PASS,"ATR_ProductName: "+atr_Product);
					extentreport.log(Status.PASS,"ATR_Status: "+atr_Status);
					extentreport.log(Status.PASS,"ATR_AvailableOn: "+atr_AvailableOn);
					extentreport.log(Status.PASS,"ATR_ExpiryOn: "+atr_ExpiryOn);
					extentreport.log(Status.PASS,"ATR_ExptdQty: "+atr_ExptedQty);
					extentreport.log(Status.PASS,"ATR_ReceivedQty: "+atr_ReceivedQty);
					extentreport.log(Status.PASS,"ATR_ExptdPrice: "+atr_ExptdPrice);
					extentreport.log(Status.PASS,"ATR_AcceptedQty: "+atr_AcceptedQty);
					System.out.println(atr_ID);
				}
				navigateBack();

			} catch (Exception e) {
				extentreport.log(Status.INFO, "No Records Displayed!!");
				navigateBack();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}
