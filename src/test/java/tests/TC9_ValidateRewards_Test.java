package tests;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMyRewardsPage;

public class TC9_ValidateRewards_Test  extends BaseTest{
	@Test
	public void validateMyRewards() throws InterruptedException {
		System.out.println("TC9_ValidateRewards_Test");

		try {
			extentreport=extent.createTest("My Rewards","Verifying If My Rewards Are Displayed Correctly");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMyRewardsPage farmerMyRewardsPage = new FarmerMyRewardsPage(device_driver);
			Thread.sleep(3000);
			farmerHomePage.QuickActionMyRewards.click();
			try {
				assertEquals(farmerMyRewardsPage.RewardsStatementsBtn.isDisplayed(), true);
				String rewardsBtnText = farmerMyRewardsPage.RewardsStatementsBtn.getText();
				extentreport.log(Status.PASS,rewardsBtnText+" Button Enabled");
				navigateBack();
				System.out.println("Rewards");
				System.out.println("Rewards");
				
			} catch (Exception e) {

				navigateBack();
			}
			extentreport.log(Status.PASS,"TC9_ValidateRewards_Test Executed Successfully");
			System.out.println("TC9_ValidateRewards_Test Executed Successfully");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}
	}
}
