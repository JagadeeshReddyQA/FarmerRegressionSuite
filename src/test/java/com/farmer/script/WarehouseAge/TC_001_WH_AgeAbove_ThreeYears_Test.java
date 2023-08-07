package com.farmer.script.WarehouseAge;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_001_WH_AgeAbove_ThreeYears_Test extends BaseTest{


	@Test
	public void warehouseAgeOlderThanThreeYears() throws Exception {

		try {

			System.out.println("TC_001_WH_AgeAbove_ThreeYears_Test");
			extentreport= extent.createTest("TC_001_WH_AgeAbove_ThreeYears_Test","Verify Assigned warehouse for the farmer is older than 3 years and user is not able to create Request");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERNAME11");
			String password = getValue("PASSWORD11");
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
			Thread.sleep(3000);
			String text = farmerWareHouseRequestPage.SorryMsg.getText();
			System.out.println(text);
			extentreport.log(Status.PASS,text);
			farmerWareHouseRequestPage.Sorry_Cancel.click();
			Thread.sleep(1000);
			navigateBack();
			navigateBack();
			farmerHomepage.logout();
			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}

}




