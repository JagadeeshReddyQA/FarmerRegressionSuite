package com.farmer.scripts.Login;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;

public class TC_2_ChangeLanguagetoMarathi_Login_Test extends BaseTest{
	@Test
	public void changeLanguagetoMarathi() throws Exception {

		try {

			System.out.println("TC_2_ChangeLanguagetoMarathi_Login_Test");
			extentreport= extent.createTest("ChangeLanguagetoMarathi_Login_Test","Verify user is able to login into app when language changed to Marathi");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);

			Thread.sleep(2000);
			farmerLandingpage.accChangeLang.click();
			farmerLandingpage.clickMarati();
			farmerLandingpage.accSaveChanges.click();
			farmerLandingpage.accSignIn.click();
			farmerLandingpage.accUsrName.sendKeys(getValue("USERNAME"));
			farmerLandingpage.accPassword.sendKeys(getValue("PASSWORD"));
			farmerLandingpage.accSignInContinue.click();
			Thread.sleep(5000);
			waitForVisibility(farmerLandingpage.accLocation);
			String mlocation = farmerLandingpage.accLocation.getText();
			System.out.println(mlocation);
			extentreport.log(Status.PASS,mlocation);
			farmerLandingpage.accProfile.click();
			Thread.sleep(4000);
			String mprofileTitle = farmerLandingpage.accTitle.getText();
			System.out.println(mprofileTitle);
			extentreport.log(Status.PASS,mprofileTitle);
			navigateBack();
			farmerLandingpage.accOffers.click();
			String moffersTitle = farmerLandingpage.accTitle.getText();
			System.out.println(moffersTitle);
			extentreport.log(Status.PASS,moffersTitle);
			navigateBack();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.HamburgerMenu.click();
			farmerHomePage.maratiLogout();

			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}
}
