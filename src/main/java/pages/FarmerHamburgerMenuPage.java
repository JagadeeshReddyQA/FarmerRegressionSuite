package pages;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerHamburgerMenuPage {
	public FarmerHamburgerMenuPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//My Profile
	@AndroidFindBy(xpath="//android.widget.TextView[@text='My Profile']")
	public MobileElement MyProfile;
	//My profile Title
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/title") 
	public MobileElement MyProfileTitle;
	//Offers
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Offers']")
	public MobileElement Offers;
	//MyRewards
	@AndroidFindBy(xpath="//android.widget.TextView[@text='My Rewards']")
	public MobileElement MyRewards;
	//SalesRequest
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sales Request']")
	public MobileElement SalesRequest;
	//WarehouseRequest
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Warehouse Request']")
	public MobileElement WarehouseRequest;
	//AdvancePayments
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Advance Payment']")
	public MobileElement AdvancePayments;
	//StockRelease
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Stock Release']")
	public MobileElement StockRelease;
	//SoilTest
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Soil Test']")
	public MobileElement SoilTest;
	//SOA
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Statement of Account']")
	public MobileElement SOA;
	//ChangeLanguage
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change Language']")
	public MobileElement ChangeLanguage;
	//About
	@AndroidFindBy(xpath="//android.widget.TextView[@text='About']")
	public MobileElement About;
	//Logout
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Logout']")
	public MobileElement Logout;
	






}
