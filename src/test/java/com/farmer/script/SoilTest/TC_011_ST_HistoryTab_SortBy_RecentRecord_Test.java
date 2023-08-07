package com.farmer.script.SoilTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerSoilTestPage;

public class TC_011_ST_HistoryTab_SortBy_RecentRecord_Test extends BaseTest{

	String aTR_Status;
	String aTR_ID;
	String atr_TestID;
	String atr_Timestamp;
	@Test

	public void historyTab_Sort_By_Recent_Request() throws Exception {

		try {
			System.out.println("TC_011_ST_HistoryTab_SortBy_RecentRecord_Test");
			extentreport=extent.createTest("ST_Sort By Recent Request History Tab"," Verifying user is able to Sort the List By Recent Order under History tab");

			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			farmerSoilTestPage.clickHistoryTab();

			try {
				if (farmerSoilTestPage.SortBy!=null && farmerSoilTestPage.SortBy.isDisplayed()) {
					farmerSoilTestPage.clickSortBy();
					farmerSoilTestPage.RecentRequest.click();
					Thread.sleep(2000);

					aTR_ID = farmerSoilTestPage.ATR_ID.getText();
					aTR_Status = farmerSoilTestPage.ATR_Status.getText();
					atr_TestID = farmerSoilTestPage.Test_ID.getText();
					atr_Timestamp = farmerSoilTestPage.ATR_TimeStamp.getText();

					extentreport.log(Status.PASS, "ATR_ID: "+aTR_ID);
					extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
					extentreport.log(Status.PASS, "Test_ID: "+atr_TestID);
					extentreport.log(Status.PASS, "ATR_TimeStamp: "+atr_Timestamp);
					System.out.println("SOIL TEST SORT BY RECENT DETAILS DISPLAYED ");
					navigateBack();

				}


			} catch (Exception e) {

				System.out.println("Failed To Perform Sort Operation");
				extentreport.log(Status.FAIL, "Failed To Perform Sort Operation");
				navigateBack();	
			}	
			extentreport.log(Status.PASS,"Test Case executed Successfully");
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}
}
