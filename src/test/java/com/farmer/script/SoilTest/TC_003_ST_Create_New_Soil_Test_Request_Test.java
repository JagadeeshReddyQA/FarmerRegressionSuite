package com.farmer.script.SoilTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSoilTestPage;

public class TC_003_ST_Create_New_Soil_Test_Request_Test extends BaseTest{
	@Test

	private void newSoilTest_Creation() throws InterruptedException {

		try {

			System.out.println("TC_002_ST_Create_New_Soil_Test_Request_Test");
			extentreport= extent.createTest("ST_Create_New_Soil_Test_Request_Test","Verify if the user is able to see No Request Yet! Message");
			//FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			//farmerLandingpage.navigateToLoginPage();

			//String username = getValue("USERST");
			//String password = getValue("PASSST");
			//farmerLandingpage.loginToApp(username, password);
			//Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}
			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();
			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			try {
				//Soil Test Request Button
				farmerSoilTestPage.SoilTestRequest.click();
				System.out.println("User Making Soil Test Request for the first time");
				farmerSoilTestPage.FieldNameDropdown.click();
				device_driver.findElement(By.id("com.GrainbankFarmer.app:id/textViewField")).click();

			} catch (Exception e) {
				//Plus Bitton
				farmerSoilTestPage.Add.click();
				farmerSoilTestPage.WareHouseDropdown.click();
				farmerSoilTestPage.Select_Warehouse.click();
				farmerSoilTestPage.FieldNameDropdown.click();
				device_driver.findElementByAccessibilityId("0_textViewField").click();
				
				//device_driver.findElementByAccessibilityId("1_textViewField").click();



				
				
				
				
				
			}
			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

}
