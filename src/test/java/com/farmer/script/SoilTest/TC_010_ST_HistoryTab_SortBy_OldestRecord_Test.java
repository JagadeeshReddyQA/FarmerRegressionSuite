package com.farmer.script.SoilTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSoilTestPage;

public class TC_010_ST_HistoryTab_SortBy_OldestRecord_Test extends BaseTest{
	
	String aTR_Status;
	String aTR_ID;
	String atr_TestID;
	String atr_Timestamp;
	@Test

	public void historyTab_Sort_By_Old_Request() throws Exception {

		try {
			System.out.println("TC_010_ST_HistoryTab_SortBy_OldestRecord_Test");
			extentreport=extent.createTest("ST_Sort By Old Request History Tab"," Verifying user is able to Sort the List By Old Order under History tab");
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();
			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			farmerSoilTestPage.clickHistoryTab();

			try {
				if (farmerSoilTestPage.SortBy!=null && farmerSoilTestPage.SortBy.isDisplayed()) {
					farmerSoilTestPage.clickSortBy();
					farmerSoilTestPage.OlderRequest.click();
					Thread.sleep(2000);

					aTR_ID = farmerSoilTestPage.ATR_ID.getText();
					aTR_Status = farmerSoilTestPage.ATR_Status.getText();
					atr_TestID = farmerSoilTestPage.Test_ID.getText();
					atr_Timestamp = farmerSoilTestPage.ATR_TimeStamp.getText();

					extentreport.log(Status.PASS, "ATR_ID: "+aTR_ID);
					extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
					extentreport.log(Status.PASS, "Test_ID: "+atr_TestID);
					extentreport.log(Status.PASS, "ATR_TimeStamp: "+atr_Timestamp);

					System.out.println("SOIL TEST SORT BY OLDER DETAILS DISPLAYED ");

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
