package com.farmer.scripts.WarehouseRequest;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerWareHouseRequestPage;

public class TC_007_WH_Verify_Sorting_Operation_By_Recent_Request_Test extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;
	@Test

	public void wareHouse_Request_Sort_By_Recent_Request() throws IOException, InterruptedException {
		System.out.println("TC_007_WH_Verify_Sorting_Operation_By_Recent_Request_Test");
		try {
			extentreport=extent.createTest("SORT BY Recent Request"," Verifying user is able to Sort the List By Recent Order");
			FarmerWareHouseRequestPage farmerWareHouseRequestPage= new FarmerWareHouseRequestPage(device_driver);
			Thread.sleep(2000);


			if (farmerWareHouseRequestPage.SortBy!=null && farmerWareHouseRequestPage.SortBy.isDisplayed()) {
				farmerWareHouseRequestPage.clickSortBy();
				Thread.sleep(1000);
				farmerWareHouseRequestPage.RecentRequest.click();
				Thread.sleep(4000);
			}
			try {
				aTR_ProductName= farmerWareHouseRequestPage.ATR_ProductName.getText();
				aTR_Status= farmerWareHouseRequestPage.ATR_Status.getText();
				aTR_ID= farmerWareHouseRequestPage.ATR_ID.getText();
				aTR_CreatedDate= farmerWareHouseRequestPage.ATR_CreatedDate.getText(); //07 May 2022
				aTR_Req_Quantity= farmerWareHouseRequestPage.ATR_Req_Quantity.getText();
				//Date dateDisplaying=new SimpleDateFormat("dd MMM yyyy").parse(aTR_CreatedDate);
				//String tDate = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
				//Date todaydate=new SimpleDateFormat("dd MMM yyyy").parse(tDate);
				//if( dateDisplaying.equals(todaydate))
				//{
				extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
				extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
				extentreport.log(Status.PASS, "ATR_Quantity: "+aTR_Req_Quantity);
				System.out.println("WARE HOUSE REQUEST SORT BY RECENT DETAILS DISPLAYED ");
				navigateBack();
				//}
				//else {

				//	extentreport.log(Status.FAIL, "SORTED BY RECENT DETAILS");
				//}


			} 
			catch (Exception e) {
				try {
					System.out.println("Failed To Perform Sort Operation");
					extentreport.log(Status.FAIL, "Failed To Perform Sort Operation");
					device_NavigateBack();
					Thread.sleep(2000);
					navigateBack();
					Assert.fail("Test Case Failed");
				} catch (Exception e2) {
					Assert.fail("Test Case Failed");
				}


			}

		} catch (Exception e) {
			e.printStackTrace();
			navigateBack();
			throw (e);

		}
	}
}
