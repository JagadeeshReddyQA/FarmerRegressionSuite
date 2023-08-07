package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC16_AddProdToCartProductListingPage extends BaseTest{

	String brandName;
	String productName;
	String productPrice;
	String productSoldBy;
	String productMinQty;
	String productAvaliableQty;
	String pdDeliveryTo;
	String pdEstimatedTime;
	String pdTotalAmount;
	String pdAboutProduct;


	@Test

	public void testAddProdToCartProductListPage() throws Exception {

		System.out.println("TC16_AddProdToCartProductListingPage");
		extentreport= extent.createTest("Add Product to cart in Product Listing Screen","Verify if the product was able to add to cart from product listing page");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.mpViewCart.click();

			try {
				if (farmerMarketPlacePage.cartIsEmpty.isDisplayed()) {
					farmerMarketPlacePage.clickStartShopping();
					
					farmerMarketPlacePage.clickCatSeeds();
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.selectReset();

					farmerMarketPlacePage.addBtn.click();
					System.out.println("User added product to cart");
					farmerMarketPlacePage.clickCartBtn();
					getProductDetails();
					
					farmerMarketPlacePage.removeBtn.click();
					System.out.println("User remove product from cart");
					farmerMarketPlacePage.clickmpBackBtn();
					Thread.sleep(5000);
					farmerMarketPlacePage.clickmpBackBtn();
					farmerMarketPlacePage.clickmpBackBtn();
					
					
					extentreport.log(Status.PASS, "Test Case Executed Successfully");
					farmerHomePage.logout();
				}
				
			} catch (Exception e) {
				
				System.out.println("Items are in Cart. Please clear cart and execute the test case again !!!");
				extentreport.log(Status.INFO, "Items are in Cart. Please clear cart and execute the test case again !!!");
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
				farmerHomePage.logout();
				
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
			if (farmerMarketPlacePage.pdproductNme.isDisplayed()) {
				brandName = farmerMarketPlacePage.pdBrandNme.getText();
				productName = farmerMarketPlacePage.pdproductNme.getText();
				productPrice = farmerMarketPlacePage.pdProductPrice.getText();

				pdDeliveryTo = farmerMarketPlacePage.pdDeliveryTo.getText();
				pdEstimatedTime = farmerMarketPlacePage.pdEstimatedTime.getText();
				//pdTotalAmount = farmerMarketPlacePage.pdTotalAmount.getText();
				//pdAboutProduct = farmerMarketPlacePage.pdAboutProduct.getText();
				
				System.out.println(brandName);
				
				extentreport.log(Status.PASS, "Product Details");
				extentreport.log(Status.PASS, "Brand Name: "+brandName);
				extentreport.log(Status.PASS, "Product Name: "+productName);
				extentreport.log(Status.PASS, "Product Price: "+productPrice);
				extentreport.log(Status.PASS, productSoldBy);
				extentreport.log(Status.PASS, productMinQty);
				
				extentreport.log(Status.PASS, pdDeliveryTo);
				extentreport.log(Status.PASS, pdEstimatedTime);
				//extentreport.log(Status.PASS, pdTotalAmount);
				//extentreport.log(Status.PASS, pdAboutProduct);

				

			}
		} catch (Exception e) {
			extentreport.log(Status.INFO, "No Products Found!");
			System.out.println("No Products Found!");
			
		}

	}

}
