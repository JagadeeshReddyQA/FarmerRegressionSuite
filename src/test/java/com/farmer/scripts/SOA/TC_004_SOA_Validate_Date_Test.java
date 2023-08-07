package com.farmer.scripts.SOA;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStatementOfAccountPage;

public class TC_004_SOA_Validate_Date_Test extends BaseTest {

	@Test

	public void soa_ValidateDate() throws Exception {

		System.out.println("TC_004_SOA_Validate_Date_Test");

		try {
			extentreport= extent.createTest("S_O_A_ValidateDate","Validate Date Screen");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			AppiumGeneric.quickActionSwipe();
			farmerHomePage.clickStatemtofAccount();
			navigateBack();
			FarmerStatementOfAccountPage farmerStatementOfAccountPage = new FarmerStatementOfAccountPage(device_driver);

			farmerStatementOfAccountPage.Start_Date.click();
			farmerStatementOfAccountPage.selectNextMonth();

			try {
				validateMsg();
				navigateBack();

			} catch (Exception e) {

				System.out.println("No Message Displayed");
				navigateBack();
				navigateBack();
			}
			/*
			 * //86 400 000 ms = 1 Day : 24*60*60*1000 Date nDate = new Date(new
			 * Date().getTime() + 86400000); String nextDay = new
			 * SimpleDateFormat("d MMM yyyy").format(nDate); System.out.println(nextDay);
			 * farmerStatementOfAccountPage.Start_Date.sendKeys(nextDay);
			 * Thread.sleep(1000);
			 */

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);


		}


	}
	private void validateMsg() {
		FarmerStatementOfAccountPage farmerStatementOfAccountPage = new FarmerStatementOfAccountPage(device_driver);
		farmerStatementOfAccountPage.clickSubmitBtn();
		if(farmerStatementOfAccountPage.snackBar.isDisplayed())
		{
			String msg = farmerStatementOfAccountPage.snackBar.getText();
			System.out.println("Msg Displayed: "+msg);
			extentreport.log(Status.PASS, "Message Displayed: "+msg);
		}
	}
}