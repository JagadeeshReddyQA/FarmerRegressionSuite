package com.farmer.scripts.MarketPlace;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC04_ValidateHomeBtn extends BaseTest{

	@Test

	public void testmarketPlaceHomeBtn() throws Exception {

		System.out.println("TC04_ValidateHomeButtonMP");
		extentreport= extent.createTest("Home Button Validation In MarketPlace","Verify User Lands on Home Screen on click of Home Button in Marketplace Screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);


			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickHomeBtn();
			String farmerName = farmerHomePage.FarmerName.getText();
			System.out.println(farmerName);
			extentreport.log(Status.INFO, "User Name: "+farmerName);
			extentreport.log(Status.PASS, "Test Case Executed Successfully");


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
