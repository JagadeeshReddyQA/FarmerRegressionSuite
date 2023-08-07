package com.farmer.script.SoilTest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSoilTestPage;

public class TC_009_ST_OpenTab_FilterOperation_Test extends BaseTest{
	String aTR_Status;
	String aTR_ID;
	String atr_TestID;
	String atr_Timestamp;

	@Test
	public void openTab_Filter() throws Exception {

		try {
			System.out.println("TC_009_ST_OpenTab_FilterOperation_Test");
			extentreport=extent.createTest("ST_Filter Operation Open Tab"," Verifying user is able to Filter the List under Open tab");

			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);
			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();
			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			farmerSoilTestPage.clickOpenTab();



			try {
				aTR_ID = farmerSoilTestPage.ATR_ID.getText();
				farmerSoilTestPage.clickFilter();
				extentreport.log(Status.PASS,"Filter through Search ATR Number");
				farmerSoilTestPage.Search_ATR_NBR.sendKeys(aTR_ID);
				farmerSoilTestPage.clickApplyFilter();
				Thread.sleep(2000);
				atr_Details();
				Thread.sleep(2000);
				farmerSoilTestPage.clickFilter();
				farmerSoilTestPage.Reset.click();
				extentreport.log(Status.PASS,"Filter through Start Date and End Date");
				farmerSoilTestPage.StartDate.click();
				farmerSoilTestPage.PreviousMonth.click();
				farmerSoilTestPage.SelectDate_Start.click();
				farmerSoilTestPage.Cal_OKBtn.click();
				farmerSoilTestPage.EndDate.click();
				farmerSoilTestPage.Cal_OKBtn.click();
				farmerSoilTestPage.clickApplyFilter();
				atr_Details();
				device_driver.navigate().back();



			} catch (Exception e) {

				System.out.println("Failed To Perform Filter Operation");
				extentreport.log(Status.FAIL, "Failed To Perform Filter Operation");
				navigateBack();	
			}	
			extentreport.log(Status.PASS,"Test Case executed Successfully");
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}
	public void atr_Details() throws IOException {
		try {
			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			if (farmerSoilTestPage!=null && farmerSoilTestPage.ATR_ID!=null &&farmerSoilTestPage.ATR_Status.isDisplayed()==true) {
				aTR_ID = farmerSoilTestPage.ATR_ID.getText();
				aTR_Status = farmerSoilTestPage.ATR_Status.getText();
				atr_TestID = farmerSoilTestPage.Test_ID.getText();
				atr_Timestamp = farmerSoilTestPage.ATR_TimeStamp.getText();
				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
				extentreport.log(Status.PASS, "Test_ID: "+ atr_TestID);
				extentreport.log(Status.PASS, "ATR_TimeStamp: "+ atr_Timestamp);
			}
		} catch (Exception e) {
			extentreport.log(Status.PASS, "No Records Found");
			System.out.println("No Records Found");

		}
	}
}
