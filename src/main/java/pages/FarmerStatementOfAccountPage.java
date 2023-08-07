package pages;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerStatementOfAccountPage {
	public FarmerStatementOfAccountPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	@AndroidFindBy(accessibility = "Title") 
	public MobileElement AccountStatementPageTitle;	
	//NoData Found
	@AndroidFindBy(accessibility = "Error Message")
	public MobileElement No_Data_Found;
	//Quantity
	@AndroidFindBy(accessibility = "Quantity")
	public MobileElement Quantity;
	//Financial
	@AndroidFindBy(accessibility = "Financials")
	public MobileElement Financials;
	//Download
	@AndroidFindBy(accessibility = "Download")
	public MobileElement Download;
	//Total Stock
	@AndroidFindBy(accessibility = "Text Value")
	public MobileElement TotalStock;
	//Total Amount
	@AndroidFindBy(accessibility = "Text Value")
	public MobileElement TotalAmount;

	//Selected Range
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_selected_range")
	public MobileElement DateRange;
	//Crop Details
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textView10")
	public MobileElement CropDetails;
	//Snack_Bar Success MSG
	@AndroidFindBy(accessibility = "Report Downloaded successfully")
	public MobileElement snackBarSuccessmsg;
	//SnackBar MSG
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement snackBar;

	//-------------DATE SCREEN
	//Product Dropdown
	@AndroidFindBy(accessibility = "Drop Down")
	public MobileElement Product_Dropdown;
	//Select_Product
	@AndroidFindBy(accessibility = "All")
	public MobileElement Select_Product;
	//StartDate
	@AndroidFindBy(xpath="(//android.widget.TextView[@index='2'])[2]")
	public MobileElement Start_Date;
	//Submit
	@AndroidFindBy(accessibility = "Submit Button Action")
	public MobileElement Submit_Btn;
	//NextMonth 
	@AndroidFindBy(accessibility = "Next month")
	public MobileElement NextMonth;
	//Select Day
	@AndroidFindBy(id="android:id/month_view")
	public MobileElement SelectDate_Start;
	//calender_Cancel
	@AndroidFindBy(id="android:id/button2")
	public MobileElement Cal_CancelBtn;
	//Calender_Ok
	@AndroidFindBy(id="android:id/button1")
	public MobileElement Cal_OKBtn;



	public void clickQuantity() {
		Quantity.click();
	}
	public void clickFinancials() {
		Financials.click();
	}
	public void clickDownload() {
		Download.click();
	}
	public void clickSubmitBtn() {
		Submit_Btn.click();
	}
	public void clickDropdown() {
		Product_Dropdown.click();
	}
	public void selectProduct() {
		Select_Product.click();
	}

	public void clickSubmit() {
		Submit_Btn.click();
	}

	public void selectNextMonth() {
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		NextMonth.click();
		SelectDate_Start.click();
		Cal_OKBtn.click();
	}
	



}
