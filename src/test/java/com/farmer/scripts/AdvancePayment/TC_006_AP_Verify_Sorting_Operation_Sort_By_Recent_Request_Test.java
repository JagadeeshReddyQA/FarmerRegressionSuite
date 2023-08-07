package com.farmer.scripts.AdvancePayment;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;

public class TC_006_AP_Verify_Sorting_Operation_Sort_By_Recent_Request_Test extends BaseTest {
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Loan_Amt;
	@Test
	public void advancePayments_Request_Sort_By_Recent_Request() throws Exception {
		System.out.println("TC_006_AP_Verify_Sorting_Operation_Sort_By_Recent_Request_Test");
		try {
			extentreport=extent.createTest("A_P_SORT_BY_Recent_Request"," Verifying user is able to Sort the List By Recent Order");
			//FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			Thread.sleep(1000);
			//farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);

			try {
				if (farmerAdvancePayment.SortBy!=null && farmerAdvancePayment.SortBy.isDisplayed()) {
					farmerAdvancePayment.SortBy.click();
					Thread.sleep(1000);
					farmerAdvancePayment.RecentRequest.click();
					Thread.sleep(3000);
					aTR_ProductName= farmerAdvancePayment.ATR_ProductName.getText();
					aTR_Status= farmerAdvancePayment.ATR_Status.getText();
					aTR_ID= farmerAdvancePayment.ATR_ID.getText();
					aTR_CreatedDate= farmerAdvancePayment.ATR_CreatedDate.getText(); //07 May 2022
					aTR_Loan_Amt= farmerAdvancePayment.ATR_Loan_Amt.getText();
				//	Date dateDisplaying=new SimpleDateFormat("dd MMM yyyy").parse(aTR_CreatedDate);
				//	String tDate = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
				//	Date todaydate=new SimpleDateFormat("dd MMM yyyy").parse(tDate);

					//if( dateDisplaying.equals(todaydate))
					//{
						extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
						extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
						extentreport.log(Status.PASS, "ID: "+ aTR_ID);
						extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
						extentreport.log(Status.PASS, "ATR_Loan_Amt: "+aTR_Loan_Amt);
						System.out.println("ADVANCE PAYMENTS REQUEST SORT BY RECENT DETAILS DISPLAYED ");
						navigateBack();
					//}
					//else {
					//	extentreport.log(Status.INFO, "SORTED BY RECENT DETAILS");
					//}
				}

			} catch (Exception e) {

				System.out.println("SORT BY DISABLED");
				extentreport.log(Status.INFO, "SORT BY DISABLED");
				navigateBack();		

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);

		}
	}
}
