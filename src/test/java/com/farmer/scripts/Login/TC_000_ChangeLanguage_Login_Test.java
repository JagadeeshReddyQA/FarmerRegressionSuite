package com.farmer.scripts.Login;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;

public class TC_000_ChangeLanguage_Login_Test extends BaseTest{

	@Test
	public void changeLanguage() throws Exception {

		try {

			System.out.println("TC_000_ChangeLanguage_Login_Test");
			extentreport= extent.createTest("TC_000_ChangeLanguage_Login_Test","Verify user is able to login into app with different languages");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);

			farmerLandingpage.RightArrow.click();
			farmerLandingpage.RightArrow.click();
			farmerLandingpage.GetStartedButton.click();
			//HINDI
			//farmerLandingpage.changeLanguage();
			farmerLandingpage.clickHindi();
			Thread.sleep(1000);
			farmerLandingpage.clickSaveBtn();
			farmerLandingpage.accSignIn.click();
			
			farmerLandingpage.accUsrName.sendKeys(getValue("USERNAME"));
			farmerLandingpage.accPassword.sendKeys(getValue("PASSWORD"));
			farmerLandingpage.accSignInContinue.click();
			Thread.sleep(3000);
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
			//MARATI
			Thread.sleep(2000);
			farmerLandingpage.accChangeLang.click();
			farmerLandingpage.clickMarati();
			farmerLandingpage.accSaveChanges.click();
			farmerLandingpage.accSignIn.click();
			farmerLandingpage.accUsrName.sendKeys(getValue("USERNAME"));
			farmerLandingpage.accPassword.sendKeys(getValue("PASSWORD"));
			farmerLandingpage.accSignInContinue.click();
			Thread.sleep(3000);
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
			
			farmerHomePage.HamburgerMenu.click();
			farmerHomePage.maratiLogout();
			
			//KANADA
			Thread.sleep(2000);
			farmerLandingpage.accChangeLang.click();
			farmerLandingpage.clickKanada();
			farmerLandingpage.accSaveChanges.click();
			farmerLandingpage.accSignIn.click();
			farmerLandingpage.accUsrName.sendKeys(getValue("USERNAME"));
			farmerLandingpage.accPassword.sendKeys(getValue("PASSWORD"));
			farmerLandingpage.accSignInContinue.click();
			Thread.sleep(3000);
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
			
			farmerHomePage.HamburgerMenu.click();
			farmerHomePage.kannadaLogout();
			






			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}

}
