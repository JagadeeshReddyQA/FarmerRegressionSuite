package pages;


import org.openqa.selenium.support.PageFactory;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerWareHouseRequestPage extends BaseTest{
	public FarmerWareHouseRequestPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//Title
	@AndroidFindBy(accessibility = "Title") 
	public MobileElement WarehouseRequestPageTitle;
	//WH No Request Yet
	@AndroidFindBy(accessibility = "No Request Yet")
	public MobileElement NoRequests;
	//WareHouse Request Btn
	@AndroidFindBy(accessibility = "Warehouse Request Button Action")
	public MobileElement WareHouseRequestBtn;
	//+ Btn
	@AndroidFindBy(accessibility = "Button Create New WareHouse Request")
	public MobileElement PlusBtn;
	//T&C Check
	@AndroidFindBy(accessibility = "Terms Check")
	public MobileElement TandC_Chceck;
	//Accept Btn
	@AndroidFindBy(accessibility = "Accept Button Action")
	public MobileElement AcceptButton;
	//Sell Now Radio Btn
	@AndroidFindBy(accessibility = "Sell Now Button")
	public MobileElement SellNowBtn;
	//Sell later Radio Btn
	@AndroidFindBy(accessibility = "Sell Later Button")
	public MobileElement SellLaterBtn;
	//ProductDropwown
	@AndroidFindBy(accessibility = "Select Product Input Value")
	public MobileElement ProductDropwown;
	//Maize
	@AndroidFindBy(accessibility = "Maize")
	public MobileElement SelectMaize;
	//Paddy
	@AndroidFindBy(accessibility = "Paddy")
	public MobileElement SelectPaddy;
	//Quantity
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextValue")
	public MobileElement Quantity;
	//DateField
	@AndroidFindBy(accessibility = "Select Date Date Input Text")
	public MobileElement DateFeild;
	//SelectOK For Date
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public MobileElement DateOK;
	//Remarks
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Remarks']")
	public MobileElement Remarks;
	//Proceed Btn
	@AndroidFindBy(accessibility = "Proceed Button Action")
	public MobileElement Proceed;
	//ErrorPopUp
	@AndroidFindBy(id="android:id/message")
	public MobileElement PopupMsg;
	//PopUp OK Btn
	@AndroidFindBy(id="android:id/button1")
	public MobileElement PopUpOk;
	
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
	@AndroidFindBy(accessibility = "Request Value")
	public MobileElement ConfirmWareHouseType;
	//Confirmation Quantity
	@AndroidFindBy(accessibility = "Quantity Value")
	public MobileElement ConfirmQuantity;
	//Confirmation remarks
	@AndroidFindBy(accessibility = "Remarks Value")
	public MobileElement ConfirmRemarks;



	//SuccessMSG
	@AndroidFindBy(accessibility = "Message Sub Description")
	public MobileElement SuccessMsg;
	//View my request
	@AndroidFindBy(accessibility = "View My Request Button Action")
	public MobileElement ViewMyRequest;
	//Things to Know
	@AndroidFindBy(accessibility = "Information View Text")
	public MobileElement ThingsToKnow;
	//Points in Things to Know
	@AndroidFindBy(accessibility = "Information View")
	public MobileElement Points;

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
	//ATR_Req_Quantity
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='5']")
	public MobileElement ATR_Req_Quantity;
	//ATR_ViewDetails
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='7']")
	public MobileElement ATR_ViewDetails;
	//ATR_Edit
	//@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='9']")
	//public MobileElement ATR_Edit;

	//--------------VIEW  DETAILS

	//Requried Date
	@AndroidFindBy(accessibility = "Required Date Value")
	public MobileElement Details_RequiredDate;
	//WareHouse Type
	@AndroidFindBy(accessibility = "WareHouse Type Value")
	public MobileElement Details_WareHouseType;
	//Remarks
	@AndroidFindBy(accessibility = "Remarks Value")
	public MobileElement Details_Remarks;
	//Quantity
	@AndroidFindBy(accessibility = "Qty Value")
	public MobileElement Details_Quantity;

	//--------------EDIT ATR



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
	//Status_WaitingForApproval
	@AndroidFindBy(accessibility = "Waiting for approval")
	public MobileElement Status_WaitingForApproval;
	//Status_Approved
	@AndroidFindBy(accessibility = "Approved")
	public MobileElement Status_Approved;
	//Status_NotApproved
	@AndroidFindBy(accessibility = "Not approved")
	public MobileElement Status_NotApproved;
	//Status_Rejected
	@AndroidFindBy(accessibility = "Rejected")
	public MobileElement Status_Rejected;
	//Status_AccountsRejected    
	@AndroidFindBy(accessibility = "Accounts rejected")
	public MobileElement Status_Accounts_Rejected;
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
	@AndroidFindBy(accessibility = "Reset")
	public MobileElement ResetBtn;
	//X Btn
	@AndroidFindBy(accessibility = "Button Close")
	public MobileElement Close;
	//Back Btn
	@AndroidFindBy(id="//com.GrainbankFarmer.app:id/imageViewBackButton")
	public MobileElement NavigateBack;
	//ErrorMsg
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/errorText")
	public MobileElement ErrorMsg;
	//Snack Bar Error
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;
	//Sorry Msg
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewContent")
	public MobileElement SorryMsg;
	//Sorry Cancel
	@AndroidFindBy(accessibility = "Cancel")
	public MobileElement Sorry_Cancel;


	//---------View Details 
	//View Details
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/view_details")
	public MobileElement ViewDetails;
	//Product
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_product_name")
	public MobileElement V_D_Product ;
	//ATR Id
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_atr_id")
	public MobileElement V_D_ATR_ID;
	//ReqDate
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_atr_date")
	public MobileElement V_D_ReqDate;
	//Quantity
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_quantity")
	public MobileElement V_D_Qty;
	
	//Warehouse Type
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_warehouse_type")
	public MobileElement V_D_WarehouseType;
	//Warehouse
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewWarehouseValue")
	public MobileElement V_D_Warehouse;
	//Remarks
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_remarks")
	public MobileElement V_D_Remarks;


	//---------Edit ATR 

	//Edit ATR
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/edit_atr")
	public MobileElement Edit_ATR;
	//Edit Message
	@AndroidFindBy(accessibility = "You are editing warehouse request")
	public MobileElement E_Message;
	//Increment Btn
	@AndroidFindBy(accessibility = "Value Increment")
	public MobileElement IncrementBtn;
	//Edit Remarks
	@AndroidFindBy(xpath="(//android.widget.EditText[@index='0'])[2]")
	public MobileElement E_EditRemarks;
	//Proceed
	@AndroidFindBy(accessibility = "Proceed Button Action")
	public MobileElement E_Proceed;

	//--------- Referral Screen 
	@AndroidFindBy(accessibility = "Close")
	public MobileElement skipBtn;
	
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/msg")
	public MobileElement referMsg;

	public void accept_TandC() {
		click(TandC_Chceck);
		click(AcceptButton);
	}
	public void selectTodayDate() {
		click(DateFeild);
		click(DateOK);
	}

	public void addRemarks() {
		Remarks.clear();
		Remarks.sendKeys("QA Testing");
	}
	public void clickProceed() {
		click(Proceed);	
	}
	public void selectSellNow() {
		click(SellNowBtn);
	}
	public void selectSellLater() {
		click(SellLaterBtn);
	}
	public void clickProductDpwn() {
		click(ProductDropwown);
	}
	public void clickConfirmYes() {
		click(ConfirmYES);
	}
	public void clickSortBy() {
		click(SortBy);
	}
	public void clickFilter() {
		click(Filter);
	}
	public void clickApplyFilter() {
		click(Apply_Filter);
	}

	@SuppressWarnings("null")
	public void MsgDisplayed() {
		String msg = null;
		if (ErrorMsg.isDisplayed()) {
			msg = ErrorMsg.getText();
			System.out.println(msg);
		}
		else if (msg.contains("Please contact your VC for more information"))  {
			System.out.println("No Harvest Info is avaliable");
		}
	}
	
	public void clickSkipBtn() {
		
		click(skipBtn);
	}







}
