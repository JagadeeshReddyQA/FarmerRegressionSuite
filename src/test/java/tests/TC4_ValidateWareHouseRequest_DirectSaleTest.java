package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import dataproviders.ConfigFileReader;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerWareHouseRequestPage;

public class TC4_ValidateWareHouseRequest_DirectSaleTest extends BaseTest {

	@Test
	public void wareHouse_DirectSale() throws Exception {

		System.out.println("TC4_ValidateWareHouseRequest_DirectSaleTest");
		try {
			extentreport=extent.createTest("WareHouseRequest Page","Validating New Direct Sale Request");
			WebDriverWait wait = new WebDriverWait(device_driver, 20);
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
			wait.until(ExpectedConditions.visibilityOf(farmerWareHouseRequestPage.PlusBtn)).click();
			//farmerWareHouseRequestPage.AddButton.click();
			farmerWareHouseRequestPage.TandC_Chceck.click();
			farmerWareHouseRequestPage.AcceptButton.click();
			farmerWareHouseRequestPage.SellNowBtn.click();
			farmerWareHouseRequestPage.ProductDropwown.click();
			farmerWareHouseRequestPage.SelectMaize.click();
			farmerWareHouseRequestPage.Quantity.clear();
			farmerWareHouseRequestPage.Quantity.sendKeys("10");
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
			//String points = farmerWareHouseRequestPage.Points.getText();
			//extentreport.log(Status.PASS,points);
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
