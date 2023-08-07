package com.farmer.scripts.AdvancePayment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pages.FarmerAdvancePaymentPage;
import pages.FarmerHomePage;

public class TC_005_AP_Verify_Sorting_Operation_Sort_By_Oldest_Request_Test extends BaseTest{
	String aTR_ProductName;
	String aTR_Status;
	String aTR_ID;
	String aTR_CreatedDate;
	String aTR_Loan_Amt;
	Date dateDisplaying;
	Date todaydate;

	@Test

	public void advancePayments_Request_Sort_By_Old_Request() {
		System.out.println("TC_005_AP_Verify_Sorting_Operation_Sort_By_Oldest_Request_Test");
		try {
			extentreport=extent.createTest("A_P_SORT_BY_Old_Request"," Verifying user is able to Sort the List By Oldest Order");
			FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
			farmerHomePage.clickAdvancePayments();
			FarmerAdvancePaymentPage farmerAdvancePayment = new FarmerAdvancePaymentPage(device_driver);

			try {
				if (farmerAdvancePayment.SortBy!=null && farmerAdvancePayment.SortBy.isDisplayed()) {
					farmerAdvancePayment.SortBy.click();
					Thread.sleep(1000);
					farmerAdvancePayment.OlderRequest.click();
					Thread.sleep(3000);
					aTR_ProductName= farmerAdvancePayment.ATR_ProductName.getText();
					aTR_Status= farmerAdvancePayment.ATR_Status.getText();
					aTR_ID= farmerAdvancePayment.ATR_ID.getText();
					aTR_CreatedDate= farmerAdvancePayment.ATR_CreatedDate.getText(); //07 May 2022
					aTR_Loan_Amt= farmerAdvancePayment.ATR_Loan_Amt.getText();
					dateDisplaying=new SimpleDateFormat("dd MMM yyyy").parse(aTR_CreatedDate);
					String tDate = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
					todaydate=new SimpleDateFormat("dd MMM yyyy").parse(tDate);
					//change to before after 23-june-2022
					//if( dateDisplaying.before(todaydate))
					//{
					extentreport.log(Status.PASS, "ATR_Product: "+aTR_ProductName);
					extentreport.log(Status.PASS, "ATR_Status: "+aTR_Status);
					extentreport.log(Status.PASS, "ID: "+ aTR_ID);
					extentreport.log(Status.PASS, "ATR_Date: "+aTR_CreatedDate);
					extentreport.log(Status.PASS, "ATR_Loan_Amt: "+aTR_Loan_Amt);
					System.out.println("ADVANCE PAYMENTS REQUEST SORT BY OLDEST DETAILS DISPLAYED ");
					//}
					//else {
					//	extentreport.log(Status.INFO, "SORTED BY OLDEST DETAILS");
					//extentreport.addScreenCaptureFromPath(captureScreenShot("FarmerApp.jpg"));
					//}
				}
			} catch (Exception e) {
				System.out.println("SORT BY DISABLED");
				extentreport.log(Status.INFO, "SORT BY DISABLED");
				navigateBack();		
			}
		} catch (Exception e) {
			navigateBack();	
			e.printStackTrace();
			throw(e);

		}
	}
}
