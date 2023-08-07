package com.farmer.scripts.Offers;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerOffersPage;

public class TC_001_Offers_Verify_No_Offers_Test extends BaseTest{
	@Test

	private void offers_No_Offers() {

		try {
			System.out.println("TC_001_Offers_Verify_No_Offers_Test");
			extentreport= extent.createTest("Offers_NoOffers","Verify Offers Screen If No Offers Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			//farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickOffers();
			FarmerOffersPage farmerOffersPage = new FarmerOffersPage(device_driver);

			//Scenario: When there are No Rewards Screen 
			//Verify Rewards Screen If No Records Are Avaliable
			try {
				if (farmerOffersPage.No_Offers_Yet!=null && farmerOffersPage.No_Offers_Yet.isDisplayed()) {
					String text = farmerOffersPage.No_Offers_Yet.getText();
					extentreport.log(Status.PASS,"Msg Displayed: "+text);
					System.out.println(text);
				}

			} catch (Exception e) {

				extentreport.log(Status.INFO, "Message Not Displayed");
			}

			navigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}