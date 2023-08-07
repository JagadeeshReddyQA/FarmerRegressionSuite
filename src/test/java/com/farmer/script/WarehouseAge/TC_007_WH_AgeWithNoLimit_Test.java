package com.farmer.script.WarehouseAge;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_007_WH_AgeWithNoLimit_Test extends BaseTest {
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;
	
	@Test
	public void warehouseAgeWithNoLimit() throws Exception {

		try {

			System.out.println("TC_007_WH_AgeWithNoLimit_Test");
			extentreport= extent.createTest("TC_007_WH_AgeWithNoLimit_Test","Verify warehouse with no limitations should be able to create request");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERNAME55");
			String password = getValue("PASSWORD55");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);

			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}

			farmerHomepage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.PlusBtn.click();
			farmerWareHouseRequestPage.accept_TandC();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectPaddy.click();
			farmerWareHouseRequestPage.selectTodayDate();
			try {
				// If Error Msg :: No Harvest Information Is Avaliable.Please Contact Your VC.
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String msg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println("Message Displayed:"+msg);

					if(msg.contains("Please contact your VC")) {
						extentreport.log(Status.INFO,"Message Displayed: "+msg);
						extentreport.info("TurnOff LandInAcers Configuration in DB!!!!");
						navigateBack();
						navigateBack();
						farmerHomepage.logout();
					}
				}

			} catch (Exception e) {
				farmerWareHouseRequestPage.Quantity.clear();
				String qty = getValue("QTY55");
				farmerWareHouseRequestPage.Quantity.sendKeys(qty);
				AppiumGeneric.scrollIntoView("Proceed");
				farmerWareHouseRequestPage.addRemarks();
				farmerWareHouseRequestPage.clickProceed();
				farmerWareHouseRequestPage.ConfirmYES.click();
				Thread.sleep(2000);
				try {
					Thread.sleep(1000);
					String displayedMsg = farmerWareHouseRequestPage.SuccessMsg.getText();
					extentreport.log(Status.PASS, displayedMsg);
					System.out.println(displayedMsg);
					farmerWareHouseRequestPage.ThingsToKnow.click();
					farmerWareHouseRequestPage.ViewMyRequest.click();
					sellNowDetails();

				} catch (Exception e1) {
					System.out.println("No Pop Up Message Displayed");
					extentreport.info("No Pop Up Message Displayed");
					navigateBack();
					navigateBack();
				}
				Thread.sleep(1000);
				farmerHomepage.logout();
			}

			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}
	public void sellNowDetails() {  	

		FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
		aTR_ProductName= farmerWareHouseRequestPage.ATR_ProductName.getText();
		aTR_Status= farmerWareHouseRequestPage.ATR_Status.getText();
		aTR_ID= farmerWareHouseRequestPage.ATR_ID.getText();
		aTR_CreatedDate= farmerWareHouseRequestPage.ATR_CreatedDate.getText();
		aTR_Req_Quantity= farmerWareHouseRequestPage.ATR_Req_Quantity.getText();

		extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
		extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
		extentreport.log(Status.PASS, "ID: "+ aTR_ID);
		extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
		extentreport.log(Status.PASS, "ATR_Quantity: "+aTR_Req_Quantity);
		System.out.println("DETAILS DISPLAYED ");
		device_NavigateBack();

	}
}
