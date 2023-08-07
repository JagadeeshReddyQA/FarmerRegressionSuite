package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC15_CategoriesInProductPage extends BaseTest{

	String brandName;
	String productName;
	String productPrice;
	String productSoldBy;
	String productMinQty;
	String productAvaliableQty;


	@Test

	public void testCategoriesInProductPage() throws Exception {

		System.out.println("TC15_CategoriesInProductPage");
		extentreport= extent.createTest("Categories In ProductPage","Verify if user is able to see products are listing under categories in product page");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();

			farmerMarketPlacePage.catSeeds.click();
			
			// Seeds
			farmerMarketPlacePage.clickCategoriesBtn();
			farmerMarketPlacePage.clickCatSeeds();
			getProductDetails();
			
			//Fertlisers
//			farmerMarketPlacePage.clickCategoriesBtn();
//			farmerMarketPlacePage.clickCatFertlisers();
//			getProductDetails();
			
			//Fungicides
			farmerMarketPlacePage.clickCategoriesBtn();
			farmerMarketPlacePage.clickCatFungicides();
			getProductDetails();
			
			//Regulators
			farmerMarketPlacePage.clickCategoriesBtn();
			farmerMarketPlacePage.clickCatRegulators();
			getProductDetails();
			
			//Insecticides
			farmerMarketPlacePage.clickCategoriesBtn();
			farmerMarketPlacePage.clickCatInsecticides();
			getProductDetails();
			
			//Herbicides
			farmerMarketPlacePage.clickCategoriesBtn();
			farmerMarketPlacePage.clickCatHerbicides();
			getProductDetails();
			
			//SpecialPlantNutrition
//			farmerMarketPlacePage.clickCategoriesBtn();
//			farmerMarketPlacePage.clickCatSpecialPlantNutrition();
//			getProductDetails();
			
			
			farmerMarketPlacePage.clickmpBackBtn();
			farmerMarketPlacePage.clickmpBackBtn();
			
			extentreport.log(Status.PASS, "Test Case Executed Successfully");

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
