package com.farmer.scripts.MyProfile;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMyProfilePage;

public class TC_002_Profile_Edit_Test extends BaseTest{

	@Test

	public void profile_Edit() throws Exception {
		try {
			System.out.println("TC_002_Profile_Edit_Test");
			extentreport= extent.createTest("Profile_Edit","Edit Profile Screen");
			WebDriverWait wait = new WebDriverWait(device_driver, 20);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickAccount();
			Thread.sleep(7000);
			FarmerMyProfilePage farmerMyProfilePage = new FarmerMyProfilePage(device_driver);


			try {
				if (farmerMyProfilePage.EditProfile!=null && farmerMyProfilePage.EditProfile.isDisplayed()) {
					farmerMyProfilePage.clickEditProfile();
					farmerMyProfilePage.clickDarkModeBtn();
					extentreport.log(Status.PASS,"Dark Mode Button: Enabled");
					wait.until(ExpectedConditions.visibilityOf(farmerMyProfilePage.DarkModeBtn)).click();
					Thread.sleep(4000);
					//farmerMyProfilePage.FName.clear();
					//farmerMyProfilePage.FName.sendKeys("QA Automation");
					String saveChanges="Save Changes";
					AppiumGeneric.scrollIntoView(saveChanges);
					farmerMyProfilePage.SaveChangesBtn.click();
					try {
						if (farmerMyProfilePage.SnackBar.isDisplayed()) {
							String msg = farmerMyProfilePage.SnackBar.getText();
							System.out.println(msg);
							extentreport.log(Status.PASS,"Msg Displayed: "+msg);

						}
						navigateBack();
						Thread.sleep(2000);
						navigateBack();
						Thread.sleep(3000);
					
					} catch (Exception e) {
						extentreport.log(Status.INFO,"Snack Bar Not Displayed");
						device_NavigateBack();
						Thread.sleep(1000);
						device_NavigateBack();
					}


				}

			} catch (Exception e) {
				if (farmerMyProfilePage.Name.isDisplayed()!=true) {
					extentreport.log(Status.INFO, "My Profile Page Is Not Displayed");
					device_NavigateBack();	
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}

}
