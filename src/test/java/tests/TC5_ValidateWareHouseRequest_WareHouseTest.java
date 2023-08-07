package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import dataproviders.ConfigFileReader;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC5_ValidateWareHouseRequest_WareHouseTest extends BaseTest{
	@Test
	public void wareHouse_WareHouseRequest() throws Exception {

		System.out.println("TC5_ValidateWareHouseRequest_WareHouseTest");
		try {
			extentreport=extent.createTest("WareHouseRequest Page","Validating Warehouse Request");
			Thread.sleep(1000); 
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			String qaWareHouse=farmerHomePage.QuickActionWarehouseRequest.getText();
			farmerHomePage.QuickActionWarehouseRequest.click();
			String wareHouseRequest = farmerWareHouseRequestPage.WarehouseRequestPageTitle.getText();
			if(qaWareHouse.equalsIgnoreCase(wareHouseRequest))
			{
				extentreport.log(Status.PASS, "Ware House Request Title Matched");	
			}
			else
				extentreport.log(Status.FAIL, "Ware House Request Title Not Matched");
			farmerWareHouseRequestPage.PlusBtn.click();
			farmerWareHouseRequestPage.TandC_Chceck.click();
			farmerWareHouseRequestPage.AcceptButton.click();
			farmerWareHouseRequestPage.SellLaterBtn.click();
			farmerWareHouseRequestPage.ProductDropwown.click();
			farmerWareHouseRequestPage.SelectMaize.click();
			farmerWareHouseRequestPage.Quantity.clear();
			farmerWareHouseRequestPage.Quantity.sendKeys("1.69");
			//String currentDate = currentDate();
			//farmerWareHouseRequestPage.DateFeild.sendKeys(currentDate);
			farmerWareHouseRequestPage.DateFeild.click();
			farmerWareHouseRequestPage.DateOK.click();
			farmerWareHouseRequestPage.Remarks.click();
			Thread.sleep(1000);
			device_driver.hideKeyboard();
			farmerWareHouseRequestPage.Remarks.sendKeys(ConfigFileReader.remarks());
			farmerWareHouseRequestPage.Proceed.click();
			farmerWareHouseRequestPage.ConfirmYES.click();
			Thread.sleep(1000);
			boolean displayedMsg = farmerWareHouseRequestPage.SuccessMsg.isDisplayed();
			Assert.assertTrue(true);
			Assert.assertEquals(displayedMsg,true);
			extentreport.log(Status.PASS, "Message Displayed: You have successfully created a warehouse request");
			farmerWareHouseRequestPage.ThingsToKnow.click();
			device_NavigateBack();
			Thread.sleep(1000);
			navigateBack();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}

	}

}
