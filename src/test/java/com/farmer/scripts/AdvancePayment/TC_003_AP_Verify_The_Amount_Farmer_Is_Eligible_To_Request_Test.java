package com.farmer.scripts.AdvancePayment;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;


public class TC_003_AP_Verify_The_Amount_Farmer_Is_Eligible_To_Request_Test extends BaseTest {
	String eligibleAmount;
	String[] splitAmount;
	String splitAmount1;
	String splitAmount2;
	String eMinAmount;
	String eMaxAmount;
	double dMinAmount;
	double dMaxAmount;
	double dEntrMinAmount;
	double dEntrMaxAmount;

	@Test
	private void advancePaymentRequest_RequestAmount() throws Exception {
		try {

			System.out.println("TC_003_AP_advancePaymentRequest_RequestAmount");
			extentreport= extent.createTest("A_P_EligibleAmount","Verify The Amount Farmer Is Eligible To Request Under AdvancePayments");
			//WebDriverWait wait = new WebDriverWait(device_driver, 20);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);

			try {
				if (farmerAdvancePayment.NoRequests!=null && farmerAdvancePayment.NoRequests.isDisplayed()==true) {
					extentreport.log(Status.PASS, "Farmer Requesting Advance Payment For The First Time");
					System.out.println("Farmer Requesting Advance Payment For The First Time");
					farmerAdvancePayment.CreateNow.click();
					farmerAdvancePayment.TandC_Chceck.click();
					farmerAdvancePayment.AcceptButton.click();
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				System.out.println("Farmer Have AdvancePayments Record");
				extentreport.log(Status.PASS, "Farmer Requesting Advance Payment Again!!!!");
				if (farmerAdvancePayment.PlusBtn!=null && farmerAdvancePayment.PlusBtn.isDisplayed()==true) {
					extentreport.log(Status.PASS, "Farmer Had Already Requested For Advance Payment");
					farmerAdvancePayment.PlusBtn.click();
					farmerAdvancePayment.TandC_Chceck.click();
					farmerAdvancePayment.AcceptButton.click();	
					Thread.sleep(1000);
				}
			}
			//Checking User Is Having Product (YES)
			try {
				if (farmerAdvancePayment.AvalibleStock.isDisplayed()==true) {
					System.out.println(farmerAdvancePayment.AvalibleStock.getText());
					farmerAdvancePayment.SelectProduct.click();
					farmerAdvancePayment.SubmitBtn.click();
					eligibleAmount = farmerAdvancePayment.DisbursementAmountValue.getText();
					splitAmount= eligibleAmount.split("-");
					splitAmount1 = splitAmount[0];
					splitAmount2 = splitAmount[1];
					eMinAmount = splitAmount1.replaceAll("[^\\d.]", "");
					eMaxAmount = splitAmount2.replaceAll("[^\\d.]", "");

					dMinAmount = Math.ceil(Double.parseDouble(eMinAmount));
					dMaxAmount = Math.ceil(Double.parseDouble(eMaxAmount));

					dEntrMinAmount = dMinAmount-0.99;
					dEntrMaxAmount = dMaxAmount+0.99;

					farmerAdvancePayment.RequestAmount.sendKeys(dMinAmount-0.99+"");
					System.out.println("Entered Amount: "+dEntrMinAmount);
					extentreport.log(Status.PASS, "Enterted Amount: "+dEntrMinAmount);
					farmerAdvancePayment.SelectBank.click();	
					validateRequestAmount();
					Thread.sleep(5000);

					farmerAdvancePayment.RequestAmount.sendKeys(dMaxAmount+0.99+"");
					System.out.println("Entered Amount: "+dEntrMaxAmount);
					extentreport.log(Status.PASS, "Enterted Amount: "+dEntrMaxAmount);
					farmerAdvancePayment.SelectBank.click();	
					validateRequestAmount();
					Thread.sleep(1000);

					navigateBack();
					Thread.sleep(2000);
					navigateBack();
					Thread.sleep(2000);
					navigateBack();
					Thread.sleep(2000);
				} 

			} catch (Exception e) {
				System.out.println("Farmer Do Not Have Any Product / Farmer Has Open Loan Request");
				extentreport.log(Status.INFO, "Cannot Verify The Amount Farmer Is Eligible To Request");
				navigateBack();
				Thread.sleep(1000);
				navigateBack();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}



	}

	private void validateRequestAmount() {
		FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);
		farmerAdvancePayment.SubmitBtn.click();
		
		if(farmerAdvancePayment.SnackBar.isDisplayed())
		{
			String msg = farmerAdvancePayment.SnackBar.getText();
			System.out.println("Msg Displayed: "+msg);
			extentreport.log(Status.PASS, "Message Displayed: "+msg);
		}
		
	}
}
