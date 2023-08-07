package com.farmer.scripts.Rewards;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerMyRewardsPage;

public class TC_001_RWD_Verify_Screen_If_No_Records_Are_Avaliable_Test extends BaseTest{

	@Test

	private void rewards_NoRecord() {

		try {
			System.out.println("TC_001_RWD_Verify_Screen_If_No_Records_Are_Avaliable_Test");
			extentreport= extent.createTest("Rewards_NoRecord","Verify Rewards Screen If No Records Are Avaliable");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMyRewardsPage farmerMyRewardsPage = new FarmerMyRewardsPage(device_driver);
			farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickRewards();
			//Scenario: When there are No Rewards Screen 
			//Verify Rewards Screen If No Records Are Avaliable
			try {
				if (farmerMyRewardsPage.Coming_Soon_Msg!=null && farmerMyRewardsPage.Coming_Soon_Msg.isDisplayed()) {
					String text = farmerMyRewardsPage.Coming_Soon_Msg.getText();
					extentreport.log(Status.PASS,"Msg Displayed: "+text);
					System.out.println(text);
				}

			} catch (Exception e) {
				if (farmerMyRewardsPage.Coming_Soon_Msg.isDisplayed()==false) {
					extentreport.log(Status.INFO, "Message Not Displayed");
				}
			}

			navigateBack();

		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
	
}
