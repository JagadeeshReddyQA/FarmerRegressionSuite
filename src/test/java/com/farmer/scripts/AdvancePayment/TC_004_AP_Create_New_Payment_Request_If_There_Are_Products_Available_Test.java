package com.farmer.scripts.AdvancePayment;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;

public class TC_004_AP_Create_New_Payment_Request_If_There_Are_Products_Available_Test extends BaseTest {
	String eligibleAmount;
	String[] splitAmount;
	String splitAmount1;
	String requestAmount;
	double dRequestAmount;
	double requestAmt;
	@Test

	private void advancePaymentsRequest_ProductAvaliable() throws InterruptedException {
		try {
			System.out.println("TC_004_AP_advancePaymentsRequest_ProductAvaliable");
			extentreport= extent.createTest("A_P_Request","Farmer Is Trying To Create A New Advance Paymetns Request");
			//WebDriverWait wait = new WebDriverWait(device_driver, 20);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			Thread.sleep(2000);
			farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);

			//Scenario::If User Is Requesting AP For 1st Time With One Product(Wheat)
			//If No AP Request! is Displayed Click On Create Now
			try {
				if (farmerAdvancePayment.NoRequests!=null && farmerAdvancePayment.NoRequests.isEnabled()) {
					extentreport.log(Status.PASS, "Farmer Requesting Advance Payment For The First Time");
					System.out.print("Farmer Requesting Advance Payment For The First Time");
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
					Thread.sleep(3000);
				}
			}
			//Checking User Is Having Product (YES)
			try {
				if (farmerAdvancePayment.AvalibleStock.isDisplayed()==true) {
					System.out.println(farmerAdvancePayment.AvalibleStock.getText());
					farmerAdvancePayment.SelectProduct.click();
					farmerAdvancePayment.SubmitBtn.click();
					Thread.sleep(3000);
					// Handle Open Loan Request Scenario

					eligibleAmount = farmerAdvancePayment.DisbursementAmountValue.getText();
					splitAmount= eligibleAmount.split("-");
					splitAmount1 = splitAmount[0];
					requestAmount = splitAmount1.replaceAll("[^\\d.]", "");
					System.out.println(requestAmount);
					dRequestAmount = Math.ceil(Double.parseDouble(requestAmount));
					BankDetails();
					farmerAdvancePayment.RequestAmount.sendKeys(dRequestAmount+"");
					//farmerAdvancePayment.RequestAmount.sendKeys("500");
					farmerAdvancePayment.SelectBank.click();
					farmerAdvancePayment.SubmitBtn.click();
					//wait.until(ExpectedConditions.elementToBeClickable(farmerAdvancePayment.Expand_CS)).click();

					try {
						System.out.println(farmerAdvancePayment.Confirmation_Msg_CS.getText());
						farmerAdvancePayment.Confirm_Yes.click();
						boolean displayedMsg = farmerAdvancePayment.SuccessMsg.isDisplayed();
						Assert.assertEquals(displayedMsg,true);
						extentreport.log(Status.PASS, "Message Displayed: You have successfully created a advance payment request");
						farmerAdvancePayment.ViewMyRequest.click();
						Thread.sleep(1000);
						device_driver.navigate().back();
					} catch (Exception e) {
						System.out.println("Entered amount should be greater than zero");
						extentreport.log(Status.INFO, "Entered amount should be greater than zero");
						device_NavigateBack();
						Thread.sleep(1000);
						device_NavigateBack();
						Thread.sleep(2000);
						device_NavigateBack();
					}
				} 

			} catch (Exception e) {
				System.out.println("Farmer Do Not Have Any Product / Farmer Has Open Loan Request");
				extentreport.log(Status.INFO, "Farmer Cannot Request Advance Payment! Farmer Has Open Loan Request / No Product Is Avaliable");
				device_NavigateBack();	
				Thread.sleep(3000);
				device_NavigateBack();
				Thread.sleep(3000);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}	
	}

	private void BankDetails() throws InterruptedException {
		FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);
		farmerAdvancePayment.Bank_ViewDetails.click();
		String bankName = farmerAdvancePayment.BankName.getText();
		String bankIFSC_CODE = farmerAdvancePayment.IFSC_CODE.getText();
		String bankBranch = farmerAdvancePayment.BranchName.getText();
		String bankAccountNbr = farmerAdvancePayment.AccountNumber.getText();
		String bankAccountNme = farmerAdvancePayment.AccountName.getText();
		String bankAccountType = farmerAdvancePayment.AccountType.getText();
		extentreport.log(Status.PASS,"BANK DETAILS:"+" >BANK NAME:"+bankName+" >IFSC CODE:"+bankIFSC_CODE+" >BRANCH:"+bankBranch
				+" >ACCOUNT NO:"+bankAccountNbr+" >ACCOUNT NAME:"+bankAccountNme+" >ACCOUNT TYPE:"+bankAccountType);
		device_driver.navigate().back();
		Thread.sleep(3000);
	}

}
