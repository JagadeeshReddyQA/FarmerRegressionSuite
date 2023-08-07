package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC08_ValidateStartShoppingBtn extends BaseTest{

	@Test

	public void testStartShoppingBtn() throws Exception {

		System.out.println("TC08_ValidateStartShoppingBtn");
		extentreport= extent.createTest("Start Shopping","Verify Start Shopping button in the My cart screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickCartBtn();

			try {
				if (farmerMarketPlacePage.cartIsEmpty.isDisplayed()) {
					String msg=farmerMarketPlacePage.cartIsEmpty.getText();
					System.out.println(msg);
					extentreport.log(Status.PASS, msg);
					farmerMarketPlacePage.clickStartShopping();
					farmerMarketPlacePage.mpTitle.isDisplayed();
					farmerMarketPlacePage.clickmpBackBtn();
					extentreport.log(Status.PASS, "Test Case Executed Successfully");
				}

			} catch (Exception e) {

				extentreport.log(Status.INFO, "Cart has Products");
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
