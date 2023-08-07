package com.farmer.script.SoilTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;
import pages.FarmerSoilTestPage;

public class TC_004_ST_ViewDetails_OpenTab_Test extends BaseTest{
	String atr_ID;
	String computeID;
	String district;
	String wareHouse;
	String fieldName;
	String ctg;
	String surveyNo;
	String lia;

	@Test
	public void viewDetails_OpenTab() throws Exception {

		try {

			System.out.println("TC_004_ST_ViewDetails_OpenTab_Test");
			extentreport= extent.createTest("ST_ViewDetails_OpenTab_Test","Verify if the user is able to view details of ATR");
			FarmerLandingPage farmerLandingpage = new FarmerLandingPage(device_driver);
			farmerLandingpage.navigateToLoginPage();
			String username = getValue("USERST");
			String password = getValue("PASSST");
			farmerLandingpage.loginToApp(username, password);
			Thread.sleep(3000);
			FarmerHomePage farmerHomepage = new FarmerHomePage(device_driver);

			if (farmerHomepage.FarmerName.isDisplayed()) {
				extentreport.info("User Loged In Successfully");
				System.out.println(farmerHomepage.FarmerName.getText());
			}
			AppiumGeneric.quickActionSwipe();
			farmerHomepage.clickSoilTest();
			FarmerSoilTestPage farmerSoilTestPage = new FarmerSoilTestPage(device_driver);
			try {
				//View Details
				farmerSoilTestPage.View_Details.click();
				if (farmerSoilTestPage.V_D_AtrID.isDisplayed()) {
					atr_ID = farmerSoilTestPage.V_D_AtrID.getText();
					computeID = farmerSoilTestPage.V_D_ComputeID.getText();
					district = farmerSoilTestPage.V_D_District.getText(); 
					wareHouse = farmerSoilTestPage.V_D_WareHouse.getText();
					fieldName = farmerSoilTestPage.V_D_FieldName.getText();
					ctg = farmerSoilTestPage.V_D_CropToBeGrown.getText();
					surveyNo = farmerSoilTestPage.V_D_SurveyNo.getText();
					lia = farmerSoilTestPage.V_D_LandInAcers.getText();

					extentreport.log(Status.PASS, "ID: "+ atr_ID);
					extentreport.log(Status.PASS, "COMPUTE ID: "+computeID);
					extentreport.log(Status.PASS, "DISTRICT: "+district);
					extentreport.log(Status.PASS, "WAREHOUSE: "+wareHouse);
					extentreport.log(Status.PASS, "FIELD NAME: "+fieldName);
					extentreport.log(Status.PASS, "CROP TO BE GROWN: "+ctg);
					extentreport.log(Status.PASS, "SURVEY NO: "+surveyNo);
					extentreport.log(Status.PASS, "LAND IN ACRES: "+lia);

					
					device_NavigateBack();
					Thread.sleep(1000);
					navigateBack();
					Thread.sleep(1000);
				}

			} catch (Exception e) {
				//TODO Write Logic if View Details is not found
				System.out.println("Not able to View Details");
				extentreport.log(Status.INFO,"Not able to View Details");
			}
			extentreport.log(Status.PASS,"Test Case executed Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			throw (e);
		}

	}

}
