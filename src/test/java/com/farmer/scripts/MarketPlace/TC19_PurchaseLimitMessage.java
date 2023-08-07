package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC19_PurchaseLimitMessage extends BaseTest{

	String orderNum;
	String orderDate;
	String orderPrice;
	String orderStatus;


	@Test

	public void testPurchaseLimitBalance() throws Exception {

		System.out.println("TC19_PurchaseLimitMessage");
		extentreport= extent.createTest("Purchase Limit Balance","Verify If the Purchase limit message is being displayed if a user is not having sufficient PPL balance");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickCatSeeds();

			try {
				
				farmerMarketPlacePage.clickFilter();
				farmerMarketPlacePage.selectReset();
				farmerMarketPlacePage.clickSortBy();
				farmerMarketPlacePage.selectHightoLow();
				Thread.sleep(5000);

				if (farmerMarketPlacePage.addBtn.isDisplayed()) {
					farmerMarketPlacePage.addBtn.click();
					for (int i = 0; i < 10; i++) {
						farmerMarketPlacePage.add.click();
					}
					farmerMarketPlacePage.mpViewCart.click();
					farmerMarketPlacePage.confirmOrder.click();

					try {
						// If Error Message Displayed

						String msg = farmerMarketPlacePage.snackBarMsg.getText();
						System.out.println(msg);
						extentreport.log(Status.PASS,msg);
						farmerMarketPlacePage.removeBtn.click();
						farmerMarketPlacePage.clickmpBackBtn();
						farmerMarketPlacePage.clickmpBackBtn();
						farmerMarketPlacePage.clickmpBackBtn();

						extentreport.log(Status.PASS,"Test Case Executed Successfully");

					} catch (Exception e) {
						System.out.println("Snack Bar Message Did Not Displayed");
						device_NavigateBack();
						farmerMarketPlacePage.removeBtn.click();
						farmerMarketPlacePage.clickmpBackBtn();
						farmerMarketPlacePage.clickmpBackBtn();
						farmerMarketPlacePage.clickmpBackBtn();
					}

				}

			} catch (Exception e) {
				System.out.println("No Product!!");
				extentreport.log(Status.INFO, "No Product!!");
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}



}
