package com.farmer.scripts.Login;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerLandingPage;

public class TC_001_LAN_Perform_Change_Language_Test extends BaseTest{
	@Test

	public void changeLanguage() throws InterruptedException, IOException {
		System.out.println("TC_001_LAN_Perform_Change_Language_Test");
		try {
			extentreport= extent.createTest("Change Language","Perform Change Language Operation");
			System.out.println("Change Language");
			FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);
		
				
				farmerLandingPage.RightArrow.click();
				farmerLandingPage.RightArrow.click();
				farmerLandingPage.GetStartedButton.click();
				Thread.sleep(1000);
				farmerLandingPage.clickHindi();
				Thread.sleep(1000);
				farmerLandingPage.clickSaveBtn();
				String saveBtnHindi = farmerLandingPage.cLHindiV.getText();
				Assert.assertEquals(saveBtnHindi, "भाषा बदलें");
				System.out.println(saveBtnHindi);
				extentreport.log(Status.PASS,saveBtnHindi);
				
				farmerLandingPage.cLHindiV.click();
				farmerLandingPage.clickMarati();
				farmerLandingPage.saveHindiV.click();
				String saveBtnMarati = farmerLandingPage.cLMaratiV.getText();
				Assert.assertEquals(saveBtnMarati, "भाषा बदला");
				System.out.println(saveBtnMarati);
				extentreport.log(Status.PASS, saveBtnMarati);

				farmerLandingPage.cLMaratiV.click();
				farmerLandingPage.clickKanada();
				farmerLandingPage.saveMaratiV.click();
				String saveBtnKanada = farmerLandingPage.cLKanadaV.getText();
				Assert.assertEquals(saveBtnKanada, "ಭಾಷೆ ಬದಲಿಸಿ");
				System.out.println(saveBtnKanada);
				extentreport.log(Status.PASS, saveBtnKanada);

				farmerLandingPage.cLKanadaV.click();
				farmerLandingPage.clickEnglish();
				farmerLandingPage.saveKanadaV.click();
				String saveBtnEnglish = farmerLandingPage.cLEnglishV.getText();
				Assert.assertEquals(saveBtnEnglish, "Change Language");
				System.out.println(saveBtnEnglish);
				extentreport.log(Status.PASS, saveBtnEnglish);



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	        throw(e);
		}
	}
}
