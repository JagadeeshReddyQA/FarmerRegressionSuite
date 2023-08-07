package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC07_ValidatePPLMsgInMyCart extends BaseTest{

	@Test

	public void testpplMsgInMyCart() throws Exception {

		System.out.println("TC07_ValidatePPLMsgInMyCart");
		extentreport= extent.createTest("PPL Message Validation In My Cart","Verify PPL message is displayed in My Cart Screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickCartBtn();
			farmerMarketPlacePage.clickmpWallet();
			farmerMarketPlacePage.verifyPplMsgDisplayed();
			String pplMsg = farmerMarketPlacePage.mpPPLtext.getText();
			System.out.println(pplMsg);
			extentreport.log(Status.PASS, pplMsg);
			farmerMarketPlacePage.clickOkBtn();
			farmerMarketPlacePage.clickmpBackBtn();
			farmerMarketPlacePage.clickmpBackBtn();
			
			extentreport.log(Status.PASS, "Test Case Executed Successfully");


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
