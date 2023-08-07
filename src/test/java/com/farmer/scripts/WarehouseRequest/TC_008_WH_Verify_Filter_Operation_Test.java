package com.farmer.scripts.WarehouseRequest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_008_WH_Verify_Filter_Operation_Test extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;
	boolean aTR_Status_Diaplayed;
	@Test
	
	public void wareHouse_Request_Filter_Operation() {
		System.out.println("TC_008_WH_Verify_Filter_Operation_Test");

		try {
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage= new FarmerWareHouseRequestPage(device_driver);

			extentreport=extent.createTest("FILTER OPERATION"," Verifying user is able to Filter the List");
			
			//extentreport.createNode("Creating Node", "Node Description");
			//extentreport.assignCategory("WH_FILTER_OPERATION");

			try {
				farmerWareHouseRequestPage.clickFilter();
				extentreport.log(Status.PASS, "Status Of Open Records");
				farmerWareHouseRequestPage.Status_Open.click();
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();

				farmerWareHouseRequestPage.clickFilter();
				extentreport.log(Status.PASS, "Status Of Waiting For Approval Records");
				farmerWareHouseRequestPage.Status_WaitingForApproval.click();
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();
				farmerWareHouseRequestPage.clickFilter();
				extentreport.log(Status.PASS, "Status Of Approved Records");
				farmerWareHouseRequestPage.Status_Approved.click();
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();

				farmerWareHouseRequestPage.clickFilter(); 
				extentreport.log(Status.PASS,"Status Of Not Approved Records");
				farmerWareHouseRequestPage.Status_NotApproved.click();
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();

				farmerWareHouseRequestPage.clickFilter(); 
				extentreport.log(Status.PASS,"Status Of Rejected Records");
				farmerWareHouseRequestPage.Status_Rejected.click();
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();

				farmerWareHouseRequestPage.clickFilter(); 
				extentreport.log(Status.PASS,"Status Of AccountsRejected Records");
				farmerWareHouseRequestPage.Status_Accounts_Rejected.click();
				farmerWareHouseRequestPage.clickApplyFilter(); 
				atr_Details();

				//Date
				farmerWareHouseRequestPage.clickFilter();
				farmerWareHouseRequestPage.ResetBtn.click();
				//extentreport.info("Testing");
				extentreport.log(Status.PASS,"Filter through Start Date and End Date");
				farmerWareHouseRequestPage.StartDate.click();
				farmerWareHouseRequestPage.PreviousMonth.click();
				farmerWareHouseRequestPage.SelectDate_Start.click();
				farmerWareHouseRequestPage.Cal_OKBtn.click();
				farmerWareHouseRequestPage.EndDate.click();
				farmerWareHouseRequestPage.Cal_OKBtn.click();
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();

				//search ATR Number
				farmerWareHouseRequestPage.clickFilter();
				extentreport.log(Status.PASS,"Filter through Search ATR Number");
				farmerWareHouseRequestPage.Search_ATR_NBR.sendKeys(aTR_ID);
				farmerWareHouseRequestPage.clickApplyFilter();
				atr_Details();

				device_driver.navigate().back();

			} 
			catch (Exception e) {
				System.out.println("Filter Disabled");
				navigateBack();		
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw (e);
		}

	}

	public void atr_Details() throws IOException {
		try {
			FarmerWareHouseRequestPage farmerWareHouseRequestPage= new FarmerWareHouseRequestPage(device_driver);
			if (farmerWareHouseRequestPage!=null && farmerWareHouseRequestPage.ATR_ID!=null &&farmerWareHouseRequestPage.ATR_Status.isDisplayed()==true) {
				aTR_ProductName= farmerWareHouseRequestPage.ATR_ProductName.getText();
				aTR_Status= farmerWareHouseRequestPage.ATR_Status.getText();
				aTR_ID= farmerWareHouseRequestPage.ATR_ID.getText();
				aTR_CreatedDate= farmerWareHouseRequestPage.ATR_CreatedDate.getText(); //07 May 2022
				aTR_Req_Quantity= farmerWareHouseRequestPage.ATR_Req_Quantity.getText();
				extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
				extentreport.log(Status.PASS, "ID: "+ aTR_ID);
			}
		} catch (Exception e) {
			extentreport.log(Status.PASS, "No Records Found");
			System.out.println("No Records Found");

		}
	}
}
