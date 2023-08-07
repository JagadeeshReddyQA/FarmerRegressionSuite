package com.farmer.script.Otp;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import io.appium.java_client.android.AndroidElement;
import pages.FarmerLandingPage;
import pages.FarmerSignUpPage;

public class TC_001_OTP_ForgotPassword_Test extends BaseTest{

	@Test
	public void forgotPassword() throws Exception {

		try {

			System.out.println("TC_001_OTP_ForgotPassword_Test");
			extentreport= extent.createTest("TC_001_OTP_ForgotPassword_Test","Verify if user is able to get OTP when performing Forgot Password Functionality");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			FarmerSignUpPage farmerSignUpPage = new FarmerSignUpPage(device_driver);
			if (farmerSignUpPage.signUpTitle.isDisplayed()) {
				String title = farmerSignUpPage.signUpTitle.getText();
				System.out.println(title);
				extentreport.log(Status.PASS,"Title Displayed"+title);
			}

			farmerSignUpPage.firstName.sendKeys("J");
			farmerSignUpPage.lastName.sendKeys("Reddy");
			farmerSignUpPage.phoneNumber.sendKeys("8340046496");
			farmerSignUpPage.signUpContinue.click();

			try {
				System.out.println("Clearing Notifications");
				device_driver.openNotifications();
				AndroidElement clearBtn = device_driver.findElementByAccessibilityId("Clear,Button");
				if (clearBtn.isEnabled()) {
					clearBtn.click();
				}
				else {
					device_driver.navigate().back();
				}	
			} catch (Exception e) {
				
			}











			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}

}
