package com.farmer.scripts.SaleRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSalesRequest;

public class TC_004_SR_Verify_ViewDetails_OpenTab_Test extends BaseTest{

	String atr_ID;
	String productName;
	String avalDate;
	String expDate;
	String exptdQty;
	String expPrice;
	String tBuyers;
	String recQty;


	@Test

	public void salesRequestViewDetails_OpenTab() throws InterruptedException {

		System.out.println("TC_004_SR_Verify_ViewDetails_OpenTab_Test");
		try {
			extentreport= extent.createTest("S_R_ViewDetails","Verify View Details Under Open Tab");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.QuickActionSalesRequest.click();
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);


			try {
				farmerSalesRequest.clickOpenTab();
				Thread.sleep(1000);
				if (farmerSalesRequest.ATR_ID.isDisplayed()&&farmerSalesRequest.SR_ViewDetails.isDisplayed()) {
					farmerSalesRequest.SR_ViewDetails.click();

					try {
						if (farmerSalesRequest.V_D_ATR_ID.isDisplayed()) {
							atr_ID = farmerSalesRequest.V_D_ATR_ID.getText();
							productName = farmerSalesRequest.V_D_ProductName.getText();
							avalDate = farmerSalesRequest.V_D_AvaliableOn.getText();
							expDate = farmerSalesRequest.V_D_ExpiryOn.getText();
							exptdQty = farmerSalesRequest.V_D_Exp_Quantity.getText();
							expPrice = farmerSalesRequest.V_D_Exp_Price.getText();
							tBuyers = farmerSalesRequest.V_D_Total_Buyers.getText();
							recQty = farmerSalesRequest.V_D_Received_Qty.getText();

							extentreport.log(Status.PASS, "Product: "+productName);
							extentreport.log(Status.PASS, "ID: "+ atr_ID);
							extentreport.log(Status.PASS, "Avaliable_On: "+avalDate);
							extentreport.log(Status.PASS, "Expiry_On: "+expDate);
							extentreport.log(Status.PASS, "Expected Quantity: "+exptdQty);
							extentreport.log(Status.PASS, "Expected Price: "+expPrice);
							extentreport.log(Status.PASS, "Total Buyers: "+tBuyers);
							extentreport.log(Status.PASS, "Received Quantity : "+recQty);

							Thread.sleep(1000);
							device_NavigateBack();
							Thread.sleep(1000);
							navigateBack();
						}

					}
					catch(Exception e) {
						System.out.println("View Details is Disabled");
						extentreport.log(Status.INFO,"View Details is Disabled");
					}

				}

			} catch (Exception e) {
				System.out.println("No Record Found");
				extentreport.log(Status.INFO,"No Record Is Avaliable");
				navigateBack();

			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}
	}
}
