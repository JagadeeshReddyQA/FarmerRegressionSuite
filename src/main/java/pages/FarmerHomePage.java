package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerHomePage extends BaseTest{

	public FarmerHomePage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//Offers
	@AndroidFindBy(accessibility = "Footer Menu Offers")
	public MobileElement Offers;

	//QUICK ACTION ITEMS
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewUserName") 
	public MobileElement FarmerName;
	//GoToHomePage
	@AndroidFindBy(accessibility = "Back To Homepage Button Action")
	public MobileElement GoToHomePage;
	@AndroidFindBy(accessibility = "My Rewards Feature Text")
	public MobileElement QuickActionMyRewards;
	@AndroidFindBy(accessibility = "Warehouse Request Feature Text")
	public MobileElement QuickActionWarehouseRequest;
	@AndroidFindBy(accessibility = "Advance Payment Feature Text")
	public MobileElement QuickActionAdvancePayment;
	@AndroidFindBy(accessibility = "Stock Release Feature Text")
	public MobileElement QuickActionStockRelease;
	@AndroidFindBy(accessibility = "Soil Test Feature Text")
	public MobileElement QuickActionSoilTest;
	@AndroidFindBy(accessibility = "Statement of Account Feature Text")
	public MobileElement QuickActionStatementofAccount;
	@AndroidFindBy(accessibility = "Sales Request Feature Text")
	public MobileElement QuickActionSalesRequest;
	@AndroidFindBy(accessibility = "Quick Action List")
	public MobileElement QuickActionBar;
	//Account
	@AndroidFindBy(accessibility = "Footer Menu Account")
	public MobileElement Account;

	//ViewAllCrops Swipe
	@AndroidFindBy(accessibility = "Crop List")
	public MobileElement ViewAllCrops;

	//HAMNURGER MENU
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewIconMenu")
	public MobileElement HamburgerMenu; 
	@AndroidFindBy(xpath="android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@index='1']")
	public MobileElement HamburgerMenuList;
	//My Profile
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
	public MobileElement hamMyProfile;

	//Notifications Icon
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/gifImageViewNewNotifications")
	public MobileElement noticationIconGif;
	
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewNotification")
	public MobileElement notificationIcon;

	////android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@index='1'] 
	//DashBoard Stock Details
	@AndroidFindBy(accessibility = "My Stock Value")
	public MobileElement MyStockValue;
	@AndroidFindBy(accessibility = "Request Stock Value")
	public MobileElement BookedStock;
	@AndroidFindBy(accessibility = "Depostied Stock Value")
	public MobileElement DespositedStock;
	@AndroidFindBy(accessibility = "Available Stock")
	public MobileElement AvalibleStock;

	//-------CROPS
	//Paddy
	@AndroidFindBy(accessibility = "Paddy textViewCrops_1")
	public MobileElement Crop_Paddy;
	//Wheat
	@AndroidFindBy(accessibility = "Wheat textViewCrops_2")
	public MobileElement Crop_Wheat;
	//Maize
	@AndroidFindBy(accessibility = "Maize textViewCrops_3")
	public MobileElement Crop_Maize;

	//----------Market Place
	@AndroidFindBy(accessibility = "Market Place Feature Text")
	public MobileElement marketPlace;
	
	
	
	
	//MarketPrice
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewMarketValue")
	public MobileElement Market_Price;
	//No Stock
	@AndroidFindBy(accessibility = "Market Value")
	public MobileElement Market_Price_NoStock;
	
	
	
	
	
	
	

	public By by_FarmerName=By.id("com.GrainbankFarmer.app:id/textViewUserName");

	//Indicative Rate
	@AndroidFindBy(accessibility = "Moisture Message")
	public MobileElement moistureMessage;
	@AndroidFindBy(accessibility = "I Understand Button Action")
	public MobileElement iUnderstandBtn;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/buttonLayout")
	public MobileElement understandBtn;

	public void checkIndicativeRate() {
		try {
			if (moistureMessage.isDisplayed()) {
				String msg = moistureMessage.getText();
				System.out.println(msg);
				iUnderstandBtn.click();
				extentreport.log(Status.PASS, "Msg Displayed: "+msg);
			}
		} catch (Exception e) {
			try {
				understandBtn.click();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void logout() throws InterruptedException {
		HamburgerMenu.click();
		String logout="Logout";
		AndroidElement logoutBtn = device_driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
						+ logout + "\").instance(0))");
		//AppiumGeneric.scrollIntoView("Logout");
		System.out.println("Scrolled Till Logout");

		Thread.sleep(1000);
		logoutBtn.click();
		System.out.println("User Logged Out");

	}
	public void hindiLogout() throws InterruptedException {
		HamburgerMenu.click();
		String logout="लॉग आउट";
		AndroidElement logoutBtn = device_driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
						+ logout + "\").instance(0))");
		System.out.println("Scrolled Till Logout");
		Thread.sleep(1000);
		logoutBtn.click();
		System.out.println("User Logged Out");
	}
	public void maratiLogout() throws InterruptedException {
		HamburgerMenu.click();
		String logout="बाहेर पडणे";
		AndroidElement logoutBtn = device_driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
						+ logout + "\").instance(0))");
		System.out.println("Scrolled Till Logout");
		Thread.sleep(1000);
		logoutBtn.click();
		System.out.println("User Logged Out");
	}
	public void kannadaLogout() throws InterruptedException {
		HamburgerMenu.click();
		String logout="ಲಾಗ್ ಔಟ್";
		AndroidElement logoutBtn = device_driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
						+ logout + "\").instance(0))");
		System.out.println("Scrolled Till Logout");
		Thread.sleep(1000);
		logoutBtn.click();
		System.out.println("User Logged Out");
	}



	public void waitTillNameisDisplayed() {
		new WebDriverWait(device_driver, 3).until(ExpectedConditions.visibilityOfElementLocated(by_FarmerName));
	}
	public void clickHamburgerMenu() {
		HamburgerMenu.click();
	}
	public void clickWareHouseRequest() {

		click(QuickActionWarehouseRequest);
	}
	public void clickOffers() {
		Offers.click();
	}
	public void clickRewards() {
		QuickActionMyRewards.click();
	}
	public void clickAdvancePayments() {
		click(QuickActionAdvancePayment);
	}
	public void clickStockRelease() {
		QuickActionStockRelease.click();
	}
	public void clickSoilTest() throws InterruptedException {
		QuickActionSoilTest.click();
		Thread.sleep(2000);
	}
	public void clickStatemtofAccount() {
		click(QuickActionStatementofAccount);
	}
	public void clickSaleRequest() {
		QuickActionSalesRequest.click();
	}
	public void clickMyHamProfile() {
		click(hamMyProfile);
	}



	//-----Crops
	public void clickPaddy() {
		Crop_Paddy.click();
	}
	public void clickWheat() {
		Crop_Wheat.click();
	}
	public void clickMaize() {
		Crop_Maize.click();
	}
	public double getMarketPrice() {
		String price = Market_Price.getText();
		String marketPrice = price.replaceAll("[^\\d.]", "");
		double dMarketPrice = Double.parseDouble(marketPrice);
		System.out.println(dMarketPrice);

		return dMarketPrice;
	}
	public double  getMarketPriceNoStock() {
		String price = Market_Price_NoStock.getText();
		String marketPrice = price.replaceAll("[^\\d.]", "");
		double dMarketPrice = Double.parseDouble(marketPrice);
		System.out.println(dMarketPrice);
		return dMarketPrice;
	}

	public void marketRate_Paddy() {
		clickPaddy();

		try {
			if (Market_Price.isDisplayed()) {

				paddyMarketPrice= getMarketPrice();

			}

		} catch (Exception e) {
			paddyMarketPrice=getMarketPriceNoStock();
		}	
	}
	public void marketRate_Wheat() {
		clickWheat();

		try {
			if (Market_Price.isDisplayed()) {
				wheatMarketPrice = getMarketPrice();
			}

		} catch (Exception e) {
			wheatMarketPrice=getMarketPriceNoStock();
		}	
	}
	public void marketRate_Maize() {
		clickMaize();

		try {
			if (Market_Price.isDisplayed()) {
				maizeMarketPrice=getMarketPrice();
			}

		} catch (Exception e) {
			maizeMarketPrice=getMarketPriceNoStock();
		}		
	}

	public void clickAccount() {
		click(Account);
	}
	public void clickNotificationIcon() throws InterruptedException {
		
		try {
			Thread.sleep(3000);
			click(noticationIconGif);
			Thread.sleep(4000);
		} catch (Exception e) {
			click(notificationIcon);
		}
		
	}
	
	public void clickMarketPlace() throws InterruptedException {
		marketPlace.click();
		Thread.sleep(3000);
	}




}
