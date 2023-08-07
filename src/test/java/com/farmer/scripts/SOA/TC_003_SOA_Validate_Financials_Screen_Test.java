package com.farmer.scripts.SOA;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStatementOfAccountPage;

public class TC_003_SOA_Validate_Financials_Screen_Test extends BaseTest{
	String noDataMsg;
	String msg;

	@Test

	public void soa_ValidateFinancials() throws InterruptedException {

		System.out.println("TC_003_SOA_Validate_Financials_Screen_Test");
		try {
			extentreport= extent.createTest("S_O_A_Financials_Screen","Validate Financials Screen");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.clickStatemtofAccount();
			FarmerStatementOfAccountPage farmerStatementOfAccountPage = new FarmerStatementOfAccountPage(device_driver);
			farmerStatementOfAccountPage.clickFinancials();
			Thread.sleep(1000);
			try {
				if (farmerStatementOfAccountPage.No_Data_Found.isDisplayed()) {
					noDataMsg = farmerStatementOfAccountPage.No_Data_Found.getText();
					System.out.println(noDataMsg);
					extentreport.log(Status.INFO,"Message Displayed: "+ noDataMsg);
					navigateBack();
					navigateBack();
				}	
			} catch (Exception e) {
				validateDate();
				downloadStatement();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}

	public void validateDate() {
		FarmerStatementOfAccountPage farmerStatementOfAccountPage = new FarmerStatementOfAccountPage(device_driver);
		try {
			navigateBack();
			if (farmerStatementOfAccountPage.Product_Dropdown.isDisplayed()) {
				farmerStatementOfAccountPage.clickDropdown();
				farmerStatementOfAccountPage.selectProduct();
				farmerStatementOfAccountPage.clickSubmit();
				farmerStatementOfAccountPage.clickFinancials();
			}
		} catch (Exception e) {
			System.out.println("Product Dropdown Is Not Displayed On The Page");
		}
	}

	public void downloadStatement() {
		FarmerStatementOfAccountPage farmerStatementOfAccountPage = new FarmerStatementOfAccountPage(device_driver);
		try {
			farmerStatementOfAccountPage.Download.click();
			if (farmerStatementOfAccountPage.snackBar.isDisplayed()) {
				msg = farmerStatementOfAccountPage.snackBar.getText();
				System.out.println(msg);
				extentreport.log(Status.PASS,"Message Displayed: "+msg);
				navigateBack();
				navigateBack();
			}

		} catch (Exception e) {
			System.out.println("No Record");
			extentreport.log(Status.FAIL, "No Record");
			navigateBack();
			navigateBack();
		}
	}
}
