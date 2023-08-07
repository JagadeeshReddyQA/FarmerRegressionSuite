package com.farmer.scripts.WarehouseRequest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_009_Search_ATR_Test extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;
	boolean aTR_Status_Diaplayed;
	String id;
	String atr;
	String num;


	@Test
	public void WH_Search_ATR() {
		System.out.println("TC_009_Search_ATR_Test");

		try {
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage= new FarmerWareHouseRequestPage(device_driver);

			extentreport=extent.createTest("WH_Search_ATR"," Verifying user is able to Search ATR");

			try {
				//Check for ATR Record 
				if (farmerWareHouseRequestPage.ATR_ID.isDisplayed()) {
					id = farmerWareHouseRequestPage.ATR_ID.getText();
					System.out.println(id);
					//Split String and store in variables
					String[] id1= id.split("-");
					atr = id1[0];
					num = id1[1];

					System.out.println(atr);
					System.out.println(num);

					farmerWareHouseRequestPage.clickFilter();
					extentreport.log(Status.PASS, "Search ATR Number: "+atr);
					farmerWareHouseRequestPage.Search_ATR_NBR.sendKeys(atr);
					farmerWareHouseRequestPage.clickApplyFilter();
					atr_Details();
					farmerWareHouseRequestPage.clickFilter();
					extentreport.log(Status.PASS, "Search ATR Number: "+num);
					farmerWareHouseRequestPage.Search_ATR_NBR.sendKeys(num);
					farmerWareHouseRequestPage.clickApplyFilter();
					atr_Details();

					navigateBack();

				}

			} catch (Exception e) {
				System.out.println("No Record Found");
				extentreport.log(Status.INFO, "No Record Found");
				navigateBack();	
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}



	public void atr_Details() throws IOException {
		try {
			FarmerWareHouseRequestPage farmerWareHouseRequestPage= new FarmerWareHouseRequestPage(device_driver);
			if (farmerWareHouseRequestPage!=null && farmerWareHouseRequestPage.ATR_ID!=null &&farmerWareHouseRequestPage.ATR_Status.isDisplayed()) {
				aTR_ProductName= farmerWareHouseRequestPage.ATR_ProductName.getText();
				aTR_Status= farmerWareHouseRequestPage.ATR_Status.getText();
				aTR_ID= farmerWareHouseRequestPage.ATR_ID.getText();
				aTR_CreatedDate= farmerWareHouseRequestPage.ATR_CreatedDate.getText(); 
				aTR_Req_Quantity= farmerWareHouseRequestPage.ATR_Req_Quantity.getText();

				try {
					if(aTR_ID.contains(atr)||aTR_ID.contains(num))
					{
						extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
						extentreport.log(Status.PASS, "ID: "+ aTR_ID);
					}else {
						System.out.println("ATR-ID Not Displayed");
						extentreport.log(Status.INFO, "ATR-ID Not Displayed");
					}

				} catch (Exception e) {
					navigateBack();
				}
			}
		} catch (Exception e) {
			extentreport.log(Status.PASS, "No Records Found");
			System.out.println("No Records Found");

		}
	}

}
