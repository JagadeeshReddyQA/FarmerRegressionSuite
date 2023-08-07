package pages;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerLandingPage extends BaseTest{
	public FarmerLandingPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}


	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewRightArrow")
	public MobileElement RightArrow;
	@AndroidFindBy(accessibility = "Get Started Button Action")
	public MobileElement GetStartedButton;
	@AndroidFindBy(accessibility = "Save Changes Button Action")
	public MobileElement Savebutton;
	@AndroidFindBy(accessibility = "Sign In Button Action")
	public MobileElement SignInButton;
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter username/mobile number']")
	public MobileElement Enter_Username_Mobilenumber;
	@AndroidFindBy(accessibility = "Enter Password Input Value")
	public MobileElement Enter_Password;	
	@AndroidFindBy(accessibility = "Sign In Button Action")
	public MobileElement SignIn;
	@AndroidFindBy(accessibility = "Sign Up Button Action")
	public MobileElement signUp;
	//Snack_Bar Error
	@AndroidFindBy(id = "com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement SnackBar;
	//--------- Accessibility ID
	//Sign In
	@AndroidFindBy(accessibility = "Sign In Button Action")
	public MobileElement accSignIn;
	//Usr Name
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	public MobileElement accUsrName;
	//Pass
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	public MobileElement accPassword;
	//SignInContinue
	@AndroidFindBy(accessibility = "Sign In Button Action")
	public MobileElement accSignInContinue;
	//Location
	@AndroidFindBy(id = "com.GrainbankFarmer.app:id/textViewLocation")
	public MobileElement accLocation;
	//Home Screen Profile
	@AndroidFindBy(accessibility = "Footer Menu Account")
	public MobileElement accProfile;
	//Home Screen Offers
	@AndroidFindBy(accessibility = "Footer Menu Offers")
	public MobileElement accOffers;
	//Title
	@AndroidFindBy(accessibility = "Title")
	public MobileElement accTitle;
	//change Language
	@AndroidFindBy(accessibility = "Action Change Language")
	public MobileElement accChangeLang;
	//Save Changes
	@AndroidFindBy(accessibility = "Save Changes Button Action")
	public MobileElement accSaveChanges;


	//---------
	//clear Name
	@AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
	public MobileElement Name;
	//clear Pswd
	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
	public MobileElement Pswd;

	//Change Language
	@AndroidFindBy(accessibility = "English Language Layout")
	public MobileElement English;
	@AndroidFindBy(accessibility = "Action Change Language")
	public MobileElement ChangeLanguage;
	//Hindi
	@AndroidFindBy(accessibility = "Hindi Language Layout")
	public MobileElement Hindi;
	//Marati
	@AndroidFindBy(accessibility = "Marathi Language Layout")
	public MobileElement Marati;
	//Kanada
	@AndroidFindBy(accessibility = "Kannada Language Layout")
	public MobileElement Kanada;


	//Change Language Hindi Version
	@AndroidFindBy(accessibility = "Action Change Language")
	public MobileElement cLHindiV;
	//Change Language Marati Version
	@AndroidFindBy(accessibility = "Action Change Language")
	public MobileElement cLMaratiV;
	//Change Language Kanada Version
	@AndroidFindBy(accessibility = "Action Change Language")
	public MobileElement cLKanadaV;
	//Change Language English Version
	@AndroidFindBy(accessibility = "Action Change Language")
	public MobileElement cLEnglishV;
	//Save Hindi Version
	@AndroidFindBy(accessibility = "Save Changes Button Action")
	public MobileElement saveHindiV;
	//Save Marati Version
	@AndroidFindBy(accessibility = "Save Changes Button Action")
	public MobileElement saveMaratiV;
	//Save Kanada Version
	@AndroidFindBy(accessibility = "Save Changes Button Action")
	public MobileElement saveKanadaV;

	//Indicative Rate
	@AndroidFindBy(accessibility = "Moisture Message")
	public MobileElement moistureMessage;
	@AndroidFindBy(accessibility = "I Understand Button Action")
	public MobileElement iUnderstandBtn;
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/buttonLayout")
	public MobileElement understandBtn;

	public void navigateToSignUpPage() {
		try {
			RightArrow.click();
			RightArrow.click();
			GetStartedButton.click();
			clickEnglish();
			Savebutton.click();
			signUp.click();


		} catch (Exception e) {
			try {
				signUp.click();

			} catch (Exception e2) {
				Savebutton.click();
				signUp.click();
			}
		}
	}

	public void navigateToLoginPage() {
		try {
			RightArrow.click();
			RightArrow.click();
			GetStartedButton.click();
			clickEnglish();
			Savebutton.click();
			SignIn.click();

		} catch (Exception e) {
			try {
				SignIn.click();

			} catch (Exception e2) {
				Savebutton.click();
				SignIn.click();
			}
		}
	}

	public void navigateToChangeLanguagePage() {
		try {
			RightArrow.click();
			RightArrow.click();
			GetStartedButton.click();
			clickEnglish();
			Savebutton.click();
			accChangeLang.click();

		} catch (Exception e) {
			try {
				accChangeLang.click();

			} catch (Exception e2) {
				Savebutton.click();
				accChangeLang.click();
			}
		}
	}


	public void loginToApp(String usrNme,String pwd) throws InterruptedException {
		Enter_Username_Mobilenumber.sendKeys(usrNme);
		Enter_Password.sendKeys(pwd);
		SignInButton.click();
		Thread.sleep(10000);
		try {
			checkIndicativeRate();
		} catch (Exception e) {
			// TODO: handle exception
		}



	}
	public void checkIndicativeRate() {

		if (moistureMessage.isDisplayed()) {
			String msg = moistureMessage.getText();
			System.out.println(msg);
			understandBtn.click();
			extentreport.log(Status.PASS, "Msg Displayed: "+msg);
			try {
				click(iUnderstandBtn);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}






	public void clickSaveBtn() {
		click(Savebutton);
	}

	public void setUserName(String usrNme)
	{
		Enter_Username_Mobilenumber.sendKeys(usrNme);
	}

	public void setPassWord(String pwd)
	{
		Enter_Password.sendKeys(pwd);
	}

	public void clickSignInBtn() {
		click(SignInButton);
	}
	public void clrUsrName() {
		Name.clear();

	}
	public void clrPswd() {
		Pswd.clear();
	}
	public void setUsrNme(String usrNme)
	{
		Name.sendKeys(usrNme);
	}

	public void setPswd(String pwd)
	{
		Pswd.sendKeys(pwd);
	}
	public void changeLanguage() {
		click(ChangeLanguage);
	}
	public void clickHindi() {
		click(Hindi);
	}
	public void clickMarati() {
		click(Marati);
	}
	public void clickKanada() {
		click(Kanada);
	}
	public void clickEnglish() {
		try {
			click(English);
		} catch (StaleElementReferenceException e) {
			refreshed(English);
		}

	}








}
