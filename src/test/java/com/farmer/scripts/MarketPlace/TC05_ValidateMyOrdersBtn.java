package com.farmer.scripts.MarketPlace;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC05_ValidateMyOrdersBtn extends BaseTest{

	@Test

	public void testmarketPlaceMyOrdersBtn() throws Exception {

		System.out.println("TC05_ValidateMyOrdersBtn");
		extentreport= extent.createTest("My Orders Button Validation In MarketPlace","Verify User Lands on My Orders Screen on click of My Orders in Marketplace Screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickMyOrdersBtn();
			String actualTitle = farmerMarketPlacePage.mpMyOrdersTitle.getText();
			System.out.println(actualTitle);
			assertEquals(actualTitle, "My Orders");
			farmerMarketPlacePage.clickmpBackBtn();
			farmerMarketPlacePage.clickmpBackBtn();
			
			extentreport.log(Status.PASS, "Test Case Executed Successfully");


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
