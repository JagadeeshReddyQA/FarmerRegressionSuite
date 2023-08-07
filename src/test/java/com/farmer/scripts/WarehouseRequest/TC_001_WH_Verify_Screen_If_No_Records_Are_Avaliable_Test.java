package com.farmer.scripts.WarehouseRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_001_WH_Verify_Screen_If_No_Records_Are_Avaliable_Test extends BaseTest{

	@Test
	
	public void warehouseRequest_NoRecord() throws Exception {

		try {

			System.out.println("TC_001_WH_Verify_Screen_If_No_Records_Are_Avaliable_Test");
			extentreport= extent.createTest("WareHouse Request","Verify WareHouse Request Screen If No Records Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickWareHouseRequest();
			Thread.sleep(2000);
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			

			//Scenario: When there are No WareHouse Request requests 
			//Verify WareHouse Request Screen If No Records Are Avaliable
			try {
				if (farmerWareHouseRequestPage.NoRequests!=null && farmerWareHouseRequestPage.NoRequests.isDisplayed()==true) {
					String text = farmerWareHouseRequestPage.NoRequests.getText();
					extentreport.log(Status.PASS, text);
				}

			} catch (Exception e) {
				//Verify WH Request Screen If  Records Are Avaliable
				if (farmerWareHouseRequestPage.PlusBtn!=null && farmerWareHouseRequestPage.PlusBtn.isDisplayed()==true) {
					extentreport.log(Status.INFO, "Farmer Have WareHouse Request Record");
				}

			}


			navigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}
		
	}

}
