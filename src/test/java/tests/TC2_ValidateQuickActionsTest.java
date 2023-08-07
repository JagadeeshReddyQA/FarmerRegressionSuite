package tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;
import pages.FarmerMyRewardsPage;
import pages.FarmerSalesRequest;
import pages.FarmerStatementOfAccountPage;
import pages.FarmerStockReleaseRequestsPage;
import pages.FarmerWareHouseRequestPage;

public class TC2_ValidateQuickActionsTest extends BaseTest {
	@Test
	public void quickActionMenu() throws InterruptedException {
		System.out.println("TC2_ValidateQuickActionsTest");
		try {


			extentreport= extent.createTest("Quick Action Menu","Validating Quick Actions Menu Items");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			FarmerMyRewardsPage farmerMyRewardsPage = new FarmerMyRewardsPage(device_driver);
			FarmerWareHouseRequestPage farmerWareHouseRequestPage = new FarmerWareHouseRequestPage(device_driver);
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);
			FarmerStockReleaseRequestsPage farmerStockReleseRequest = new FarmerStockReleaseRequestsPage(device_driver);
			//FarmerSoilTestPage farmerSoilTest = new FarmerSoilTestPage(device_driver);
			FarmerStatementOfAccountPage farmerStatementofAccount= new FarmerStatementOfAccountPage(device_driver);
			FarmerSalesRequest farmerSalesRequest = new FarmerSalesRequest(device_driver);

			String farmerName=farmerHomePage.FarmerName.getText();
			extentreport.log(Status.PASS, "Displayed Farmer Name:"+farmerName);	
			System.out.println("Displayed Farmer Name: "+farmerName);
			//MY REWARDS
			System.out.println("REWARDS");
			String qaMyRewards =farmerHomePage.QuickActionMyRewards.getText();
			farmerHomePage.QuickActionMyRewards.click();
			String rewards=farmerMyRewardsPage.RewardsPageTitle.getText();
			if(qaMyRewards.equalsIgnoreCase(rewards))
			{
				extentreport.log(Status.PASS, "My Rewards Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "My Rewards Title Not Matched");
			navigateBack();
			Thread.sleep(1000);
			//Warehouse Request
			System.out.println("Warehouse Request");
			String qaWareHouse=farmerHomePage.QuickActionWarehouseRequest.getText();
			farmerHomePage.QuickActionWarehouseRequest.click();
			String wareHouseRequest = farmerWareHouseRequestPage.WarehouseRequestPageTitle.getText();
			if(qaWareHouse.equalsIgnoreCase(wareHouseRequest))
			{
				extentreport.log(Status.PASS, "Ware House Request Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "Ware House Request Title Not Matched");
			navigateBack();
			Thread.sleep(1000);
			//Advance Payment
			System.out.println("Advance Payment");
			String qaAdvancePayment = farmerHomePage.QuickActionAdvancePayment.getText();
			farmerHomePage.QuickActionAdvancePayment.click();
			String advancePayment = farmerAdvancePayment.AdvancePaymentPageTitle.getText();
			if(qaAdvancePayment.equalsIgnoreCase(advancePayment))
			{
				extentreport.log(Status.PASS, "Advance Payment Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "Advance Payment Title Not Matched");
			navigateBack();
			Thread.sleep(1000);
			//Stock Release Request
			AppiumGeneric.quickActionSwipe();
			System.out.println("Stock Release Request");
			String qaStockRelease= farmerHomePage.QuickActionStockRelease.getText();
			farmerHomePage.QuickActionStockRelease.click();
			String stockReleseRequest = farmerStockReleseRequest.StockReleaseRequestsPageTitle.getText();
			if(qaStockRelease.equalsIgnoreCase(stockReleseRequest))
			{
				extentreport.log(Status.PASS, "Stock Release Requests Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "Stock Release Requests Title Not Matched");
			Thread.sleep(3000);
			navigateBack();
			Thread.sleep(2000);
			//Swipe
			AppiumGeneric.quickActionSwipe();
			Thread.sleep(1000);
			//Soil Test
			/*
			 * System.out.println("Soil Test"); String qaSoilTest =
			 * farmerHomePage.QuickActionSoilTest.getText(); Thread.sleep(1000);
			 * farmerHomePage.QuickActionSoilTest.click(); String soilTest =
			 * farmerSoilTest.SoilTestPageTitle.getText();
			 * if(qaSoilTest.equalsIgnoreCase(soilTest)) { extentreport.log(Status.PASS,
			 * "Soil Test Title Matched"); } else extentreport.log(Status.INFO,
			 * "Soil Test Title Not Matched"); navigateBack(); Thread.sleep(2000);
			 * AppiumGeneric.quickActionSwipe();
			 */
			//Statement of Account
			System.out.println("Statement of Account");
			String qaAccountStatement = farmerHomePage.QuickActionStatementofAccount.getText();
			Thread.sleep(1000);
			farmerHomePage.QuickActionStatementofAccount.click();
			String accountStatement = farmerStatementofAccount.AccountStatementPageTitle.getText();
			if(qaAccountStatement.equalsIgnoreCase(accountStatement))
			{
				extentreport.log(Status.PASS, "Statement of Account Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "Statement of Account Title Not Matched");
			navigateBack();
			Thread.sleep(1000);
			navigateBack();
			Thread.sleep(2000);
			AppiumGeneric.quickActionSwipe();
			//SalesRequest
			System.out.println("SalesRequest");
			String qaSalesRequest=farmerHomePage.QuickActionSalesRequest.getText();
			Thread.sleep(1000);
			farmerHomePage.QuickActionSalesRequest.click();
			String salesRequest = farmerSalesRequest.SalesRequestPageTitle.getText();
			if(qaSalesRequest.equalsIgnoreCase(salesRequest))
			{
				extentreport.log(Status.PASS, "Sales Request Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "Sales Request Title Not Matched");
			navigateBack();
			Thread.sleep(1000);


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}


	}

}
