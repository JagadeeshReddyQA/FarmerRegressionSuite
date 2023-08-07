package pages;


import org.openqa.selenium.support.PageFactory;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FarmerMyProfilePage extends BaseTest{
	public FarmerMyProfilePage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//Farmer Name
		@AndroidFindBy(accessibility = "Farmer Name")
		public MobileElement Name;
		//Farmer Id
		@AndroidFindBy(accessibility = "MEM ID")
		public MobileElement ID;
		//UserType
		@AndroidFindBy(accessibility = "Farmer")
		public MobileElement UserType;
		//Edit Profile
		@AndroidFindBy(accessibility = "Edit Profile")
		public MobileElement EditProfile;
		//FirstName
		@AndroidFindBy(accessibility = "First Name Value")
		public MobileElement FirstName;
		//LastName
		@AndroidFindBy(accessibility = "Last Name Value")
		public MobileElement lastName;
		//MobileNum
		@AndroidFindBy(accessibility = "Mobile No Value")
		public MobileElement MobileNumber;
		//Aadhafr Number
		//@AndroidFindBy(id="")
		//public MobileElement AadharNumber;
		//Land in acers
		@AndroidFindBy(accessibility = "Land Value")
		public MobileElement LandInAcers;
		//Address
		@AndroidFindBy(accessibility = "Address Value")
		public MobileElement Address;
		//DarkMode
		@AndroidFindBy(accessibility = "Dark Mode Switch")
		public MobileElement DarkModeBtn;
		//150.00 Acres
		@AndroidFindBy(xpath="//android.widget.EditText[@text='150.00']")
		public MobileElement Acers;
		//EmptyLandField
		@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter land (in acres)']")
		public MobileElement EmptyLandField;
		//SaveChanges Btn
		@AndroidFindBy(accessibility = "Save Changes Button Action")
		public MobileElement SaveChangesBtn;
		//Snack_Bar 
		@AndroidFindBy(id = "com.GrainbankFarmer.app:id/snackbar_text")
		public MobileElement SnackBar;
		//FName
		@AndroidFindBy(xpath="(//android.widget.EditText[@index='0'])[1]")
		public MobileElement FName;
		
		
		
		public void clickEditProfile() {
			click(EditProfile);	
		}
		public void clickDarkModeBtn() {
			click(DarkModeBtn);
		}
		
		
		
		
}
