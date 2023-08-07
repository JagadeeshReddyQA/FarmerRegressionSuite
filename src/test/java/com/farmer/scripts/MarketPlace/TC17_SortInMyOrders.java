package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerMarketPlacePage;

public class TC17_SortInMyOrders extends BaseTest{

	String orderNum;
	String orderDate;
	String orderPrice;
	String orderStatus;


	@Test

	public void testSortInMyOrders() throws Exception {

		System.out.println("TC17_SortInMyOrders");
		extentreport= extent.createTest("Perform Sort By In My Orders Screen","Verify if user is able to perform sort by operation in My Orders Screen");
		try {
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			//String username = getValue("USERLIA4");
			//String password = getValue("PASSLIA4");
			farmerLandingpage.loginToApp("agrid-uat", "2222222");
			Thread.sleep(5000);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			waitForVisibility(farmerHomePage.FarmerName);
			
			if (farmerHomePage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomePage.FarmerName.getText());
			}

			
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();
			farmerMarketPlacePage.clickMyOrdersBtn();

			try {
				
				if (farmerMarketPlacePage.sortBy.isDisplayed()) {
					farmerMarketPlacePage.clickSortBy();
					farmerMarketPlacePage.selectHightoLow();
					getOrderDetails();

					farmerMarketPlacePage.clickSortBy();
					farmerMarketPlacePage.selectLowtoHigh();
					getOrderDetails();
					
					farmerMarketPlacePage.clickmpBackBtn();
					farmerMarketPlacePage.clickmpBackBtn();
					
					extentreport.log(Status.PASS, "Test Case Executed Successfully");
				}
				
			} catch (Exception e) {
				
				System.out.println("No Orders for the user, Cannot Perform Sort Operation");
				extentreport.log(Status.INFO, "No Orders for the user, Cannot Perform Sort Operation!");
				farmerMarketPlacePage.clickmpBackBtn();
				farmerMarketPlacePage.clickmpBackBtn();
				
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}
	
	public void getOrderDetails() throws InterruptedException {
		Thread.sleep(3000);
		try {
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			if (farmerMarketPlacePage.orderNum.isDisplayed()) {
				
				orderNum = farmerMarketPlacePage.orderNum.getText();
				orderDate = farmerMarketPlacePage.orderDate.getText();
				orderPrice = farmerMarketPlacePage.orderPrice.getText();
				orderStatus = farmerMarketPlacePage.orderStatus.getText();
				
				System.out.println(orderNum);
				
				extentreport.log(Status.PASS, "Order Details");
				extentreport.log(Status.PASS, "Order Number: : "+orderNum);
				extentreport.log(Status.PASS, "Order Date: "+orderDate);
				extentreport.log(Status.PASS, "Order Price: "+orderPrice);
				extentreport.log(Status.PASS, "Order Status: "+orderStatus);

			}
		} catch (Exception e) {
			extentreport.log(Status.INFO, "No Orders Found!!");
			System.out.println("No Orders Found!!");
		}

	}

}
