package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataproviders.ConfigFileReader;
import generic.BaseTest;
import pages.FarmerLandingPage;

public class TC1_ValidateLoginTest extends BaseTest {
	@Test

	public void landingPage() throws InterruptedException, IOException {
		System.out.println("TC1_ValidateLoginTest");
		try {
			extentreport= extent.createTest("Landing Page","Farmer App Is Installed On New Device & Trying To Login");
			System.out.println("Navigating to SignIn Page");
			FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);
			farmerLandingPage.RightArrow.click();
			farmerLandingPage.RightArrow.click();
			farmerLandingPage.GetStartedButton.click();
			farmerLandingPage.clickEnglish();
			farmerLandingPage.Savebutton.click();

			farmerLandingPage.SignIn.click();
			farmerLandingPage.Enter_Username_Mobilenumber.sendKeys(ConfigFileReader.userName());
			farmerLandingPage.Enter_Password.sendKeys(ConfigFileReader.userPassword());
			farmerLandingPage.SignInButton.click();
			extentreport.log(Status.PASS, "FARMER LOGGED IN SUCCESSFULLY");
			//extentreport.addScreenCaptureFromPath("");


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}

	}

}
