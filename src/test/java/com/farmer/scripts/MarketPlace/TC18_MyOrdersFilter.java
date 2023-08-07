package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC18_MyOrdersFilter extends BaseTest{

	String orderNum;
	String orderDate;
	String orderPrice;
	String orderStatus;


	@Test

	public void testFilter() throws Exception {

		System.out.println("TC18_MyOrdersFilter");
		extentreport= extent.createTest("My Orders Filter","Verify if user is able to perform Filter operation in My Oreders Screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			farmerHomePage.clickMarketPlace();

			farmerMarketPlacePage.clickMyOrdersBtn();
			try {
				if (farmerMarketPlacePage.filter.isDisplayed()) {

					extentreport.log(Status.PASS,"Filter through Order Filter");
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.clickApplyFilter();
					getOrderDetails();

					extentreport.log(Status.PASS,"Filter through Order Product Status");
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.selectProductStatus();
					getOrderDetails();

					extentreport.log(Status.PASS,"Filter through Order Status");
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.selectOrderStatus();
					getOrderDetails();

					extentreport.log(Status.PASS,"Filter through Reset");
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.reset.click();
					getOrderDetails();

					extentreport.log(Status.PASS,"Filter through Start Date and End Date");
					farmerMarketPlacePage.clickFilter();
					farmerMarketPlacePage.startDate.click();
					farmerMarketPlacePage.previousMonth.click();
					farmerMarketPlacePage.selectDateStart.click();
					farmerMarketPlacePage.calOKBtn.click();
					farmerMarketPlacePage.endDate.click();
					farmerMarketPlacePage.calOKBtn.click();
					farmerMarketPlacePage.clickApplyFilter();
					getOrderDetails();

					extentreport.log(Status.PASS, "Test Case Executed Successfully");
					farmerMarketPlacePage.clickmpBackBtn();
					farmerMarketPlacePage.clickmpBackBtn();
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
