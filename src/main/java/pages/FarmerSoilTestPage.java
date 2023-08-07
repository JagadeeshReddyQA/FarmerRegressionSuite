package pages;
import org.openqa.selenium.support.PageFactory;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerSoilTestPage extends BaseTest{
	public FarmerSoilTestPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	@AndroidFindBy(accessibility = "Title") 
	public MobileElement SoilTestPageTitle;	
	//No Request Yet!
	@AndroidFindBy(accessibility = "No Request Yet Msg")
	public MobileElement NoRequestYet;
	//Soil Test Request
	@AndroidFindBy(accessibility = "Button Soil Test Request")
	public MobileElement SoilTestRequest;
	//OpenTab
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Open']")
	public MobileElement Open_Tab;
	//History Tab
	@AndroidFindBy(xpath="//android.widget.TextView[@text='History']")
	public MobileElement History_Tab;


	//Add Btn
	@AndroidFindBy(accessibility = "Create Request")
	public MobileElement Add;
	//Farmer WareHouse Name
	@AndroidFindBy(accessibility = "Ware House Name")
	public MobileElement FarmerWareHouseName;
	//Select Warehouse
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement Select_Warehouse;
	//WareHouse DropDown
	@AndroidFindBy(accessibility = "Drop Down")
	public MobileElement WareHouseDropdown;


	//Select WareHouse
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/linearLayoutItemHolder")
	public MobileElement Warehouse;

	//Field Name Dropdown
	@AndroidFindBy(accessibility = "Custom Select Filed Name")
	public MobileElement FieldNameDropdown;
	//FieldName
	@AndroidFindBy(accessibility = "Location Text")
	public MobileElement FieldName;
	//Save&Next
	@AndroidFindBy(accessibility = "Button Save Next")
	public MobileElement SaveandNext;
	//Select District
	@AndroidFindBy(accessibility = "Select district Input Value")
	public MobileElement SelectDistrictDropdown;
	//Select District
	@AndroidFindBy(accessibility = "Araria")
	public MobileElement District;

	//Select Block
	@AndroidFindBy(accessibility = "Select block Input Value")
	public MobileElement SelectBlockDropdown;
	//Select Block
	@AndroidFindBy(accessibility = "Araria")
	public MobileElement Block;

	//croptobe grown
	@AndroidFindBy(accessibility = "Crop to be grown Input Value")
	public MobileElement CropToBeGrownDropdown;
	@AndroidFindBy(accessibility = "Paddy")
	public MobileElement CropToBeGrown;

	//LandInAcers
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextValue")
	public MobileElement LandInAcers;

	//Previous Btn
	@AndroidFindBy(accessibility = "Button Previous")
	public MobileElement PreviousBtn;
	//Proceed Btn
	@AndroidFindBy(accessibility = "Button Save Next")
	public MobileElement ProceedBtn;
	//check T&C
	@AndroidFindBy(accessibility = "Terms Accept")
	public MobileElement TandCcheck;
	//Accept
	@AndroidFindBy(accessibility = "Button Action Accept")
	public MobileElement Accept;
	//reject
	@AndroidFindBy(accessibility = "Button Action Reject")
	public MobileElement Reject;
	//Success Msg
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/alert")
	public MobileElement SuccessMsg;


	//-------VIEW DETAILS
	//ATR ID
	@AndroidFindBy(accessibility = "Soil Test Id")
	public MobileElement V_D_AtrID;

	//ViewDetails
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/details")
	public MobileElement View_Details;
	//ComputeID
	@AndroidFindBy(accessibility = "Compute Id Value")
	public MobileElement V_D_ComputeID;
	//District
	@AndroidFindBy(accessibility = "District Name Value")
	public MobileElement V_D_District;
	//WareHouse
	@AndroidFindBy(accessibility = "Warehouse Name")
	public MobileElement V_D_WareHouse;
	//Block
	@AndroidFindBy(accessibility = "Block Value")
	public MobileElement V_D_Block;
	//FieldName
	@AndroidFindBy(accessibility = "Plot Or Field Value")
	public MobileElement V_D_FieldName;
	//CropToBeGrown
	@AndroidFindBy(accessibility = "Crop To Be Grown Value")
	public MobileElement V_D_CropToBeGrown;
	//SurveyNo
	@AndroidFindBy(accessibility = "Survey No Value")
	public MobileElement V_D_SurveyNo;
	//LIA
	@AndroidFindBy(accessibility = "Land In Acres Value")
	public MobileElement V_D_LandInAcers;


	//--------HISTORY 
	//view Details Result Ready
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='View Details'])[1]")
	public MobileElement ResultReady_V_D;
	//view Details Failed 
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='View Details'])[2]")
	public MobileElement Failed_V_D;
	//Soil Test Report
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/title")
	public MobileElement SoilTestReport;

	//Snack Bar Error
	//@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewContent")
	//public MobileElement SnkError;
	//Snack Bar Error
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;

	//----------------SORT 
	//SortBy
	@AndroidFindBy(accessibility = "SortBy Parent")
	public MobileElement SortBy;
	//RecentRequest
	@AndroidFindBy(accessibility = "Button Recent Request")
	public MobileElement RecentRequest;
	//Old request
	@AndroidFindBy(accessibility = "Button Oldest Request")
	public MobileElement OlderRequest;

	//----------------Product(1) Instance

	//ATR_ID
	@AndroidFindBy(xpath="//android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")
	public MobileElement ATR_ID;
	//ATR_status
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='2']")
	public MobileElement ATR_Status;
	//Test_Id
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='3']")
	public MobileElement Test_ID;
	//ATR_TimeStamp
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='4']")
	public MobileElement ATR_TimeStamp;
	//ATR_NoteMsg
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='5']")
	public MobileElement ATR_NoteMsg;

	//---------------Filter
	//Filter
	@AndroidFindBy(accessibility = "Filter Text")
	public MobileElement Filter;
	//Reset
	@AndroidFindBy(accessibility = "Reset")
	public MobileElement Reset;
	//ApplyFilter
	@AndroidFindBy(accessibility = "Button Apply Filter")
	public MobileElement Apply_Filter;
	//Search_ATR_NBR
	@AndroidFindBy(accessibility = "Search")
	public MobileElement Search_ATR_NBR;
	//StartDate Field
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Select Date']")
	public MobileElement StartDate;
	//Previous Month   //id = android:id/prev    //xpath=//android.widget.ImageButton[@content-desc="Previous month"]
	@AndroidFindBy(accessibility="Previous month")
	public MobileElement PreviousMonth;
	//Select Day
	@AndroidFindBy(id="android:id/month_view")
	public MobileElement SelectDate_Start;
	//Calender_Ok
	@AndroidFindBy(id="android:id/button1")
	public MobileElement Cal_OKBtn;
	//Reset
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/action_reset")
	public MobileElement ResetBtn;
	//EndDate
	@AndroidFindBy(xpath="//android.widget.TextView[@text='End Date']")
	public MobileElement EndDate;

	public void clickSoilTestRequest()
	{
		click(SoilTestRequest);
	}
	public void clickOpenTab() {
		click(Open_Tab);
	}
	public void clickHistoryTab() {
		click(History_Tab);
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






}


