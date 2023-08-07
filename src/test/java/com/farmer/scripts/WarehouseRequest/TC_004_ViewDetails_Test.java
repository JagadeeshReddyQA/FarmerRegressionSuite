package com.farmer.scripts.WarehouseRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC_004_ViewDetails_Test extends BaseTest{

	String atr_ID;
	String productName;
	String reqDate;
	String qty;
	String warehouseType;
	String warehouse;
	String remarks;

	@Test
	public void WH_ViewDetails() {

		System.out.println("TC_004_ViewDetails");
		try {
			extentreport= extent.createTest("S_R_ViewDetails","Verify View Details");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);


			try {
				Thread.sleep(1000);
				if (farmerWareHouseRequestPage.ATR_ID.isDisplayed()&&farmerWareHouseRequestPage.ViewDetails.isDisplayed()) {
					farmerWareHouseRequestPage.ViewDetails.click();

					try {
						if (farmerWareHouseRequestPage.V_D_ATR_ID.isDisplayed()) {
							atr_ID = farmerWareHouseRequestPage.V_D_ATR_ID.getText();
							productName = farmerWareHouseRequestPage.V_D_Product.getText();
							reqDate = farmerWareHouseRequestPage.V_D_ReqDate.getText();
							qty = farmerWareHouseRequestPage.V_D_Qty.getText();
							warehouseType = farmerWareHouseRequestPage.V_D_WarehouseType.getText();
							warehouse = farmerWareHouseRequestPage.V_D_Warehouse.getText();
							remarks = farmerWareHouseRequestPage.V_D_Remarks.getText();
							
							
							extentreport.log(Status.PASS, "ID: "+ atr_ID);
							extentreport.log(Status.PASS, "Product: "+productName);
							extentreport.log(Status.PASS, "Requried Date: "+reqDate);
							extentreport.log(Status.PASS, "Quantity: "+qty);
							extentreport.log(Status.PASS, "Warehouse Type: "+warehouseType);
							extentreport.log(Status.PASS, "Warehouse Name: "+warehouse);
							extentreport.log(Status.PASS, "Remarks: "+remarks);
						

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
			throw (e);


		}

	}
}
