package com.farmer.scripts.MarketPlace;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC06_ValidateCartBtn extends BaseTest{

	@Test

	public void testmarketPlaceCartBtn() throws Exception {

		System.out.println("TC06_ValidateCartBtn");
		extentreport= extent.createTest("My Cart Button Validation In MarketPlace","Verify User Lands on My Cart Screen on click of View Cart in Marketplace Screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickCartBtn();
			String actualTitle = farmerMarketPlacePage.mpMyCartTitle.getText();
			System.out.println(actualTitle);
			assertEquals(actualTitle, "My Cart");
			
			farmerMarketPlacePage.clickmpBackBtn();
			farmerMarketPlacePage.clickmpBackBtn();
			
			extentreport.log(Status.PASS, "Test Case Executed Successfully");


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
