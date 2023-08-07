package com.farmer.scripts.WarehouseRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_005_EditATR_Test extends BaseTest{

	float dQty;
	float dQty1;

	@Test
	public void WH_EditATR() {
		try {

			System.out.println("WH_EditATR");
			extentreport= extent.createTest("Edit ATR","Verify Edit ATR");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);			

			try {
				if (farmerWareHouseRequestPage.Edit_ATR.isDisplayed()) {
					String disp_Qty = farmerWareHouseRequestPage.ATR_Req_Quantity.getText();
					String qty = disp_Qty.replaceAll("[^\\d.]", "");
					dQty = Float.parseFloat(qty);

					System.out.println(dQty);
					farmerWareHouseRequestPage.Edit_ATR.click();
				}

				try {
					if (farmerWareHouseRequestPage.E_Message.isDisplayed()) {
						String e_Msg = farmerWareHouseRequestPage.E_Message.getText();
						System.out.println(e_Msg);
						extentreport.log(Status.PASS, "Message Displayed: "+e_Msg);
						farmerWareHouseRequestPage.IncrementBtn.click();
						AppiumGeneric.scrollIntoView("Proceed");
						farmerWareHouseRequestPage.E_EditRemarks.clear();
						farmerWareHouseRequestPage.E_EditRemarks.sendKeys("Editing QA");
						farmerWareHouseRequestPage.E_Proceed.click();
						validateEdit();
						navigateBack();
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					System.out.println("Edit ATR Disabled");
					extentreport.log(Status.INFO, "Edit ATR Disabled");
					navigateBack();
				}
			} catch (Exception e) {
				System.out.println("No Record");
				extentreport.log(Status.INFO, "No Record Is Avaliable");
				navigateBack();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw (e);
		}
	}



	public void validateEdit() {
		try {
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);				
			farmerWareHouseRequestPage.ConfirmYES.click();
			String qty = farmerWareHouseRequestPage.ATR_Req_Quantity.getText();
			String dispQty = qty.replaceAll("[^\\d.]", "");
			dQty1 = Float.parseFloat(dispQty);


			if (dQty==dQty1) {
				System.out.println(dQty1);
				System.out.println("Quantity Of The Product Remain Same");
				extentreport.log(Status.INFO, "Quantity Of The Product Remain Same");

			}else {
				System.out.println("Quantity Of The Product Changed");
				extentreport.log(Status.PASS, "W_H Quantity Edited Successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
