package com.farmer.scripts.Login;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;

public class TC_4_ChangeLanguagetoEnglish_Login_Test extends BaseTest{
	
	@Test
	public void changeLanguagetoEnglish() throws Exception {

		try {

			System.out.println("TC_4_ChangeLanguagetoEnglish_Login_Test");
			extentreport= extent.createTest("ChangeLanguagetoEnglish_Login_Test","Verify user is able to login into app when language changed to English");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);

			Thread.sleep(2000);
			farmerLandingpage.accChangeLang.click();
			farmerLandingpage.clickEnglish();
			farmerLandingpage.accSaveChanges.click();
			farmerLandingpage.accSignIn.click();
			farmerLandingpage.accUsrName.sendKeys(getValue("USERNAME"));
			farmerLandingpage.accPassword.sendKeys(getValue("PASSWORD"));
			farmerLandingpage.accSignInContinue.click();
			Thread.sleep(5000);
			waitForVisibility(farmerLandingpage.accLocation);
			String klocation = farmerLandingpage.accLocation.getText();
			System.out.println(klocation);
			extentreport.log(Status.PASS,klocation);
			farmerLandingpage.accProfile.click();
			Thread.sleep(4000);
			String kprofileTitle = farmerLandingpage.accTitle.getText();
			System.out.println(kprofileTitle);
			extentreport.log(Status.PASS,kprofileTitle);
			navigateBack();
			farmerLandingpage.accOffers.click();
			String koffersTitle = farmerLandingpage.accTitle.getText();
			System.out.println(koffersTitle);
			extentreport.log(Status.PASS,koffersTitle);
			navigateBack();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.HamburgerMenu.click();
			farmerHomePage.logout();
			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}

}
