package com.farmer.scripts.Login;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;

public class TC_1_ChangeLanguagetoHindi_Login_Test extends BaseTest{

	@Test
	public void changeLanguagetoHindi() throws Exception {

		try {

			System.out.println("TC_1_ChangeLanguagetoHindi_Login_Test");
			extentreport= extent.createTest("ChangeLanguagetoHindi_Login_Test","Verify user is able to login into app when language changed to Hindi");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);

			farmerLandingpage.navigateToChangeLanguagePage();

			//HINDI
			//farmerLandingpage.changeLanguage();
			farmerLandingpage.clickHindi();
			Thread.sleep(1000);
			farmerLandingpage.clickSaveBtn();
			farmerLandingpage.accSignIn.click();

			farmerLandingpage.accUsrName.sendKeys(getValue("USERNAME"));
			farmerLandingpage.accPassword.sendKeys(getValue("PASSWORD"));
			farmerLandingpage.accSignInContinue.click();
			Thread.sleep(5000);
			waitForVisibility(farmerLandingpage.accLocation);
			String hLocation = farmerLandingpage.accLocation.getText();
			System.out.println(hLocation);
			extentreport.log(Status.PASS,hLocation);
			farmerLandingpage.accProfile.click();
			Thread.sleep(4000);
			String hprofileTitle = farmerLandingpage.accTitle.getText();
			System.out.println(hprofileTitle);
			extentreport.log(Status.PASS,hprofileTitle);
			navigateBack();
			farmerLandingpage.accOffers.click();
			String hoffersTitle = farmerLandingpage.accTitle.getText();
			System.out.println(hoffersTitle);
			extentreport.log(Status.PASS,hoffersTitle);
			navigateBack();
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.HamburgerMenu.click();
			farmerHomePage.hindiLogout();

			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}


}
