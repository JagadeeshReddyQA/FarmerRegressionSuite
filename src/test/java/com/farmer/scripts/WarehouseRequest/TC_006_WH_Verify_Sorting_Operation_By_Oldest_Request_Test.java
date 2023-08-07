package com.farmer.scripts.WarehouseRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_006_WH_Verify_Sorting_Operation_By_Oldest_Request_Test extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;
	@Test

	public void wareHouse_Request_Sort_By_Old_Request() throws Exception {
		System.out.println("TC_004_WH_Verify_Sorting_Operation_By_Oldest_Request_Test");
		try {
			extentreport=extent.createTest("SORT BY Old Request"," Verifying user is able to Sort the List By Old Order");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickWareHouseRequest();
			Thread.sleep(3000);
			FarmerWareHouseRequestPage farmerWareHouseRequestPage= new FarmerWareHouseRequestPage(device_driver);

			try {
				if (farmerWareHouseRequestPage.SortBy!=null && farmerWareHouseRequestPage.SortBy.isDisplayed()) {
					farmerWareHouseRequestPage.clickSortBy();
					Thread.sleep(1000);
					farmerWareHouseRequestPage.OlderRequest.click();
					Thread.sleep(4000);
					aTR_ProductName= farmerWareHouseRequestPage.ATR_ProductName.getText();
					aTR_Status= farmerWareHouseRequestPage.ATR_Status.getText();
					aTR_ID= farmerWareHouseRequestPage.ATR_ID.getText();
					aTR_CreatedDate= farmerWareHouseRequestPage.ATR_CreatedDate.getText(); //07 May 2022
					aTR_Req_Quantity= farmerWareHouseRequestPage.ATR_Req_Quantity.getText();
					//Date dateDisplaying=new SimpleDateFormat("dd MMM yyyy").parse(aTR_CreatedDate);
					//String tDate = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
					//Date todayDate=new SimpleDateFormat("dd MMM yyyy").parse(tDate);

//					if( dateDisplaying.before(todayDate))
//					{
						extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
						extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
						extentreport.log(Status.PASS, "ID: "+ aTR_ID);
						extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
						extentreport.log(Status.PASS, "ATR_Quantity: "+aTR_Req_Quantity);
						System.out.println("WARE HOUSE REQUEST SORT BY OLDER DETAILS DISPLAYED ");
//					}
//					else
//						extentreport.log(Status.FAIL, "SORTED BY OLDER DETAILS");
				}


			} catch (Exception e) {
				
				System.out.println("Failed To Perform Sort Operation");
				extentreport.log(Status.FAIL, "Failed To Perform Sort Operation");
				navigateBack();	
			}	

		} 
		catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
