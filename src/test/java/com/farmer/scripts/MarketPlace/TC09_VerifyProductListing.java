package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC09_VerifyProductListing extends BaseTest{

	String brandName;
	String productName;
	String productPrice;
	String productSoldBy;
	String productMinQty;

	@Test

	public void testProductListUnderCategories() throws Exception {

		System.out.println("TC09_VerifyProductListing");
		extentreport= extent.createTest("Product Listing under Categories","Verify if products are listed in all the catergories SKU");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickMarketPlace();

			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);

			//Seeds
			farmerMarketPlacePage.catSeeds.click();
			isProductListed();
			
			//farmerMarketPlacePage.catFertlisers.click();
			//isProductListed();
			
			farmerMarketPlacePage.catFungicides.click();
			isProductListed();
			
			farmerMarketPlacePage.catRegulators.click();
			isProductListed();
			
			farmerMarketPlacePage.catInsecticides.click();
			isProductListed();
			
			farmerMarketPlacePage.catHerbicides.click();
			isProductListed();

			farmerMarketPlacePage.clickmpBackBtn();
			extentreport.log(Status.PASS, "Test Case Executed Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

	public void isProductListed() throws InterruptedException {
		Thread.sleep(3000);
		try {
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			if (farmerMarketPlacePage.brandName.isDisplayed()) {
				brandName = farmerMarketPlacePage.brandName.getText();
				productName = farmerMarketPlacePage.productName.getText();
				productPrice = farmerMarketPlacePage.productPrice.getText();
				productSoldBy = farmerMarketPlacePage.productSoldBy.getText();
				productMinQty = farmerMarketPlacePage.productMinQty.getText();
				
				System.out.println(brandName);
				extentreport.log(Status.PASS, "Product Details");
				extentreport.log(Status.PASS, "Brand Name: "+brandName);
				extentreport.log(Status.PASS, "Product Name: "+productName);
				extentreport.log(Status.PASS, "Product Price: "+productPrice);
				extentreport.log(Status.PASS, productSoldBy);
				extentreport.log(Status.PASS, "Minimum Quantity"+productMinQty);
				
				farmerMarketPlacePage.clickmpBackBtn();
				
			}
		} catch (Exception e) {
			extentreport.log(Status.INFO, "No Products Found!");
			System.out.println("No Products Found!");
			device_NavigateBack();
		}

	}

}
