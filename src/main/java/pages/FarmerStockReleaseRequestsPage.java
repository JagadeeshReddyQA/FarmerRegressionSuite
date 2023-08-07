package pages;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerStockReleaseRequestsPage {
	public FarmerStockReleaseRequestsPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//Title
	@AndroidFindBy(accessibility = "Title") 
	public MobileElement StockReleaseRequestsPageTitle;
	//No Request Yet
	@AndroidFindBy(accessibility = "No Request Yet Msg")
	public MobileElement NoRequests;
	//Stock Release Request_Btn
	@AndroidFindBy(accessibility = "Stock Release Requests Button Action")
	public MobileElement StockRequestBtn;
	//+_Btn
	@AndroidFindBy(accessibility = "Button Create Stock Request")
	public MobileElement PlusBtn;
	//T&C Check
	@AndroidFindBy(accessibility = "Terms Check")
	public MobileElement TandC_Chceck;
	//Accept_Btn
	@AndroidFindBy(accessibility = "Accept Button Action")
	public MobileElement AcceptButton;


	//REQUEST TYPE
	//Self
	@AndroidFindBy(accessibility = "Self Button")
	public MobileElement Self;

	//Warehouse
	@AndroidFindBy(accessibility = "Select Warehouse Input Value")
	public MobileElement WareHouse;
	//Select_Warehouse
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement Select_WareHouse;
	//Product
	@AndroidFindBy(accessibility = "Select Product Input Value")
	public MobileElement Product;
	//Select_Product
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement Select_Product;
	//Total_Quantity
	@AndroidFindBy(xpath="//android.widget.EditText[@enabled='false']")
	public MobileElement Total_Quantity;
	//Requested_Quantity
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Quantity']")
	public MobileElement Requested_Quantity;
	//DateField
	@AndroidFindBy(accessibility = "Select Date Date Input Text")
	public MobileElement DateFeild;
	//SelectOK For Date
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public MobileElement DateOK;
	//Remarks
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Remarks']")
	public MobileElement Remarks;
	//Proceed_Btn
	@AndroidFindBy(accessibility = "Proceed Button Action")
	public MobileElement Proceed;


	//REQUEST TYPE
	//Sell
	@AndroidFindBy(accessibility = "Sell Butotn")
	public MobileElement Sell;
	//Sell_Select_Product
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='2']")
	public MobileElement Sell_Select_Product;
	//Available_Stock
	@AndroidFindBy(accessibility = "Available Stock Value")
	public MobileElement AvailableStock;
	//CurrentPrice
	@AndroidFindBy(accessibility = "Current Price Value")
	public MobileElement CurrentPrice;
	//BuyersName
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Name']")
	public MobileElement BuyerName;
	//Rate
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Rate']")
	public MobileElement Rate;
	//Quantity In Quintal
	@AndroidFindBy(xpath="//android.widget.EditText[@text='0']")
	public MobileElement Quantity_In_Quintal;


	//-----------------Confirmation Screen--------------------

	//Confirmation YES Btn
	@AndroidFindBy(accessibility = "Accept Button Action")
	public MobileElement ConfirmYES;
	//Confirmation No Btn
	@AndroidFindBy(accessibility = "Reject Button Action")
	public MobileElement ConfirmNo;
	//Confirmation RequriedDate
	@AndroidFindBy(accessibility = "Date Value")
	public MobileElement ConfirmDate;
	//Confirmation WarehouseType
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/cd_request_type")
	public MobileElement ConfirmWareHouseType;
	//Confirmation Quantity
	@AndroidFindBy(accessibility = "Qty Value")
	public MobileElement ConfirmQuantity;
	//Confirmation remarks
	@AndroidFindBy(accessibility = "Remarks Value")
	public MobileElement ConfirmRemarks;
	//SuccessMSG
	@AndroidFindBy(accessibility = "Success Msg")
	public MobileElement SuccessMsg;
	//View my request
	@AndroidFindBy(accessibility = "View My Request Button Action")
	public MobileElement ViewMyRequest;
	//Snack_Bar Error
	//@AndroidFindBy(accessibility = "Failed to create Stock Release request as the farmer is already having a Stock release Request.")
	//public MobileElement SnackBar;
	//Snack_Bar Error
	@AndroidFindBy(id = "com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;
	
	

	//----------------Product(1) Instance

	//ATR_Product
	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")
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
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='7']")
	public MobileElement ATR_ViewDetails;
	//ATR_Edit
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='9']")
	public MobileElement ATR_Edit;

	//------------VIEW DETAILS
	//View_Details_Product
	@AndroidFindBy(accessibility = "Stock Product Name")
	public MobileElement V_D_ProductName;
	//View_Details_ATR_ID
	@AndroidFindBy(accessibility = "Stock Product AtrNo")
	public MobileElement V_D_ATR_ID;
	//View_Details_RequriedDate
	@AndroidFindBy(accessibility = "Stock Required Date Value")
	public MobileElement V_D_RequriedDate;
	//View_Details_Qauntity
	@AndroidFindBy(accessibility = "Stock Qty Value")
	public MobileElement V_D_Quantity;
	//View_Details_Purpose type
	@AndroidFindBy(accessibility = "Purpose Type Value")
	public MobileElement V_D_Purpose_Type;
	//View_Details_Remarks
	@AndroidFindBy(accessibility = "Remarks Value")
	public MobileElement V_D_Remarks;


	//-----------EDIT REQUEST
	//Edit Message
	@AndroidFindBy(accessibility = "Editing Stock Relase Msg")
	public MobileElement E_Message;
	//Requested ID
	@AndroidFindBy(accessibility = "Request Id")
	public MobileElement E_ID;
	//Edit Remarks
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextValue")
	public MobileElement E_EditRemarks;
	//Cancel
	@AndroidFindBy(accessibility = "Cancel Button Action")
	public MobileElement E_Cancel;
	//Submit
	@AndroidFindBy(accessibility = "Submit Button Action")
	public MobileElement E_Submit;
	//Snack bar Msg
	@AndroidFindBy(accessibility = "Stock Release request updated successfully")
	public MobileElement E_SnackBarMsg;


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


	//---------------FILTER
	//Filter
	@AndroidFindBy(accessibility = "Filter Text")
	public MobileElement Filter;
	//Reset
	@AndroidFindBy(accessibility = "Reset")
	public MobileElement Reset;
	//Search_ATR_NBR
	@AndroidFindBy(accessibility = "Search")
	public MobileElement Search_ATR_NBR;
	//Status_Open
	@AndroidFindBy(accessibility = "Open")
	public MobileElement Status_Open;
	//Approved
	@AndroidFindBy(accessibility = "Approved")
	public MobileElement Status_Approved;
	//Status_Approved
	@AndroidFindBy(accessibility = "Processed")
	public MobileElement Status_Processed;
	//Status_Disbursed
	@AndroidFindBy(accessibility = "Rejected")
	public MobileElement Status_Rejected;
	//Status_Expired    
	@AndroidFindBy(accessibility = "Completed")
	public MobileElement Status_Completed;
	//StartDate Field
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement StartDate;
	//Previous Month   //id = android:id/prev    //xpath=//android.widget.ImageButton[@content-desc="Previous month"]
	@AndroidFindBy(accessibility="Previous month")
	public MobileElement PreviousMonth;
	//Select Day
	@AndroidFindBy(id="android:id/month_view")
	public MobileElement SelectDate_Start;
	//calender_Cancel
	@AndroidFindBy(id="android:id/button2")
	public MobileElement Cal_CancelBtn;
	//Calender_Ok
	@AndroidFindBy(id="android:id/button1")
	public MobileElement Cal_OKBtn;

	//EndDate
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement EndDate;

	//ApplyFilter
	@AndroidFindBy(accessibility = "Apply Filter Button Action")
	public MobileElement Apply_Filter;
	//Reset
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/action_reset")
	public MobileElement ResetBtn;
	//X Btn
	@AndroidFindBy(accessibility = "Button Close")
	public MobileElement Close;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/cancel_atr")
	public MobileElement CancelBtn;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='View Details'])[1]")
	public MobileElement ViewDetails;










}
