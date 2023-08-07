package pages;


import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerOffersPage {

	public FarmerOffersPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//No_Offers
	@AndroidFindBy(accessibility = "No Offers Yet MSg")
	public MobileElement No_Offers_Yet;
	//History Tab
	@AndroidFindBy(accessibility = "History")
	public MobileElement History_Tab;
	//AcceptOffer
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/action_accept")
	public MobileElement Accept_Offer;

	//Available Stock Text
	@AndroidFindBy(accessibility = "Available Stock")
	public MobileElement Available_stock;
	//Quantity Entered
	@AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
	public MobileElement Entered_QTY;
	//PromtPayment
	@AndroidFindBy(accessibility = "Prompt Paymen")
	public MobileElement Prompt_Payment;
	//Normal Payment
	@AndroidFindBy(accessibility = "Normal Payment")
	public MobileElement Normal_Payment;
	//ProceedBtn
	@AndroidFindBy(accessibility = "Proceed Button Action")
	public MobileElement Proceed_Btn;
	//Accept
	@AndroidFindBy(accessibility = "Accept Button Action")
	public MobileElement Accept;
	//Snack Bar Error
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;
	//requestSuccess
	@AndroidFindBy(accessibility = "Message Sub Description")
	public MobileElement Request_Success;
	//Back to homepage
	@AndroidFindBy(accessibility = "Back To Homepage Button Action")
	public MobileElement BacktoHomePage;



	//---------Quantiy
	//Full
	@AndroidFindBy(accessibility = "Full Item Quantity")
	public MobileElement qty_Full;
	//Half
	@AndroidFindBy(accessibility = "Half Item Quantity")
	public MobileElement qty_Half;
	//One/Fourth
	@AndroidFindBy(accessibility = "One/Fourth Item Quantity")
	public MobileElement qty_OneFourth;
	//other
	@AndroidFindBy(accessibility = "Other Item Quantity")
	public MobileElement qty_Other;

	//----------------Product(1) Instance

	//ATR_Product
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")
	public MobileElement ATR_ProductName;
	//ATR_status
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='2']")
	public MobileElement ATR_Status;
	//ATR_Id
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='3']")
	public MobileElement ATR_ID;
	//ATR_AvalibleOn
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='5']")
	public MobileElement ATR_AvailableOn;
	//ATR_AvalibleOn
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='7']")
	public MobileElement ATR_ExpiryOn;
	//ATR_ExptdQty
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='9']")
	public MobileElement ATR_ExptdQty;
	//ATR_ReceivedQty
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='11']")
	public MobileElement ATR_ReceivedQty;
	//ATR_ExptdPrice
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='13']")
	public MobileElement ATR_ExptdPrice;
	//ATR_AcceptedQty
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='15']")
	public MobileElement ATR_AcceptedQty;
	//ATR_ViewDetails
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='17']")
	public MobileElement ViewDetails;







	public void clickHistoryTab() {
		History_Tab.click();
	}
	public void clickAcceptOffer() {
		Accept_Offer.click();
	}
	public void clickProceed() {
		Proceed_Btn.click();
	}
	public void clickBackToHomepage() {
		BacktoHomePage.click();	
	}


}
