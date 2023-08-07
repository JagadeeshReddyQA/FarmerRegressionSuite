package com.farmer.scripts.MyProfile;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMyProfilePage;

public class TC_001_Profile_Verify_ProfileScreen_Test extends BaseTest{

	@Test

	public void profile_VerifyScreen() throws Exception {

		System.out.println("TC_001_Profile_Verify_ProfileScreen_Test");
		extentreport= extent.createTest("Profile_Screen","Verify Profile Screen");
		try {
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickHamburgerMenu();
			Thread.sleep(1000);
			farmerHomePage.clickMyHamProfile();;
			FarmerMyProfilePage farmerMyProfilePage = new FarmerMyProfilePage(device_driver);

			try {
				if (farmerMyProfilePage.ID!=null && farmerMyProfilePage.ID.isDisplayed()) {
					//String name = farmerMyProfilePage.Name.getText();
					String id = farmerMyProfilePage.ID.getText();
					String fName = farmerMyProfilePage.FirstName.getText();
					String lName = farmerMyProfilePage.lastName.getText();
					String mNbr = farmerMyProfilePage.MobileNumber.getText();
					String lia = farmerMyProfilePage.LandInAcers.getText();
					String address = farmerMyProfilePage.Address.getText();
					Thread.sleep(1000);
					//extentreport.log(Status.PASS,"Farmer Name: "+name);
					extentreport.log(Status.PASS,id);
					extentreport.log(Status.PASS,"FirstName: "+fName);
					extentreport.log(Status.PASS,"LastName: "+lName);
					extentreport.log(Status.PASS,"MobileNo: "+mNbr);
					extentreport.log(Status.PASS,"LandInAcers: "+lia);
					extentreport.log(Status.PASS,"Address: "+address);
					Thread.sleep(1000);
					//System.out.println(name);
					System.out.println(id);
					System.out.println(fName);
					System.out.println(lName);
					System.out.println(mNbr);
					System.out.println(lia);
					System.out.println(address);

				}

			} catch (Exception e) {
				if (farmerMyProfilePage.Name.isDisplayed()==false) {
					extentreport.log(Status.INFO, "My Profile Page Is Not Displayed");
					device_NavigateBack();	
				}
			}

			navigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}

	}

}
