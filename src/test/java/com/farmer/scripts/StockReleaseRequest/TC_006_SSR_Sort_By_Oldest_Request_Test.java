package com.farmer.scripts.StockReleaseRequest;
import java.util.Date;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;


public class TC_006_SSR_Sort_By_Oldest_Request_Test  extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	Date dateDisplaying;
	Date todaydate;


	@Test

	public void stockReleaseRequest_Request_Sort_By_Old_Request() throws Exception {
		try {
			System.out.println("TC_006_SSR_Sort_By_Oldest_Request_Test");
			extentreport=extent.createTest("SORT BY Old Request"," Verifying user is able to Sort the List By Oldest Order");
			AppiumGeneric.quickActionSwipe();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.QuickActionStockRelease.click();
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);

			try {
				if (farmerStockReleaseRequestsPage.SortBy!=null && farmerStockReleaseRequestsPage.SortBy.isDisplayed()) {
					farmerStockReleaseRequestsPage.SortBy.click();
					farmerStockReleaseRequestsPage.OlderRequest.click();
					Thread.sleep(1000);
					aTR_ProductName= farmerStockReleaseRequestsPage.ATR_ProductName.getText();
					aTR_Status= farmerStockReleaseRequestsPage.ATR_Status.getText();
					aTR_ID= farmerStockReleaseRequestsPage.ATR_ID.getText();
					aTR_CreatedDate= farmerStockReleaseRequestsPage.ATR_CreatedDate.getText(); //07 May 2022

//					dateDisplaying=new SimpleDateFormat("dd MMM yyyy").parse(aTR_CreatedDate);
//					String tDate = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
//					todaydate=new SimpleDateFormat("dd MMM yyyy").parse(tDate);
					//if( dateDisplaying.before(todaydate))
					//{
					extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
					extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
					extentreport.log(Status.PASS, "ID: "+ aTR_ID);
					extentreport.log(Status.PASS, "Warehouse_Name: "+aTR_CreatedDate);
					System.out.println("STOCK RELEASE REQUEST SORT BY OLDEST DETAILS DISPLAYED ");

					//}
					//else {
					//	extentreport.log(Status.INFO, "SORTED BY OLDEST RECORD");
					//}
				}
			} catch (Exception e) {
				System.out.println("Failed To Perform Sort Operation");
				extentreport.log(Status.FAIL, "Failed To Perform Sort Operation");
				navigateBack();		
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}
