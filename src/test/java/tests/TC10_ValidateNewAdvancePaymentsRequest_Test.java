package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;

public class TC10_ValidateNewAdvancePaymentsRequest_Test extends BaseTest{
	@Test

	public void advancePaymentsRequest() throws InterruptedException {
		System.out.println("TC10_ValidateNewAdvancePaymentsRequest_Test");
		try {
			extentreport= extent.createTest("Advance Payments","Farmer is trying to create a new Advance Paymetns Request");
			WebDriverWait wait = new WebDriverWait(device_driver, 20);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);
			farmerHomePage.QuickActionAdvancePayment.click();
			wait.until(ExpectedConditions.visibilityOf(farmerAdvancePayment.PlusBtn)).click();
			farmerAdvancePayment.TandC_Chceck.click();
			farmerAdvancePayment.AcceptButton.click();
			String avalibleStock = farmerAdvancePayment.AvalibleStock.getText();
			String stock = avalibleStock.replaceAll("[^\\d.]", "");
			if (stock.contains("0.0")) {
				extentreport.log(Status.PASS, "Avalible Stock:"+stock);
			}

			//String stock = avalibleStock.replaceAll(".+: ", "");
			System.out.println(stock);
			String totalProductAmount = farmerAdvancePayment.TotalProductAmount_SPS.getText();
			String amount = totalProductAmount.replaceAll("[^\\d.]", "");
			if (amount.contains("0.0")) {
				extentreport.log(Status.PASS, "Total Product Amount:"+amount);
			}

			//String amount = totalProductAmount.replaceAll(".+₹ ", "");
			System.out.println(amount);



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}

	}

}
