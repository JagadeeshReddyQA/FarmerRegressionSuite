package com.farmer.script.WarehouseAge;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerWareHouseRequestPage;

public class TC_005_WH_AgeOnetoTwoYear_Test extends BaseTest{


	@Test
	public void warehouseAgeOnetoTwoYears() throws Exception {

		try {

			System.out.println("TC_005_WH_AgeOnetoTwoYear");
			extentreport= extent.createTest("TC_005_WH_AgeOnetoTwoYear_Test","Verify If the warehouse age falls between 1 to 2 year, with 30% allowance for the direct sale. If this 30% is utilised then User cannot make Request");

			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();

			String username = getValue("USERNAME66");
			String password = getValue("PASSWORD66");
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
			//extentreport.log(Status.FAIL,e);
			throw (e);

		}

	}

}
