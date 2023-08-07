package com.farmer.scripts.AdvancePayment;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;


public class TC_002_AP_Verify_When_There_Are_No_Products_Available_Test extends BaseTest{
	@Test
	
	private void advanvePayment_NoProduct() {
		try {
			System.out.println("TC_002_AP_advanvePayment_NoProduct");
			extentreport= extent.createTest("A_P_NoProduct","Verify Advance Payment Request When there are No Products Available");

			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);


			try {
				//If ::No Request Yet ! MSG Displayed
				if (farmerAdvancePayment!=null && farmerAdvancePayment.NoRequests!=null && farmerAdvancePayment.NoRequests.isDisplayed()) {
					extentreport.log(Status.PASS, "Farmer Requesting Advance Payment For The First Time");
					farmerAdvancePayment.CreateNow.click();
					farmerAdvancePayment.TandC_Chceck.click();
					farmerAdvancePayment.AcceptButton.click();
					Thread.sleep(1000);

					try {
						String text = farmerAdvancePayment.NoProduct.getText();
						// If No Product is avaliable
						if(text.contains("no grain"))
						{
							extentreport.log(Status.PASS, text);
							device_NavigateBack();
							Thread.sleep(1000);
							device_NavigateBack();
						}

					}catch (Exception e) {
						// TODO: handle exception
						//If Product is Avaliable
						extentreport.log(Status.PASS,"Product Is Avaliable");
						navigateBack();
						Thread.sleep(1000);
						navigateBack();
					}
				}
			} catch (Exception e) {
				//If No ::No Request Yet ! MSG Displayed
				if(farmerAdvancePayment.PlusBtn!=null && farmerAdvancePayment.PlusBtn.isDisplayed()==true){
					System.out.println("Farmer Already Created Advance Payments Request");
					extentreport.log(Status.INFO,"Farmer Already Created Advance Payments Request");
					navigateBack();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}
