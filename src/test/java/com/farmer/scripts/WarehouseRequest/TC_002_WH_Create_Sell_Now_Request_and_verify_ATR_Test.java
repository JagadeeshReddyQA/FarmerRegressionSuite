package com.farmer.scripts.WarehouseRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import dataproviders.ConfigFileReader;
import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_002_WH_Create_Sell_Now_Request_and_verify_ATR_Test extends BaseTest{

	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;

	@Test

	public void wareHouse_SellNow() throws InterruptedException {
		try {

			System.out.println("TC_002_WH_Create_Sell_Now_Request_and_verify_ATR_Test");
			extentreport=extent.createTest("W_H Sell Now Request"," Verifying User Is Able To Create Sell Now Warehouse Request");
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			try {
				//farmerHomePage.waitTillNameisDisplayed();
				farmerHomePage.clickWareHouseRequest();

				try {
					if (farmerWareHouseRequestPage.NoRequests!=null && farmerWareHouseRequestPage.NoRequests.isDisplayed())
						extentreport.log(Status.PASS, "Farmer Requesting Warehouse Sell Now Request For The First Time");
					farmerWareHouseRequestPage.WareHouseRequestBtn.click();
					farmerWareHouseRequestPage.accept_TandC();
				} catch (Exception e) {
					System.out.println("Farmer Have WareHouse Request Record");
					extentreport.log(Status.PASS, "Farmer Requesting WareHouse Sell Now Request");
					if (farmerWareHouseRequestPage.PlusBtn!=null && farmerWareHouseRequestPage.PlusBtn.isDisplayed()) {
						extentreport.log(Status.PASS, "Farmer Had Already Raised WareHouse Request");
						farmerWareHouseRequestPage.PlusBtn.click();
						farmerWareHouseRequestPage.accept_TandC();
					}
				}
				farmerWareHouseRequestPage.selectSellNow();
				Thread.sleep(2000);
				try {
					if (farmerWareHouseRequestPage.SorryMsg.isDisplayed()) {
						String text = farmerWareHouseRequestPage.SorryMsg.getText();
						System.out.println(text);
						extentreport.log(Status.INFO,"Message Displayed: "+text);
						farmerWareHouseRequestPage.Sorry_Cancel.click();
						Thread.sleep(1000);
						navigateBack();
						Thread.sleep(1000);
						navigateBack();


					}

				} catch (Exception e) {
					farmerWareHouseRequestPage.clickProductDpwn();
					Thread.sleep(2000);
					farmerWareHouseRequestPage.SelectPaddy.click();
					Thread.sleep(2000);
					farmerWareHouseRequestPage.selectTodayDate();
					try {
						// If Error Msg
						if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
							String msg = farmerWareHouseRequestPage.ErrorMsg.getText();
							System.out.println(msg);
							System.out.println("User Failed To Create Sell Now Warehouse Request");
							if(msg.contains("Please contact your VC")) {
								extentreport.log(Status.FAIL,"Message Displayed: "+msg);
								navigateBack();
								Thread.sleep(1000);
								navigateBack();
							}
						}	
					} catch (Exception e1) {
						// Continue
						makeRquest();
						sellNowDetails();
					}
				}




			} catch (Exception e) {
				extentreport.log(Status.FAIL, "Failed to Create Sell Now Request and verify ATR");
				System.out.println("Failed to Create Sell Now Request and verify ATR");
				Assert.fail("Test Case Failed", e);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}




	public void makeRquest() throws InterruptedException {
		FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
		try {
			farmerWareHouseRequestPage.Quantity.clear();
			farmerWareHouseRequestPage.Quantity.sendKeys(ConfigFileReader.sellNowQty());
			AppiumGeneric.scrollIntoView("Proceed");
			farmerWareHouseRequestPage.addRemarks();
			farmerWareHouseRequestPage.clickProceed();

			Thread.sleep(1000);
			try {
				farmerWareHouseRequestPage.ConfirmYES.click();
				
				
				/* Implement Referral Screen Code */
				try {
					/* If Snack Bar Message is Displayed Proceed */
					if(farmerWareHouseRequestPage.SnackBar.isDisplayed())
					{
						String msg = farmerWareHouseRequestPage.SnackBar.getText();
						System.out.println("Msg Displayed: "+msg);
						extentreport.log(Status.INFO, "Message Displayed: "+msg);
						navigateBack();
						Thread.sleep(1000);
						navigateBack();	
					}

				} catch (Exception e) {

					/* If Referral Screen Displayed Click on Skip*/
					String referMsg = farmerWareHouseRequestPage.referMsg.getText();
					System.out.println(referMsg);
					extentreport.log(Status.PASS, "Message Displayed: "+referMsg);
					farmerWareHouseRequestPage.clickSkipBtn();
					Thread.sleep(2000);
					String displayedMsg = farmerWareHouseRequestPage.SuccessMsg.getText();
					extentreport.log(Status.PASS, displayedMsg);
					System.out.println(displayedMsg);
					farmerWareHouseRequestPage.ThingsToKnow.click();
					farmerWareHouseRequestPage.ViewMyRequest.click();
					Thread.sleep(7000);
	
				}
				


			} catch (Exception e) {
				Thread.sleep(1000);
				if (farmerWareHouseRequestPage.SorryMsg.isDisplayed()) {
					String sryMsg = farmerWareHouseRequestPage.SorryMsg.getText();
					System.out.println("Msg Displayed: "+sryMsg);
					extentreport.log(Status.INFO, "Message Displayed: "+sryMsg);
					device_NavigateBack();
					Thread.sleep(1000);
					device_NavigateBack();
					Thread.sleep(1000);
					device_NavigateBack();

				}
			}

		} catch (Exception e) {
			Thread.sleep(1000);
			String displayedMsg = farmerWareHouseRequestPage.SuccessMsg.getText();
			extentreport.log(Status.PASS, displayedMsg);
			System.out.println(displayedMsg);
			farmerWareHouseRequestPage.ThingsToKnow.click();
			farmerWareHouseRequestPage.ViewMyRequest.click();
			Thread.sleep(7000);
		}
	}




	public void sellNowDetails() {

		//extentreport=extent.createTest("Sell Now Request Details","Verifying details after creating Sell Now Request");
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
