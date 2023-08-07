package tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHamburgerMenuPage;
import pages.FarmerHomePage;
import pages.FarmerMyProfilePage;

public class TC11_ValidateEditProfileTest  extends BaseTest{
	@Test
	public void validateEditProfile() throws InterruptedException {

		System.out.println("TC11_ValidateEditProfileTest");

		try {
			extentreport= extent.createTest("Edit Profile","User Is Editing His Profile");
			WebDriverWait wait = new WebDriverWait(device_driver, 20);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerHamburgerMenuPage farmerHamburgerMenu = new FarmerHamburgerMenuPage(device_driver);
			FarmerMyProfilePage farmerMyProfilePage = new FarmerMyProfilePage(device_driver);
			farmerHomePage.HamburgerMenu.click();
			farmerHamburgerMenu.MyProfile.click();

			if ((farmerMyProfilePage.Name.isDisplayed() && farmerMyProfilePage.ID.isDisplayed() && farmerMyProfilePage.UserType.isDisplayed())) {
				extentreport.log(Status.PASS, farmerMyProfilePage.Name.getText());
				extentreport.log(Status.PASS, farmerMyProfilePage.ID.getText());
				extentreport.log(Status.PASS, farmerMyProfilePage.UserType.getText());

			}else
				extentreport.log(Status.FAIL, "Farmer Profile Details Are Not Displayed On Screen");
			if ((farmerMyProfilePage.FirstName.isDisplayed() && farmerMyProfilePage.lastName.isDisplayed() 
					&& farmerMyProfilePage.MobileNumber.isDisplayed() && farmerMyProfilePage.LandInAcers.isDisplayed()
					&& farmerMyProfilePage.Address.isDisplayed())) {
				extentreport.log(Status.PASS, farmerMyProfilePage.FirstName.getText());
				extentreport.log(Status.PASS, farmerMyProfilePage.lastName.getText());
				extentreport.log(Status.PASS, farmerMyProfilePage.MobileNumber.getText());
				extentreport.log(Status.PASS, farmerMyProfilePage.LandInAcers.getText());
				extentreport.log(Status.PASS, farmerMyProfilePage.Address.getText());
			}	
			else
				extentreport.log(Status.FAIL, "Farmer FName,LName,MNbr,Land,Address Details Are Not Displayed On Screen");
			farmerMyProfilePage.EditProfile.click();
			if (farmerMyProfilePage.DarkModeBtn.isDisplayed()) {
				farmerMyProfilePage.DarkModeBtn.click();
				extentreport.log(Status.PASS,"Dark Mode Button: Enabled");
				wait.until(ExpectedConditions.visibilityOf(farmerMyProfilePage.DarkModeBtn)).click();
				//String acers = farmerMyProfilePage.Acers.getText();
				//farmerMyProfilePage.Acers.clear();
				//farmerMyProfilePage.EmptyLandField.sendKeys("150.00");
				//device_driver.hideKeyboard();
				farmerMyProfilePage.SaveChangesBtn.click();
				Thread.sleep(1000);
				device_NavigateBack();
				Thread.sleep(1000);
				device_NavigateBack();
				//farmerHomePage.HamburgerMenu.click();
				//farmerHamburgerMenu.MyProfile.click();
				//String displayedAcers = farmerMyProfilePage.LandInAcers.getText();
				//if (displayedAcers.equalsIgnoreCase(acers)) {
				//	extentreport.log(Status.PASS,"Land In Acers Field Updated Successfully");
				//	Thread.sleep(1000);
				//	device_NavigateBack();
				//}
				//else
				//	extentreport.log(Status.PASS,"Land In Acers Field Update UnSuccessfull");
			}
			else
				extentreport.log(Status.FAIL,"Dark Mode Button: Disabled");



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}



	}
}
