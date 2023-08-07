package com.farmer.script.WarehouseAge;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_003_WH_Age_TwoToThree_Years_Test extends BaseTest{

	@Test
	public void warehouseAgetTwotoThreeYears() throws Exception {

		try {

			System.out.println("TC_003_WH_Age_TwoToThree_Years_Test");
			extentreport= extent.createTest("TC_003_WH_Age_TwoToThree_Years_Test","Verify Assigned warehouse for the farmer between 2 to 3 year, and 10% allowance is assigned for the direct sale & this 10% is Partially utilised then user cannot make request");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERNAME44");
			String password = getValue("PASSWORD44");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);

			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}

			farmerHomepage.clickWareHouseRequest();
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			farmerWareHouseRequestPage.PlusBtn.click();
			farmerWareHouseRequestPage.accept_TandC();
			farmerWareHouseRequestPage.selectSellNow();
			Thread.sleep(2000);
			farmerWareHouseRequestPage.clickProductDpwn();
			farmerWareHouseRequestPage.SelectPaddy.click();
			farmerWareHouseRequestPage.selectTodayDate();
			try {

				// If Error Msg :: No Harvest Information Is Avaliable.Please Contact Your VC.
				if (farmerWareHouseRequestPage.ErrorMsg.isDisplayed()) {
					String msg = farmerWareHouseRequestPage.ErrorMsg.getText();
					System.out.println("Message Displayed:"+msg);

					if(msg.contains("Please contact your VC")) {
						extentreport.log(Status.INFO,"Message Displayed: "+msg);
						extentreport.info("TurnOff LandInAcers Configuration in DB!!!!");
						navigateBack();
						navigateBack();
						farmerHomepage.logout();
					}
				}	

			} catch (Exception e) {
				farmerWareHouseRequestPage.Quantity.clear();
				String qty = getValue("QTY44");
				farmerWareHouseRequestPage.Quantity.sendKeys(qty);
				AppiumGeneric.scrollIntoView("Proceed");
				farmerWareHouseRequestPage.addRemarks();
				farmerWareHouseRequestPage.clickProceed();
				farmerWareHouseRequestPage.ConfirmYES.click();
				Thread.sleep(2000);
				try {
					if (farmerWareHouseRequestPage.PopupMsg.isDisplayed()) {
						String dispMsg = farmerWareHouseRequestPage.PopupMsg.getText();
						System.out.println(dispMsg);
						extentreport.log(Status.PASS,"Msg Displayed"+dispMsg);
						farmerWareHouseRequestPage.PopUpOk.click();
					}

				} catch (Exception e1) {
					System.out.println("No Pop Up Message Displayed");
					extentreport.info("No Pop Up Message Displayed");
					navigateBack();
					navigateBack();
				}
				Thread.sleep(1000);
				navigateBack();
				navigateBack();
				farmerHomepage.logout();
			}


			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);

		}

	}

}
