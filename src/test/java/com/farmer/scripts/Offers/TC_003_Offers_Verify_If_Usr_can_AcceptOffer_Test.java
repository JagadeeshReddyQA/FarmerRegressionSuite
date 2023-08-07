package com.farmer.scripts.Offers;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerOffersPage;

public class TC_003_Offers_Verify_If_Usr_can_AcceptOffer_Test extends BaseTest{


	@Test

	public void offers_AcceptOffer() {

		try {
			System.out.println("TC_003_Offers_Verify_If_Usr_can_AcceptOffer_Test");
			extentreport= extent.createTest("Offers_AcceptOffers","Verify if user is able to Accept the Offer");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.waitTillNameisDisplayed();
			farmerHomePage.clickOffers();
			FarmerOffersPage farmerOffersPage = new FarmerOffersPage(device_driver);

			//Scenario: When there are No Rewards Screen 
			//Verify Rewards Screen If No Records Are Avaliable
			try {
				if (farmerOffersPage.Accept_Offer!=null && farmerOffersPage.Accept_Offer.isDisplayed()) {
					farmerOffersPage.clickAcceptOffer();
					Thread.sleep(2000);
					try {
						//Condition:: If Avaliable Stock is Displayed
						if (farmerOffersPage.Available_stock.isDisplayed()) {
							farmerOffersPage.qty_OneFourth.click();
							Thread.sleep(1000);
							String qty = farmerOffersPage.Entered_QTY.getText();
							System.out.println("Entered Qty: "+qty);
							extentreport.log(Status.PASS,"Entered Quantity: "+qty);
							farmerOffersPage.Normal_Payment.click();
							AppiumGeneric.scrollIntoView("Proceed");
							Thread.sleep(500);
							farmerOffersPage.clickProceed();
							try {
								if (farmerOffersPage.SnackBar.isDisplayed()) {
									String msg = farmerOffersPage.SnackBar.getText();
									System.out.println(msg);
									extentreport.log(Status.INFO,msg);
									navigateBack();
									Thread.sleep(1000);
									navigateBack();
								}
							}
							catch(Exception e) {
								farmerOffersPage.Accept.click();

								try {
									if (farmerOffersPage.SnackBar.isDisplayed()) {
										String msg = farmerOffersPage.SnackBar.getText();	
										System.out.println(msg);
										extentreport.log(Status.PASS,msg);
										navigateBack();
										navigateBack();
									}

								} catch (Exception e1) {

									if (farmerOffersPage.Request_Success.isDisplayed()) {
										String text = farmerOffersPage.Request_Success.getText();
										System.out.println(text);
										extentreport.log(Status.PASS,text);
										farmerOffersPage.clickBackToHomepage();

									}
								}
							}

						}

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Available Stock Is Not Displayed");
						device_NavigateBack();
					}


				}

			} catch (Exception e) {

				extentreport.log(Status.INFO, "No Records to Accept Offer");
				navigateBack();
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}

	}

}
