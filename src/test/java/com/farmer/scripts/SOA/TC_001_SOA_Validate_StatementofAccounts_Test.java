package com.farmer.scripts.SOA;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStatementOfAccountPage;

public class TC_001_SOA_Validate_StatementofAccounts_Test extends BaseTest{
	String noDataMsg;
	String dateRange;
	String cropDetails;
	String totalStock;
	String totalAmount;


	@Test
	
	private void validate_SOA() throws Exception {
		try {

			System.out.println("TC_001_SOA_Validate_StatementofAccounts_Test");

			extentreport= extent.createTest("S_O_A_Validate","Validate Statements Of Accounts");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.clickStatemtofAccount();
			FarmerStatementOfAccountPage farmerStatementOfAccountPage = new FarmerStatementOfAccountPage(device_driver);

			try {
				if (farmerStatementOfAccountPage.No_Data_Found.isDisplayed()) {
					noDataMsg = farmerStatementOfAccountPage.No_Data_Found.getText();
					System.out.println(noDataMsg);
					extentreport.log(Status.INFO, "Message Displayed: "+noDataMsg);
					navigateBack();
					navigateBack();
				}

			} catch (Exception e) {
				try {
					if (farmerStatementOfAccountPage.Quantity.isDisplayed() || farmerStatementOfAccountPage.Financials.isDisplayed()) {
						System.out.println("Data Present");
						dateRange = farmerStatementOfAccountPage.DateRange.getText();
						System.out.println(dateRange);
						extentreport.log(Status.PASS, dateRange);
						cropDetails = farmerStatementOfAccountPage.CropDetails.getText();
						System.out.println(cropDetails);
						extentreport.log(Status.PASS, cropDetails);
						totalStock = farmerStatementOfAccountPage.TotalStock.getText();
						extentreport.log(Status.PASS, totalStock);

						//farmerStatementOfAccountPage.clickFinancials();
						//totalAmount = farmerStatementOfAccountPage.TotalAmount.getText();
						//System.out.println(totalAmount);
						//extentreport.log(Status.PASS, totalAmount);
						navigateBack();
						if (farmerStatementOfAccountPage.Submit_Btn.isDisplayed()) {
							farmerStatementOfAccountPage.clickSubmitBtn();
							navigateBack();
							navigateBack();
						}
					}
				} catch (Exception e2) {
					extentreport.log(Status.INFO, "Quantity Button Is Not Enabled");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}
