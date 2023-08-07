package tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import generic.AppiumGeneric;
import generic.BaseTest;
import pages.FarmerHomePage;
import pages.FarmerSoilTestPage;

public class TC7_ValidateSoilTest_Test extends BaseTest{

	@Test
	public void validateSoilTest() throws InterruptedException {
		System.out.println("TC7_ValidateSoilTest_Test");

		extentreport=extent.createTest("Soil Test","Validating SoilTest");
		Thread.sleep(1000);
		FarmerSoilTestPage farmerSoilTest = new FarmerSoilTestPage(device_driver);
		FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
		//WebDriverWait wait = new WebDriverWait(device_driver, 20);
		Thread.sleep(2000);
		AppiumGeneric.quickActionSwipe();
		String qaSoilTest = farmerHomePage.QuickActionSoilTest.getText();
		farmerHomePage.QuickActionSoilTest.click();
		String soilTest = farmerSoilTest.SoilTestPageTitle.getText();
		if(qaSoilTest.equalsIgnoreCase(soilTest))
		{
			extentreport.log(Status.PASS, "Soil Test Title Matched");	
		}
		else
			extentreport.log(Status.FAIL, "Soil Test Title Not Matched");
		farmerSoilTest.Add.click();
		farmerSoilTest.WareHouseDropdown.click();
		farmerSoilTest.Select_Warehouse.click();
		//farmerSoilTest.FieldNameDropdown.click();
		farmerSoilTest.FieldNameDropdown.sendKeys("4654/7");
		farmerSoilTest.SaveandNext.click();
		farmerSoilTest.SelectDistrictDropdown.click();
		farmerSoilTest.District.click();
		farmerSoilTest.SelectBlockDropdown.click();
		farmerSoilTest.Block.click();
		farmerSoilTest.CropToBeGrownDropdown.click();
		farmerSoilTest.CropToBeGrown.click();
		farmerSoilTest.LandInAcers.sendKeys("10");
		farmerSoilTest.ProceedBtn.click();
		farmerSoilTest.TandCcheck.click();
		farmerSoilTest.Accept.click();
		Thread.sleep(1000);
		String Msg = farmerSoilTest.SuccessMsg.getText();
		System.out.println("Success Msg"+Msg);
		navigateBack();
		Thread.sleep(1000);


	}

}
