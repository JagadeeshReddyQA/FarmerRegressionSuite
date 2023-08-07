package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerSignUpPage {
	public FarmerSignUpPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}

	@AndroidFindBy(accessibility = "Sign Up")
	public MobileElement signUpTitle;
	@AndroidFindBy(accessibility = "editTextFirstName_parent_layout_baseLayout_editTextValue")
	public MobileElement firstName;
	@AndroidFindBy(accessibility = "editTextLastName_parent_layout_baseLayout_editTextValue")
	public MobileElement lastName;
	@AndroidFindBy(accessibility = "editTextPhoneNumber_parent_layout_baseLayout_editTextValue")
	public MobileElement phoneNumber;
	@AndroidFindBy(accessibility = "editTextAadhaarNumber_parent_layout_baseLayout_editTextValue")
	public MobileElement aadhaarNumber;
	@AndroidFindBy(accessibility = "Continue Button Action")
	public MobileElement signUpContinue;
	@AndroidFindBy(accessibility = "Terms Check")
	public MobileElement tandC_Chceck;
	@AndroidFindBy(accessibility = "Accept Button Action")
	public MobileElement acceptButton;




	public void accept_TandC() {
		tandC_Chceck.click();
		acceptButton.click();
	}











}
