package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC13_SortByPrice extends BaseTest{

	String brandName;
	String productName;
	String productPrice;
	String productSoldBy;
	String productMinQty;
	String productAvaliableQty;


	@Test

	public void testSortBy() throws Exception {

		System.out.println("TC13_SortByPrice");
		extentreport= extent.createTest("Perform Sort By Price","Verify if user is able to perform sort by operation in Market Place");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();

			farmerMarketPlacePage.catSeeds.click();
			try {
				if (farmerMarketPlacePage.sortBy.isDisplayed()) {

					farmerMarketPlacePage.clickSortBy();
					farmerMarketPlacePage.selectHightoLow();
					getProductDetails();

					farmerMarketPlacePage.clickSortBy();
					farmerMarketPlacePage.selectLowtoHigh();
					getProductDetails();
					
					farmerMarketPlacePage.clickmpBackBtn();
					farmerMarketPlacePage.clickmpBackBtn();

					extentreport.log(Status.PASS, "Test Case Executed Successfully");
				}

			} catch (Exception e) {
				extentreport.log(Status.INFO, "No Product!!");
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

	public void getProductDetails() throws InterruptedException {
		Thread.sleep(3000);
		try {
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			if (farmerMarketPlacePage.brandName.isDisplayed()) {
				brandName = farmerMarketPlacePage.brandName.getText();
				productName = farmerMarketPlacePage.productName.getText();
				productPrice = farmerMarketPlacePage.productPrice.getText();
				productSoldBy = farmerMarketPlacePage.productSoldBy.getText();
				productAvaliableQty = farmerMarketPlacePage.productMinQty.getText();
				
				System.out.println(brandName);
				extentreport.log(Status.PASS, "Brand Name: "+brandName);
				extentreport.log(Status.PASS, "Product Name: "+productName);
				extentreport.log(Status.PASS, "Product Price: "+productPrice);
				extentreport.log(Status.PASS, productSoldBy);

			}
		} catch (Exception e) {
			extentreport.log(Status.INFO, "No Products Found!");
			System.out.println("No Products Found!");
			device_NavigateBack();
		}

	}

}
