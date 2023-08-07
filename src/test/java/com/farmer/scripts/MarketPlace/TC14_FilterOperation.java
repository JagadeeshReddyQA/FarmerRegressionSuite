package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC14_FilterOperation extends BaseTest{

	String brandName;
	String productName;
	String productPrice;
	String productSoldBy;
	String productMinQty;
	String productAvaliableQty;


	@Test

	public void testFilter() throws Exception {

		System.out.println("TC14_FilterOperation");
		extentreport= extent.createTest("Perform Filter Operation","Verify if user is able to perform Filter operation in Market Place");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();

			farmerMarketPlacePage.catSeeds.click();
			try {
				if (farmerMarketPlacePage.filter.isDisplayed()) {

					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.applyFilter.click();
					getProductDetails();

					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.selectSubCategory();
					getProductDetails();

					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.selectSeller();
					getProductDetails();
					
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.selectReset();
					getProductDetails();

					extentreport.log(Status.PASS, "Test Case Executed Successfully");
					farmerMarketPlacePage.clickmpBackBtn();
					Thread.sleep(2000);
					farmerMarketPlacePage.clickmpBackBtn();
					Thread.sleep(2000);
				}

			} catch (Exception e) {
				System.out.println("No Product!!");
				extentreport.log(Status.INFO, "No Product!!");
				farmerMarketPlacePage.clickmpBackBtn();
				Thread.sleep(2000);
				farmerMarketPlacePage.clickmpBackBtn();
				Thread.sleep(2000);
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

		}

	}

}
