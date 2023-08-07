package com.farmer.scripts.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerLandingPage;


public class TC_002_SignIn_ValidLogin_Test extends BaseTest{

	@Test
	public void signIn_validCredentials() throws Exception {
		try {
			System.out.println("TC_002_SignIn_ValidLogin_Test");
			extentreport= extent.createTest("Sign_In_Valid_Credentials","Verify If User Is Able To SignIn With Valid Credentials");
			FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);

			try {

				if (farmerLandingPage.RightArrow.isDisplayed()) {
					System.out.println("User Should Click On Right Arrow");
					farmerLandingPage.RightArrow.click();
					farmerLandingPage.RightArrow.click();
					farmerLandingPage.GetStartedButton.click();
					farmerLandingPage.clickEnglish();
					farmerLandingPage.Savebutton.click();

					try {
						if (farmerLandingPage.SignIn.isDisplayed()) {
							farmerLandingPage.SignIn.click();
							Thread.sleep(1000);
							validCredentials();
							try {
								FarmerHomePage farmerHomepage=new FarmerHomePage(device_driver);
								if (farmerHomepage.FarmerName.isDisplayed()) {
									extentreport.log(Status.PASS, "User Loged In Successfully");
									System.out.println(farmerHomepage.FarmerName.getText());
									extentreport.log(Status.PASS, "Displayed Name: "+farmerHomepage.FarmerName.getText());
									
									try {
										if (farmerHomepage.iUnderstandBtn.isDisplayed()) {
											String msg = farmerHomepage.moistureMessage.getText();
											System.out.println(msg);
											farmerHomepage.iUnderstandBtn.click();
											extentreport.log(Status.PASS, "Msg Displayed: "+msg);
										}
									} catch (Exception e) {
										extentreport.log(Status.INFO, "No Indicative Message Displayed ");
									}
									
//									if (farmerHomepage.iUnderstandBtn.isDisplayed()) {
//										String msg = farmerHomepage.moistureMessage.getText();
//										System.out.println(msg);
//										extentreport.log(Status.PASS, "Msg Displayed: "+msg);
//										farmerHomepage.iUnderstandBtn.click();
//									}else {
//										extentreport.log(Status.INFO, "No Indicative Message Displayed ");
//									}
								}


							} catch (Exception e) {
								extentreport.log(Status.FAIL, "User Failed To Login");
								Assert.fail("Test Case Failed", e);	

							}

						}
					} catch (Exception e) {
						System.out.println("Sign In Button Not Displayed");

					}
				}

			} catch (Exception e) {
				if (farmerLandingPage.SignIn.isDisplayed()) {
					Thread.sleep(1000);
					validCredentials();
					try {
						FarmerHomePage farmerHomepage=new FarmerHomePage(device_driver);
						if (farmerHomepage.FarmerName.isDisplayed()) {
							//String farmerName = farmerHomepage.FarmerName.getText();
							extentreport.log(Status.PASS, "User Loged In Successfully");
							System.out.println(farmerHomepage.FarmerName.getText());
							extentreport.log(Status.PASS, "Displayed Name: "+farmerHomepage.FarmerName.getText());
							try {
								if (farmerHomepage.iUnderstandBtn.isDisplayed()) {
									String msg = farmerHomepage.moistureMessage.getText();
									System.out.println(msg);
									extentreport.log(Status.PASS, "Msg Displayed: "+msg);
									farmerHomepage.iUnderstandBtn.click();
								}
							} catch (Exception e2) {
								extentreport.log(Status.INFO, "No Indicative Message Displayed ");
							}
							
						}

					} catch (Exception e1) {
						extentreport.log(Status.FAIL, "User Failed To Login");
						Assert.fail("Test Case Failed", e1);	
					}
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public void validCredentials() {
		FarmerLandingPage farmerLandingPage = new FarmerLandingPage(device_driver);
		try {
			farmerLandingPage.clrUsrName();
			//farmerLandingPage.clrPswd();
			String username = getValue("USERNAME");		
			String password = getValue("PASSWORD");
			farmerLandingPage.setUserName(username);
			farmerLandingPage.setPassWord(password);
			extentreport.log(Status.PASS,"USERNAME: "+username);
			extentreport.log(Status.PASS,"PASSWORD: "+password);
			farmerLandingPage.clickSignInBtn();
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("Login Failed");
			extentreport.log(Status.FAIL, "Failed To Login");
			Assert.fail("Test Case Failed", e);	
		}

	}

}
