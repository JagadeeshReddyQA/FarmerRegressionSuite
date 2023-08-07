package pages;


import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerSalesRequest {
	public FarmerSalesRequest(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//OPEN TAB
	//Open tab
	@AndroidFindBy(accessibility="Open")
	public MobileElement OpenTab;
	//Title
	@AndroidFindBy(accessibility = "Title") 
	public MobileElement SalesRequestPageTitle;
	//No Request Yet
	@AndroidFindBy(accessibility = "No Request Yet")
	public MobileElement NoRequest;
	//Sales Request Btn
	@AndroidFindBy(accessibility = "Sales Request Button Action")
	public MobileElement SalesRequestBtn;
	//+ Btn
	@AndroidFindBy(accessibility = "Button Create Sale Request")
	public MobileElement PlusBtn;





	//------------Sales Request Page
	//WareHouse
	@AndroidFindBy(accessibility = "Select warehouse Input Value")
	public MobileElement wareHouse;
	//Select_WareHouse
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement selectWarehouse;
	//Product
	@AndroidFindBy(accessibility = "Select Product Input Value")
	public MobileElement Product;
	//Select_Product
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement Select_Product;
	//---------Quantiy
	//Full
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Full']")
	public MobileElement qty_Full;
	//Half
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Half']")
	public MobileElement qty_Half;
	//One/Fourth
	@AndroidFindBy(xpath="//android.widget.TextView[@text='One/Fourth']")
	public MobileElement qty_OneFourth;
	//other
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Other']")
	public MobileElement qty_Other;
	//----------------------
	//Expected Price
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Rate']")
	public MobileElement expected_Price;
	//Avaliable On
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement avaliable_On;
	//Expiry ON
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement expiry_On;
	//ProcuctType
	//@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewValue")
	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc='Select Product Input Value'])")
	public MobileElement Product_Type;


	//Entered Quantity
	@AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
	public MobileElement enteredQty;
	//Submit
	@AndroidFindBy(accessibility = "Submit Button Action")
	public MobileElement Submit_Btn;

	//Snack_Bar Error
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;


	//-------------DATE SCREEN
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



	//-----------------Confirmation Screen--------------------

	//Confirmation YES Btn
	@AndroidFindBy(accessibility = "Yes Button Action")
	public MobileElement ConfirmYES;
	//Confirmation No Btn
	@AndroidFindBy(accessibility = "No Button Action")
	public MobileElement ConfirmNo;
	//Confirmation RequriedDate
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/cd_product_date")
	public MobileElement ConfirmDate;
	//Confirmation WarehouseType
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/cd_request_type")
	public MobileElement ConfirmWareHouseType;
	//Confirmation Quantity
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/cd_product_quantity")
	public MobileElement ConfirmQuantity;
	//Confirmation remarks
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/cd_remarks")
	public MobileElement ConfirmRemarks;
	//SuccessMSG
	@AndroidFindBy(accessibility = "Sales Request Added Successfully")
	public MobileElement SuccessMsg;
	//View my request
	@AndroidFindBy(accessibility = "View My Request Button Action")
	public MobileElement ViewMyRequest;


	//----------------Product(1) Instance

	//ATR_Product
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	public MobileElement ATR_ProductName;
	//ATR_status
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='2']")
	public MobileElement ATR_Status;
	//ATR_Id
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='3']")
	public MobileElement ATR_ID;
	//ATR_CreatedDate
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='4']")
	public MobileElement ATR_CreatedDate;
	//ATR_ViewDetails
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='6']")
	public MobileElement SR_ViewDetails;
	//ATR_Cancel
	//@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='8']")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	public MobileElement ATR_Cancel;
	//Delete_Yes
	@AndroidFindBy(id="android:id/button1")
	public MobileElement Delete_Yes;
	//Delete No
	@AndroidFindBy(id="android:id/button2")
	public MobileElement Delete_No;


	//---------------FILTER
	//Reset
	@AndroidFindBy(accessibility = "Reset")
	public MobileElement Reset;
	//Search_ATR_NBR
	@AndroidFindBy(accessibility = "Search")
	public MobileElement Search_ATR_NBR;
	//Status_Expired
	@AndroidFindBy(accessibility = "Expired")
	public MobileElement Status_Expired;
	//Status_Completed
	@AndroidFindBy(accessibility = "Completed")
	public MobileElement Status_Completed;
	//Status_Rejected
	@AndroidFindBy(accessibility = "Rejected")
	public MobileElement Status_Rejected;
	//Status_Qty Full Filled'
	@AndroidFindBy(accessibility = "Qty Full Filled")
	public MobileElement Status_Qty_Full_Filled;
	//StartDate Field
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement StartDate;
	//Previous Month   //id = android:id/prev    //xpath=//android.widget.ImageButton[@content-desc="Previous month"]
	@AndroidFindBy(accessibility="Previous month")
	public MobileElement PreviousMonth;
	//ApplyFilter
	@AndroidFindBy(accessibility = "Apply Filter Button Action")
	public MobileElement Apply_Filter;
	//Reset
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/action_reset")
	public MobileElement ResetBtn;
	//EndDate
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement EndDate;
	//Open
	@AndroidFindBy(accessibility = "Open")
	public MobileElement Status_Open;
	//Approved
	@AndroidFindBy(accessibility = "Approved")
	public MobileElement Status_Approved;
	//Offer Accepting
	@AndroidFindBy(accessibility = "Offer Accepting")
	public MobileElement Status_OfferAccept;




	//-------------------HISTORY TAB
	@AndroidFindBy(accessibility="History")
	public MobileElement HistoryTab;
	//No Data Found
	@AndroidFindBy(accessibility = "No Data Found Msg")
	public MobileElement NoDataFound;
	//Filter
	@AndroidFindBy(accessibility = "Filter Text")
	public MobileElement Filter;
	//----------------SORT 
	//SortBy
	@AndroidFindBy(accessibility = "Sortby Txt")
	public MobileElement SortBy;
	//RecentRequest
	@AndroidFindBy(accessibility = "Recent Request")
	public MobileElement RecentRequest;
	//Old request
	@AndroidFindBy(accessibility = "Oldest Request")
	public MobileElement OlderRequest;


	//-----------------------View Details
	//View_Details_Product
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textView10")
	public MobileElement V_D_ProductName;
	//View_Details_ATR_ID
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textView11")
	public MobileElement V_D_ATR_ID;
	//View_Details_AvaliableOn
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_available_on")
	public MobileElement V_D_AvaliableOn;
	//View_Details_Expiry On
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_expire_on")
	public MobileElement V_D_ExpiryOn;
	//View_Details_ExpectedQuantity
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_expected_quant")
	public MobileElement V_D_Exp_Quantity;
	//View_Details_Expected Price
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_expected_price")
	public MobileElement V_D_Exp_Price;
	//View_Details_Total Buyers
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_total_buyer")
	public MobileElement V_D_Total_Buyers;
	//View_Details_ReceivedQuantity
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_received_quant")
	public MobileElement V_D_Received_Qty;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewSecondaryValue")
	public MobileElement displayedQty;
	
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/moisture") 
	public MobileElement toolTip;
	
	@AndroidFindBy(accessibility = "Moisture Message")
	public MobileElement moistureMsg;


	public void selectProduct() throws InterruptedException {
		Thread.sleep(2000);
		Product.click();
		Thread.sleep(2000);
		Select_Product.click();
		Thread.sleep(5000);
	}

	public void selectQuantity() {
		qty_OneFourth.click();
	}
	public void selectAvaliableOn() {
		avaliable_On.click();
		Cal_OKBtn.click();
	}
	public void selectExpiryOn() {
		expiry_On.click();
		Cal_OKBtn.click();	
	}
	public void clickSubmitBtn() {
		Submit_Btn.click();
	}
	public void clickOpenTab() {
		OpenTab.click();
	}
	public void clickHistoryTab() {
		HistoryTab.click();
	}
	public void clickSortBy() {
		SortBy.click();
	}
	public void clickOldRequest() {
		OlderRequest.click();
	}
	public void clickRecentRequest() {
		RecentRequest.click();
	}
	public void clickFilter() {
		Filter.click();
	}
	public void selectFullQty() {
		qty_Full.click();
	}
	public void selectAvaliableFutureDate() {

		avaliable_On.click();

		for (int i = 0; i < 5; i++) {
			NextMonth.click();
		}

		SelectDate_Start.click();
		Cal_OKBtn.click();
	}
	public void selectExpiryFutureDate() {

		expiry_On.click();

		for (int i = 0; i < 5; i++) {
			NextMonth.click();
		}

		SelectDate_Start.click();
		Cal_OKBtn.click();
	}












}
