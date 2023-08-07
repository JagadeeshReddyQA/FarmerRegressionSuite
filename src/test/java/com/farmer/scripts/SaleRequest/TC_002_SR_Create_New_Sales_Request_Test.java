package com.farmer.scripts.SaleRequest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;

public class TC_002_SR_Create_New_Sales_Request_Test extends BaseTest{

	String noRecordMsg;
	String dMsg;
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	double dQty;
	double denteredQty;
	boolean displayedMsg;

	@Test

	public void salesRequest_NewRequest() throws Exception {

		String product = null;
		System.out.println("TC_002_SR_Create_New_Sales_Request_Test");
		try {

			extentreport= extent.createTest("S_R_NewRequest","Verify Sales Request Screen If No Records Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
			//
			Thread.sleep(2000);
			farmerHomePage.marketRate_Paddy();
			Thread.sleep(2000);
			farmerHomePage.marketRate_Wheat();
			Thread.sleep(2000);
			farmerHomePage.marketRate_Maize();

			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			try {//TRY:: If No Request Displayed Catch:: If + Btn Displayed
				if (farmerSalesRequest.NoRequest.isDisplayed()) {
					noRecordMsg = farmerSalesRequest.NoRequest.getText();
					System.out.println(noRecordMsg);
					extentreport.log(Status.PASS,noRecordMsg);
				}
				
					if (farmerSalesRequest.SalesRequestBtn.isDisplayed()) {
						farmerSalesRequest.SalesRequestBtn.click();
	
						farmerSalesRequest.Product.click();
						Thread.sleep(2000);
						farmerSalesRequest.Select_Product.click();
						Thread.sleep(5000);
						farmerSalesRequest.wareHouse.click();
						Thread.sleep(3000);
						farmerSalesRequest.selectWarehouse.click();
						Thread.sleep(5000);
						
					}
					try {
						if (farmerSalesRequest.wareHouse.isDisplayed()) {
							Thread.sleep(5000);
							farmerSalesRequest.selectQuantity();
							Thread.sleep(1000);
							product = farmerSalesRequest.Product_Type.getText();
							String qty = farmerSalesRequest.enteredQty.getText();
							dQty = Double.parseDouble(qty);

							System.out.println(qty);
							System.out.println(product);
						}
						if (product.equalsIgnoreCase("Paddy")) {

							System.out.println(paddyMarketPrice);
							Double dprice =dQty*paddyMarketPrice;
							denteredQty = Math.ceil(dprice);
							System.out.println(denteredQty);
							farmerSalesRequest.expected_Price.sendKeys(denteredQty+"");
							request();
							confirmRequest();
						}
						else if (product.equalsIgnoreCase("Wheat")) {
							System.out.println(wheatMarketPrice);
							Double dprice =dQty*wheatMarketPrice;
							denteredQty = Math.ceil(dprice);
							System.out.println(denteredQty);
							farmerSalesRequest.expected_Price.sendKeys(denteredQty+"");
							request();
							confirmRequest();
						}
						else if (product.equalsIgnoreCase("Maize")) {
							System.out.println(maizeMarketPrice);
							Double dprice =dQty*maizeMarketPrice;
							denteredQty = Math.ceil(dprice);
							System.out.println(denteredQty);
							farmerSalesRequest.expected_Price.sendKeys(denteredQty+"");
							request();
							confirmRequest();
						}

					} catch (Exception e) {
						//TRY:: If Product is Displayed Proceed Catch:: Print No Product 
						System.out.println("No Product To Select");
						extentreport.log(Status.INFO,"No Product Is Avaliable");
						device_NavigateBack();
						navigateBack();
						navigateBack();
					}



				

			} catch (Exception e) {
				//TRY:: If No Request Displayed Catch:: If + Btn Displayed
				if (farmerSalesRequest.PlusBtn!=null && farmerSalesRequest.PlusBtn.isDisplayed()) {
					extentreport.log(Status.INFO, "Farmer Have Sale Request Record");

					// If + Btn Request Btn Displayed 
					if (farmerSalesRequest.PlusBtn.isDisplayed()) {
						farmerSalesRequest.PlusBtn.click();
						farmerSalesRequest.Product.click();
						Thread.sleep(3000);

						try {//TRY:: If Product is Displayed Proceed Catch:: Print No Product 
							if (farmerSalesRequest.Select_Product.isDisplayed()) {
								farmerSalesRequest.Select_Product.click();
								Thread.sleep(5000);
								farmerSalesRequest.wareHouse.click();
								Thread.sleep(3000);
								farmerSalesRequest.selectWarehouse.click();
								Thread.sleep(5000);
								farmerSalesRequest.selectQuantity();
								Thread.sleep(1000);
								product = farmerSalesRequest.Product_Type.getText();
								String qty = farmerSalesRequest.enteredQty.getText();
								dQty = Double.parseDouble(qty);

								System.out.println(qty);
								System.out.println(product);

							}
							if (product.equalsIgnoreCase("Paddy")) {

								System.out.println(paddyMarketPrice);
								Double dprice =dQty*paddyMarketPrice;
								denteredQty = Math.ceil(dprice);
								System.out.println(denteredQty);
								farmerSalesRequest.expected_Price.sendKeys(denteredQty+"");
								request();
								confirmRequest();
							}
							else if (product.equalsIgnoreCase("Wheat")) {
								System.out.println(wheatMarketPrice);
								Double dprice =dQty*wheatMarketPrice;
								denteredQty = Math.ceil(dprice);
								System.out.println(denteredQty);
								farmerSalesRequest.expected_Price.sendKeys(denteredQty+"");
								request();
								confirmRequest();
							}
							else if (product.equalsIgnoreCase("Maize")) {
								System.out.println(maizeMarketPrice);
								Double dprice =dQty*maizeMarketPrice;
								denteredQty = Math.ceil(dprice);
								System.out.println(denteredQty);
								farmerSalesRequest.expected_Price.sendKeys(denteredQty+"");
								request();
								confirmRequest();
							}

						} catch (Exception e2) {
							System.out.println("No Product To Select");
							extentreport.log(Status.INFO,"No Product Is Avaliable");
							navigateBack();
							navigateBack();
							navigateBack();
						}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}

	}

	public void request() {
		FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
		farmerSalesRequest.selectAvaliableOn();
		AppiumGeneric.scrollIntoView("Select Date");
		//AppiumGeneric.scrollIntoView("EXPIRY ON");
		farmerSalesRequest.selectExpiryOn();
		farmerSalesRequest.clickSubmitBtn();
	}

	public void confirmRequest() {

		FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
		farmerSalesRequest.ConfirmYES.click();
		try {
			if (farmerSalesRequest.SnackBar.isDisplayed()) {
				String text = farmerSalesRequest.SnackBar.getText();
				try {
					//Farmer has an open loan request
					if(text.contains("Farmer has an open loan request")) {
						System.out.println(text);
						extentreport.log(Status.INFO, "Message Displayed: "+text);
						navigateBack();
						navigateBack();
					}
					//Sales Request Added Successfully
					else if (text.contains("Sales Request Added Successfully")) {
						//dMsg = farmerSalesRequest.SuccessMsg.getText();
						extentreport.log(Status.PASS, "Message Displayed: "+text);
						System.out.println(text);

						farmerSalesRequest.ViewMyRequest.click();
						sale_Request_Details();
						navigateBack();

					}

				} catch (Exception e) {

				}
			}

		} catch (Exception e) {

		}
	}
	public void sale_Request_Details() {
		try {
			Thread.sleep(1000);
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);
			aTR_ProductName= farmerSalesRequest.ATR_ProductName.getText();
			aTR_Status= farmerSalesRequest.ATR_Status.getText();
			aTR_ID= farmerSalesRequest.ATR_ID.getText();
			aTR_CreatedDate= farmerSalesRequest.ATR_CreatedDate.getText();
			extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
			extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
			extentreport.log(Status.PASS, "ID: "+ aTR_ID);
			extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
			System.out.println("SALE REQUEST DETAILS DISPLAYED ");

		} catch (Exception e) {

		}
	}





}
