package com.farmer.scripts.MarketPlace;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerMarketPlacePage;

public class TC01_ValidateMarketplaceTitle extends BaseTest{

	@Test

	public void testmarketPlaceTitle() throws Exception {

		System.out.println("TC01_ValidateMarketplaceTitle");
		extentreport= extent.createTest("MarketPlace Title","Verify Market Place Title");
		try {
			
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			//String username = getValue("USERLIA1");
			//String password = getValue("PASSLIA1");
			farmerLandingpage.loginToApp("automationmkt-uat", "1234567");
			Thread.sleep(3000);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);

			if (farmerHomePage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomePage.FarmerName.getText());
			}

			
			String mpModuleTxt = farmerHomePage.marketPlace.getText();
			farmerHomePage.clickMarketPlace();
			FarmerMarketPlacePage farmerMarketPlacePage = new FarmerMarketPlacePage(device_driver);
			String dmpTitle = farmerMarketPlacePage.mpTitle.getText();

			assertEquals(mpModuleTxt, dmpTitle);

			farmerMarketPlacePage.mpBackBtn.click();
			
			extentreport.log(Status.INFO, "Title Displayed: "+dmpTitle);
			extentreport.log(Status.PASS, "Test Case Executed Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

}
