package com.farmer.script.LandInAcres_HarvestDetails;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_002_LIA_WithLandInfo_Test extends BaseTest{


	@Test
	public void withLandInfo() throws Exception {


		try {

			System.out.println("TC_002_LIA_WithLandInfo_Test");
			extentreport= extent.createTest("TC_002_LIA_WithLandInfo_Test","Farmer has agriculture and land info and total land in acres as 1 acre, Verify that he can inward only 25 Quintals of Paddy");
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERLIA2");
			String password = getValue("PASSLIA2");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}
			farmerHomepage.GoToHomePage.click();
			farmerHomepage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.WareHouseRequestBtn.click();
			farmerWareHouseRequestPage.accept_TandC();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectPaddy.click();
			farmerWareHouseRequestPage.selectTodayDate();
			farmerWareHouseRequestPage.Quantity.clear();
			String qty = getValue("QTYLIA2");
			farmerWareHouseRequestPage.Quantity.sendKeys(qty);
			AppiumGeneric.scrollIntoView("Proceed");
			farmerWareHouseRequestPage.addRemarks();
			farmerWareHouseRequestPage.clickProceed();
			Thread.sleep(2000);
			try {
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String dispMsg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println(dispMsg);
					extentreport.log(Status.PASS,"Msg Displayed"+dispMsg);
					navigateBack();
					navigateBack();
				}

			} catch (Exception e1) {
				extentreport.log(Status.INFO,"Expected to see Error message but, No Message Displayed");
				extentreport.info("Turn ON LandInAcers Configuration in DB!!!!");
				device_NavigateBack();
				navigateBack();
				navigateBack();
			}
			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}
	}

}
