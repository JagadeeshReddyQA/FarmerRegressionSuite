package tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerStatementOfAccountPage;

public class TC6_ValidateStatementOfAccountTest extends BaseTest{
	@Test
	public void validateSOA() throws InterruptedException {
		System.out.println("TC6_ValidateStatementOfAccountTest");

		try {
			extentreport=extent.createTest("Statement Of Account Page","Validating Warehouse Request");
			Thread.sleep(1000);
			FarmerStatementOfAccountPage farmerStatementofAccount= new FarmerStatementOfAccountPage(device_driver);
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			AppiumGeneric.quickActionSwipe();
			String qaAccountStatement = farmerHomePage.QuickActionStatementofAccount.getText();
			farmerHomePage.QuickActionStatementofAccount.click();
			String accountStatement = farmerStatementofAccount.AccountStatementPageTitle.getText();
			if(qaAccountStatement.equalsIgnoreCase(accountStatement))
			{
				extentreport.log(Status.PASS, "Statement of Account Title Matched");	
			}
			else
				extentreport.log(Status.INFO, "Statement of Account Title Not Matched");
			farmerStatementofAccount.Quantity.click();
			try {
				if (farmerStatementofAccount.TotalStock.isDisplayed()) {
					String TotalStock = farmerStatementofAccount.TotalStock.getText();
					System.out.println(TotalStock);
					extentreport.log(Status.PASS,TotalStock);
					farmerStatementofAccount.Download.click();	
				}
			} catch (Exception e) {
				System.out.println("No Data Found");
			}



			//String toastMessage = device_driver.findElement((By.xpath("//android.widget.Toast[1]"))).getText();
			//String toaster = toastMessage.getAttribute("name");
			//System.out.println(toaster);
			//System.out.println("ToastMSG:"+toastMessage);

//			farmerStatementofAccount.Financials.click();
//			try {
//				if (farmerStatementofAccount.TotalAmount.isDisplayed()) {
//
//					String TotalAmount = farmerStatementofAccount.TotalAmount.getText();
//					System.out.println(TotalAmount);
//					extentreport.log(Status.PASS,TotalAmount);
//					farmerStatementofAccount.Download.click();
//				}
//
//			} catch (Exception e) {
//				System.out.println("No Data Found");
//			}


			navigateBack();
			Thread.sleep(1000);
			navigateBack();
			Thread.sleep(1000);


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw(e);

		}


	}


}
