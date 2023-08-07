package com.farmer.scripts.StockReleaseRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import dataproviders.ConfigFileReader;
import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStockReleaseRequestsPage;

public class TC_003_SRR_Creating_New_SR_Request_Sell_Test extends BaseTest{
	String stock;
	String availableStock;
	String price;
	String currentPrice;
	String remarks;
	boolean displayedMsg;
	String dMsg;
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Req_Quantity;


	@Test


	public void stockReleaseRequest_Sell() throws Exception {


		System.out.println("TC_003_SSR_stockReleaseRequest_Sell");

		try {
			extentreport= extent.createTest("Stock Release Request_Sell","Create New Sell Stock Release Request");
			AppiumGeneric.quickActionSwipe();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.QuickActionStockRelease.click();

			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
			try {

				if (farmerStockReleaseRequestsPage.NoRequests!=null && farmerStockReleaseRequestsPage.NoRequests.isDisplayed()) 
					extentreport.log(Status.PASS, "Farmer Requesting Stock Release Request For The First Time");
				farmerStockReleaseRequestsPage.StockRequestBtn.click();
				farmerStockReleaseRequestsPage.TandC_Chceck.click();
				farmerStockReleaseRequestsPage.AcceptButton.click();
			} catch (Exception e) {

				System.out.println("Farmer Have AdvancePayments Record");
				extentreport.log(Status.PASS, "Farmer Requesting Advance Payment Again!!!!");
				if (farmerStockReleaseRequestsPage.PlusBtn!=null && farmerStockReleaseRequestsPage.PlusBtn.isDisplayed()==true) {
					extentreport.log(Status.PASS, "Farmer Had Already Requested For Stock Release");
					farmerStockReleaseRequestsPage.PlusBtn.click();
					farmerStockReleaseRequestsPage.TandC_Chceck.click();
					farmerStockReleaseRequestsPage.AcceptButton.click();	
				}
			}
			try {
				if (farmerStockReleaseRequestsPage.Sell.isDisplayed()) {
					farmerStockReleaseRequestsPage.Sell.click();
					Thread.sleep(3000);
					farmerStockReleaseRequestsPage.WareHouse.click();
					farmerStockReleaseRequestsPage.Select_WareHouse.click();
					Thread.sleep(4000);
					farmerStockReleaseRequestsPage.Sell_Select_Product.click();
					farmerStockReleaseRequestsPage.Proceed.click();
					stock = farmerStockReleaseRequestsPage.AvailableStock.getText();
					availableStock = stock.replaceAll("[^\\d.]", "");
					System.out.println(availableStock);
					price = farmerStockReleaseRequestsPage.CurrentPrice.getText();
					currentPrice = price.replaceAll("[^\\d.]", "");
					System.out.println(currentPrice);
					remarks="Enter Remarks";
					device_driver.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
									+ remarks + "\").instance(0))");
					farmerStockReleaseRequestsPage.BuyerName.sendKeys("Buyer's Name");
					farmerStockReleaseRequestsPage.Rate.sendKeys(currentPrice);
					farmerStockReleaseRequestsPage.Quantity_In_Quintal.sendKeys(availableStock);
					farmerStockReleaseRequestsPage.DateFeild.click();
					farmerStockReleaseRequestsPage.DateOK.click();
					Thread.sleep(2000);
					device_driver.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
									+ remarks + "\").instance(0))");
					farmerStockReleaseRequestsPage.Remarks.sendKeys(ConfigFileReader.remarks());
					farmerStockReleaseRequestsPage.Proceed.click();
					try {
						if (farmerStockReleaseRequestsPage.SnackBar.isDisplayed()) {
							String msg = farmerStockReleaseRequestsPage.SnackBar.getText();
							System.out.println("Msg Displayed: "+msg);
							extentreport.log(Status.INFO, "Message Displayed: "+msg);
							navigateBack();
							Thread.sleep(1000);
							navigateBack();
							try {
								navigateBack();
								
							} catch (Exception e) {
								
							}

						}

					} catch (Exception e) {
						sellRequest();
					}
				}

			} catch (Exception e) {
				System.out.println("Farmer Do Not Have Any Product");
				extentreport.log(Status.INFO, "Farmer Cannot Make S_R_Request!! Do Not Have Any Product!!");
				device_NavigateBack();
				Thread.sleep(2000);
				navigateBack();
				//navigateBack();
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		
		}

	}


	private void sellRequest() {

		FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);
		try {
			farmerStockReleaseRequestsPage.ConfirmYES.click();
			if(farmerStockReleaseRequestsPage.SnackBar.isDisplayed())
			{
				String msg = farmerStockReleaseRequestsPage.SnackBar.getText();
				System.out.println("Msg Displayed: "+msg);
				extentreport.log(Status.INFO, "Message Displayed: "+msg);
				navigateBack();
				navigateBack();
				navigateBack();
			}
		} catch (Exception e) {
			displayedMsg = farmerStockReleaseRequestsPage.SuccessMsg.isDisplayed();
			Assert.assertTrue(true);
			Assert.assertEquals(displayedMsg,true);
			dMsg = farmerStockReleaseRequestsPage.SuccessMsg.getText();
			extentreport.log(Status.PASS, "Message Displayed: "+dMsg);
			farmerStockReleaseRequestsPage.ViewMyRequest.click();
			sr_Request_Details();
			navigateBack();
		}
	}

	private void sr_Request_Details() {
		try {
			FarmerStockReleaseRequestsPage farmerStockReleaseRequestsPage = new FarmerStockReleaseRequestsPage(device_driver);

			aTR_ProductName= farmerStockReleaseRequestsPage.ATR_ProductName.getText();
			aTR_Status= farmerStockReleaseRequestsPage.ATR_Status.getText();
			aTR_ID= farmerStockReleaseRequestsPage.ATR_ID.getText();
			aTR_CreatedDate= farmerStockReleaseRequestsPage.ATR_CreatedDate.getText();
			extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
			extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
			extentreport.log(Status.PASS, "ID: "+ aTR_ID);
			extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
			System.out.println("STOCK RELEASE REQUEST DETAILS DISPLAYED ");

		} catch (Exception e) {

		}
	}
}
