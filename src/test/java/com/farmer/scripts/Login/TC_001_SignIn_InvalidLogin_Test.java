package com.farmer.scripts.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerLandingPage;

public class TC_001_SignIn_InvalidLogin_Test extends BaseTest{

	@Test
	public void sigin_InvalidCredentials() {

		try {
			System.out.println("TC_001_SignIn_InvalidLogin_Test");
			extentreport= extent.createTest("Sign_In_Invalid_Credentials","Verify If User Is Able To SignIn With Invalid Credentials");
			FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);
			try {

				if (farmerLandingPage.SignIn.isDisplayed()) {
					Thread.sleep(1000);
					farmerLandingPage.SignIn.click();
					//#InValid TestData
					//USERNAME1 = naveen(.@f-uat
					//PASSWORD1 = 697189


					String username1 = getValue("USERNAME1");		
					String password1 = getValue("PASSWORD1");
					farmerLandingPage.setUserName(username1);
					farmerLandingPage.setPassWord(password1);
					extentreport.log(Status.PASS,username1);
					extentreport.log(Status.PASS,password1);
					farmerLandingPage.clickSignInBtn();
					Thread.sleep(1000);
					errorMsg();

					//#InValid TestData
					//USERNAME2 = naveenf-uat
					//PASSWORD2 = 697189000
					farmerLandingPage.SignIn.click();;
					String username2 = getValue("USERNAME2");		
					String password2 = getValue("PASSWORD2");
					farmerLandingPage.clrUsrName();
					farmerLandingPage.clrPswd();
					farmerLandingPage.setUsrNme(username2);
					farmerLandingPage.setPswd(password2);
					extentreport.log(Status.PASS,username2);
					extentreport.log(Status.PASS,password2);
					farmerLandingPage.clickSignInBtn();
					Thread.sleep(1000);
					errorMsg();

					//#InValid TestData
					//USERNAME3 = naveenf!/>-uat
					//PASSWORD3 = 697189123
					farmerLandingPage.SignIn.click();;
					String username3 = getValue("USERNAME3");		
					String password3 = getValue("PASSWORD3");
					farmerLandingPage.clrUsrName();
					farmerLandingPage.clrPswd();
					farmerLandingPage.setUsrNme(username3);
					farmerLandingPage.setPswd(password3);
					extentreport.log(Status.PASS,username3);
					extentreport.log(Status.PASS,password3);
					farmerLandingPage.clickSignInBtn();
					Thread.sleep(1000);
					errorMsg();
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Sign In Btn Not Displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			extentreport.log(Status.FAIL, "TC_001_SignIn_InvalidLogin_Test");
			Assert.fail("Test Case Failed", e);		
		}
	}

	public void errorMsg() {
		FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);

		try {
			if (farmerLandingPage.SnackBar.isDisplayed()) {
				String msg = farmerLandingPage.SnackBar.getText();
				System.out.println(msg);
				extentreport.log(Status.PASS,msg);

			}
		} catch (Exception e) {
			System.out.println("Msg Not Displayed");
		}

	}



}
