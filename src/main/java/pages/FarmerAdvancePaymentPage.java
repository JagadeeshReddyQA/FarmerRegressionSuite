package pages;


import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerAdvancePaymentPage {
	public FarmerAdvancePaymentPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//
	@AndroidFindBy(accessibility = "Advance Payment Title") 
	public MobileElement AdvancePaymentPageTitle;
	//No Advance Payments
	@AndroidFindBy(accessibility = "No Advance Payment Request")
	public MobileElement NoRequests;
	//NoProduct
	@AndroidFindBy(accessibility = "No Data Found Msg")
	public MobileElement NoProduct;

	//Create Btn
	@AndroidFindBy(accessibility = "Create New Button Action")
	public MobileElement CreateNow;
	//+ Btn
	@AndroidFindBy(accessibility = "Create Advance Payment")
	public MobileElement PlusBtn;
	//T&C Check
	@AndroidFindBy(accessibility = "Terms Check")
	public MobileElement TandC_Chceck;
	//Accept Btn
	@AndroidFindBy(accessibility = "Accept Button Action")
	public MobileElement AcceptButton;
	//--- Select Your Product

	//Avalible Stock
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewAvailableStock")
	public MobileElement AvalibleStock;
	//Total Product Amount
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewTotalAmount")
	public MobileElement TotalProductAmount_SPS;
	//Select Product
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewCheckBox")
	public MobileElement SelectProduct;
	//Submit Btn
	@AndroidFindBy(accessibility = "Submit Button Action")
	public MobileElement SubmitBtn;


	//-------Request Amount Screen

	//Total Product Amount
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewLoanAmountValue")
	public MobileElement TotalProductAmount_RAS;
	//DisbursementAmountValue
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewDisbursementAmountValue")
	public MobileElement DisbursementAmountValue;
	//EnterRequestAmount
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextValue")
	public MobileElement RequestAmount;
	//Bank Location
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewBankLocation")
	public MobileElement BankLocation;
	//Select Bank
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewCheckBox")
	public MobileElement SelectBank;
	//Bank View Details
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewViewDetails")
	public MobileElement Bank_ViewDetails;
	//Snack Bar Error
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;



	//---------Bank Details Screen

	//Bank name
	@AndroidFindBy(accessibility = "Bank Name Value")
	public MobileElement BankName;
	//IFSC_CODE
	@AndroidFindBy(accessibility = "IFSC Code Value")
	public MobileElement IFSC_CODE;
	//Branch Name
	@AndroidFindBy(accessibility = "Branch Name Value")
	public MobileElement BranchName;
	//Account Number
	@AndroidFindBy(accessibility = "Account No Value")
	public MobileElement AccountNumber;
	//Account Name
	@AndroidFindBy(accessibility = "Account Name Value")
	public MobileElement AccountName;
	//Account Tyoe
	@AndroidFindBy(accessibility = "Account Type Value")
	public MobileElement AccountType;
	//Is Account Primary
	@AndroidFindBy(accessibility = "Primary Account Value")
	public MobileElement PrimaryAccount;

	//-----------Confirmation Screen:: CS


	//Product Name
	@AndroidFindBy(accessibility = "Product Name")
	public MobileElement ProductName_CS;
	//ATR ID
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewProductId")
	public MobileElement ATR_ID_CS;
	//Total product Amount
	@AndroidFindBy(accessibility = "Total Product Amount Value")
	public MobileElement ProductAmount_CS;
	//Bank Name
	@AndroidFindBy(accessibility = "Bank Name")
	public MobileElement BankDetails_CS;
	//Eligible Amount
	@AndroidFindBy(accessibility = "Eligible Loan Amt Value")
	public MobileElement EligibleAmount_CS;
	//Accont Nbr
	@AndroidFindBy(accessibility = "Account Number Value")
	public MobileElement Acc_Nbr_CS;
	//Expand
	@AndroidFindBy(accessibility = "Down Arrow")
	public MobileElement Expand_CS;
	//requested Amount
	@AndroidFindBy(accessibility = "Request Amt Value")
	public MobileElement RequestedAmount_CS;

	//Conformation MSg
	@AndroidFindBy(accessibility = "Advance Pymt Confirmation Msg")
	public MobileElement Confirmation_Msg_CS;
	//Confirm_No
	@AndroidFindBy(accessibility = "No Button Action")
	public MobileElement Confirm_NO;
	//Confirm yes
	@AndroidFindBy(accessibility = "Yes Button Action")
	public MobileElement Confirm_Yes;

	//Success Msg
	@AndroidFindBy(accessibility = "Message Status")
	public MobileElement SuccessMsg;

	//View My request
	@AndroidFindBy(accessibility = "View My Request Button Action")
	public MobileElement ViewMyRequest;


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

	//----------------Product(1) Instance

	//ATR_Product    
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='2']/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[@index='1']")
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

	//ATR_Loan_Amt
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='7']")
	public MobileElement ATR_Loan_Amt;
	//ATR_ViewDetails
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='10']")
	public MobileElement ATR_ViewDetails;


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
	@AndroidFindBy(accessibility = "Disbursed")
	public MobileElement Status_Disbursed;
	//Status_Expired    
	@AndroidFindBy(accessibility = "Expired")
	public MobileElement Status_Expired;
	//Status_NotApproved
	@AndroidFindBy(accessibility = "Not approved")
	public MobileElement Status_NotApproved;
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











}
