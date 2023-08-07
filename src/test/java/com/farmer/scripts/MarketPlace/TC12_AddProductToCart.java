package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC12_AddProductToCart extends BaseTest{

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

	public void testAddProductToCart() throws Exception {

		System.out.println("TC12_AddProductToCart");
		extentreport= extent.createTest("Add Product to cart","Verify if user is able to add product to cart and Increase and Decrease Quantity");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();

			farmerMarketPlacePage.catSeeds.click();
			try {
				if (farmerMarketPlacePage.brandName.isDisplayed()) {

					farmerMarketPlacePage.brandName.click();
					getProductDetails();
					
				}
			} catch (Exception e) {
				extentreport.log(Status.INFO, "No Product!!");
				farmerMarketPlacePage.clickmpBackBtn();
			}
			
			
			farmerMarketPlacePage.clickAddToCart();
			try {
				String errMsg = farmerMarketPlacePage.snackBarMsg.getText();
				System.out.println(errMsg);
				extentreport.log(Status.INFO, errMsg);
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
				
			} catch (Exception e) {
				
				farmerMarketPlacePage.clickAddBtn();
				String items= farmerMarketPlacePage.itemsInCart.getText();
				String viewCart = farmerMarketPlacePage.viewCartBtn.getText();
				
				System.out.println(items);
				System.out.println(viewCart);
				extentreport.log(Status.PASS, "Item(s) in cart: "+items);
				extentreport.log(Status.PASS, "Button Displayed "+viewCart);
				
				farmerMarketPlacePage.clickSubBtn();
				farmerMarketPlacePage.clickSubBtn();
				
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
				
				extentreport.log(Status.PASS, "Test Case Executed Successfully");
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
				productSoldBy = farmerMarketPlacePage.pdSellerName.getText();
				productAvaliableQty = farmerMarketPlacePage.pdAvailabelQty.getText();
				productMinQty = farmerMarketPlacePage.pdMixQty.getText();

				pdDeliveryTo = farmerMarketPlacePage.pdDeliveryTo.getText();
				pdEstimatedTime = farmerMarketPlacePage.pdEstimatedTime.getText();
				pdTotalAmount = farmerMarketPlacePage.pdTotalAmount.getText();
				//pdAboutProduct = farmerMarketPlacePage.pdAboutProduct.getText();



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
			device_NavigateBack();
		}

	}

}
