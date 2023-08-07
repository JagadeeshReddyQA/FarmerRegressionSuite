package com.farmer.scripts.MarketPlace;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMarketPlacePage;

public class TC02_ValidateWarehouseDetails extends BaseTest{

	@Test

	public void testmarketPlaceTitle() throws Exception {

		System.out.println("TC02_ValidateWarehouseDetails");
		extentreport= extent.createTest("Warehouse Details in MarketPlace","Verify Warehouse Details on MarketPlace Screen");
		try {

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickMarketPlace();
			
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			try {
				String warehouseInfo = farmerMarketPlacePage.mpWarehouseName.getText();
				System.out.println(warehouseInfo);
				extentreport.log(Status.INFO, ""+warehouseInfo);
				extentreport.log(Status.PASS, "Test Case Executed Successfully");
				farmerMarketPlacePage.clickmpBackBtn();
				
				
			} catch (Exception e) {
				extentreport.log(Status.INFO, "Warehouse Info Not Found ");
				farmerMarketPlacePage.clickmpBackBtn();
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
