package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerHomePage;

public class TC8_VerifyDashDoard_StockDetails_Test extends BaseTest{
	@Test
	public void verifyDashBoardStockDetails() throws InterruptedException {
		System.out.println("TC8_VerifyDashDoard_StockDetails_Test");
		try {

			extentreport=extent.createTest("Stock Details","Verifying If Stock Details Are Displayed Correctly");
			Thread.sleep(1000);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			assertEquals(farmerHomePage.MyStockValue.isDisplayed(), true);
			String myStockValue = farmerHomePage.MyStockValue.getText();
			extentreport.log(Status.PASS, "My Stock Value: "+myStockValue);

			assertEquals(farmerHomePage.BookedStock.isDisplayed(), true);
			String bookedStock = farmerHomePage.BookedStock.getText();
			extentreport.log(Status.PASS,"Booked Stock: "+ bookedStock);

			assertEquals(farmerHomePage.DespositedStock.isDisplayed(), true);
			String depositedStock = farmerHomePage.DespositedStock.getText();
			extentreport.log(Status.PASS,"Deposited Stock: "+depositedStock);

			assertEquals(farmerHomePage.AvalibleStock.isDisplayed(), true);
			String avalibleStock = farmerHomePage.AvalibleStock.getText();
			extentreport.log(Status.PASS,"Deposited Stock: "+avalibleStock);


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}
	}
}
