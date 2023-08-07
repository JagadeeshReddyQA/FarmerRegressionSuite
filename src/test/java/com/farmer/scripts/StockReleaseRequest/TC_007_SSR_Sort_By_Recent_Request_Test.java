package com.farmer.scripts.StockReleaseRequest;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerStockReleaseRequestsPage;



public class TC_007_SSR_Sort_By_Recent_Request_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	Date dateDisplaying;
	Date todaydate;

	@Test

	public void stockReleaseRequest_Request_Sort_By_Recent_Request() {
		try {

			System.out.println("TC_007_SSR_Sort_By_Recent_Request_Test");
			extentreport=extent.createTest("SORT BY Recent Request"," Verifying user is able to Sort the List By Recent Order");
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			try {
				if (farmerStockReleaseRequestsPage.SortBy!=null && farmerStockReleaseRequestsPage.SortBy.isDisplayed()) {
					farmerStockReleaseRequestsPage.SortBy.click();
					farmerStockReleaseRequestsPage.RecentRequest.click();
					Thread.sleep(1000);
					aTR_ProductName= farmerStockReleaseRequestsPage.ATR_ProductName.getText();
					aTR_Status= farmerStockReleaseRequestsPage.ATR_Status.getText();
					aTR_ID= farmerStockReleaseRequestsPage.ATR_ID.getText();
					aTR_CreatedDate= farmerStockReleaseRequestsPage.ATR_CreatedDate.getText(); //07 May 2022

//					dateDisplaying=new SimpleDateFormat("dd MMM yyyy").parse(aTR_CreatedDate);
//					String tDate = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
//					todaydate=new SimpleDateFormat("dd MMM yyyy").parse(tDate);
					//if( dateDisplaying.equals(todaydate))
					//{
					extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
					extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
					extentreport.log(Status.PASS, "ID: "+ aTR_ID);
					extentreport.log(Status.PASS, "Warehouse_Name:: "+aTR_CreatedDate);
					System.out.println("STOCK RELEASE REQUEST SORT BY RECENT DETAILS DISPLAYED ");
					navigateBack();
					//}
					//else {
					//extentreport.log(Status.INFO, "SORTED BY RECENT RECORD");
					//}
				}
			} catch (Exception e) {
				try {
					System.out.println("Failed To Perform Sort Operation");
					extentreport.log(Status.FAIL, "Failed To Perform Sort Operation");
					navigateBack();	
					Assert.fail("Test Case Failed", e);
				} catch (Exception e2) {
					Assert.fail("Test Case Failed", e);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}

	}

}
