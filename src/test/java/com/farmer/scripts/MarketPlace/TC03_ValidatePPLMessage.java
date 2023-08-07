package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC03_ValidatePPLMessage extends BaseTest{

	@Test

	public void testmarketPlaceTitle() throws Exception {

		System.out.println("TC03_ValidatePPLMessage");
		extentreport= extent.createTest("PPL Message","Verify PPL Message");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickMarketPlace();
			
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerMarketPlacePage.mpWallet.click();
			String pplMsg = farmerMarketPlacePage.mpPPLtext.getText();
			extentreport.log(Status.PASS, "Permissible Purchase Limit: "+pplMsg);
			System.out.println(pplMsg);
			farmerMarketPlacePage.mpOkayBtn.click();
			farmerMarketPlacePage.clickmpBackBtn();
			
			extentreport.log(Status.PASS, "Test Case Executed Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
