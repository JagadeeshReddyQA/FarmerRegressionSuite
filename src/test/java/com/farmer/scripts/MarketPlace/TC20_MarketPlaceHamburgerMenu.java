package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC20_MarketPlaceHamburgerMenu extends BaseTest{

	String orderNum;
	String orderDate;
	String orderPrice;
	String orderStatus;


	@Test

	public void testMarketPlaceHambrgrMenu() throws Exception {

		System.out.println("TC20_MarketPlaceHamburgerMenu");
		extentreport= extent.createTest("MarketPlace Hamberger Menu","Verify Market Place Module is displayed on Hamburger Menu");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			Thread.sleep(3000);
			farmerHomePage.clickHamburgerMenu();
			farmerMarketPlacePage.hamMarketPlace.click();
			String dmpTitle = farmerMarketPlacePage.mpTitle.getText();
			System.out.println(dmpTitle);
			
			farmerMarketPlacePage.clickmpBackBtn();
			Thread.sleep(2000);
			//farmerHomePage.clickHamburgerMenu();
			//farmerHomePage.logout();
	


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}



}
