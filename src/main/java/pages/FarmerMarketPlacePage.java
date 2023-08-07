package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerMarketPlacePage extends BaseTest{

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewMarketplace")
	public MobileElement mpTitle;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewBackButton")
	public MobileElement mpBackBtn;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewLocation")
	public MobileElement mpWarehouseName;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewWallet")
	public MobileElement mpWallet;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewDescription")
	public MobileElement mpPPLtext;

	@AndroidFindBy(accessibility = "null Button Action")
	public MobileElement mpOkayBtn;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_home")
	public MobileElement mpHomeBtn;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewOrders")
	public MobileElement mpMyOrders;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewCart")
	public MobileElement mpViewCart;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewMyOrders")
	public MobileElement mpMyOrdersTitle;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewCartHeader")
	public MobileElement mpMyCartTitle;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewEmptyCart")
	public MobileElement mpCartIsEmptyMsg;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/buttonGotoShop")
	public MobileElement mpStartShoppingBtn;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewEmptyCart")
	public MobileElement cartIsEmpty;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewEmptyProduct")
	public MobileElement noProductFound;


	//---------- Categories

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Seeds']")
	public MobileElement catSeeds;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Fertilisers']")
	public MobileElement catFertlisers;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Fungicides']")
	public MobileElement catFungicides;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Plant Growth Regulators']")
	public MobileElement catRegulators;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Insecticides']")
	public MobileElement catInsecticides;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Herbicides']")
	public MobileElement catHerbicides;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Nutrition']")
	public MobileElement catNutrition;


	//------------ Product Listing Page

	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc='Brand name'])[1]")
	public MobileElement brandName;

	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc='Product name'])[1]")
	public MobileElement productName;

	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc='Product price'])[1]")
	public MobileElement productPrice;

	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc='Sold by'])[1]")
	public MobileElement productSoldBy;

	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc='Minimum qty value'])[1]")
	public MobileElement productMinQty;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/tv_add")
	public MobileElement addBtn;


	//------ Search
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextSearch")
	public MobileElement searchField;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/imageViewSearch")
	public MobileElement searchBtn;


	//------------- Product Details Page
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewBrandName")
	public MobileElement pdBrandNme;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewProductName")
	public MobileElement pdProductNme;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewAvailableQty")
	public MobileElement pdAvailabelQty;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewPrice")
	public MobileElement pdProductPrice;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewMinimumQty")
	public MobileElement pdMixQty;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewSellerName")
	public MobileElement pdSellerName;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewDeliveryTo")
	public MobileElement pdDeliveryTo;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewEstimatedTime")
	public MobileElement pdEstimatedTime;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewProductName")
	public MobileElement pdproductNme;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewStockDetails")
	public MobileElement pdStockDetails;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewTotalAmount")
	public MobileElement pdTotalAmount;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/buttonAddToCart")
	public MobileElement pdAddToCart;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewAboutProductText")
	public MobileElement pdAboutProduct;

	@AndroidFindBy(accessibility = "Snack Bar Msg")
	public MobileElement snackBarMsg;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewSubtraction")
	public MobileElement substract;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/constraintLayoutAddition")
	public MobileElement addition;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewButtonText")
	public MobileElement viewCartBtn;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewInCartTotal")
	public MobileElement itemsInCart;


	//------------ Sort By

	@AndroidFindBy(accessibility = "Sortby Txt")
	public MobileElement sortBy;

	@AndroidFindBy(accessibility = "Recent Request")
	public MobileElement lowToHigh;

	@AndroidFindBy(accessibility = "Oldest Request")
	public MobileElement highToLow;


	//------------ Filter Operation
	@AndroidFindBy(accessibility = "Filter Text")
	public MobileElement filter;

	@AndroidFindBy(accessibility = "Reset")
	public MobileElement reset;

	@AndroidFindBy(accessibility = "Apply Filter Button Action")
	public MobileElement applyFilter;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Drop Down'])[1]")
	public MobileElement drpdwnCategory;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Drop Down'])[2]")
	public MobileElement drpdwnSubCategory;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Drop Down'])[3]")
	public MobileElement drpdwnSeller;

	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement fstItem;

	//------------- Categories Btn & List
	@AndroidFindBy(xpath="//android.widget.TextView[@text='CATEGORIES']")
	public MobileElement categoriesBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Speciality Plant Nutrition']")
	public MobileElement catSpecialPlantNutrition;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewRemove")
	public MobileElement removeBtn;


	//--------------- Orders List
	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	public MobileElement orderNum;

	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
	public MobileElement orderDate;

	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")
	public MobileElement orderPrice;

	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[4]")
	public MobileElement orderStatus;


	//--------------- My Orders Filter
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextOrderNum")
	public MobileElement filterOrderNum;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextProductName")
	public MobileElement filterProductNme;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/editTextVendorName")
	public MobileElement filterSellerNme;

	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc='Drop Down'])[1]")
	public MobileElement filterProdStatus;

	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc='Drop Down'])[2]")
	public MobileElement filterOrdrStatus;

	//--------------- Date
	//StartDate Field
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement startDate;
	//Previous Month   //id = android:id/prev    //xpath=//android.widget.ImageButton[@content-desc="Previous month"]
	@AndroidFindBy(accessibility="Previous month")
	public MobileElement previousMonth;
	//Select Day
	@AndroidFindBy(id="android:id/month_view")
	public MobileElement selectDateStart;
	//calender_Cancel
	@AndroidFindBy(id="android:id/button2")
	public MobileElement calCancelBtn;
	//Calender_Ok
	@AndroidFindBy(id="android:id/button1")
	public MobileElement calOKBtn;

	//EndDate
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Select Date'])[1]")
	public MobileElement endDate;
	
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/buttonConfirmOrder")
	public MobileElement confirmOrder;

	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewAddition")
	public MobileElement add;

	@AndroidFindBy(accessibility="Parent Market Place")
	public MobileElement hamMarketPlace;
	




	public FarmerMarketPlacePage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}

	public void clickmpBackBtn() throws InterruptedException {
		Thread.sleep(2000);
		click(mpBackBtn);
		Thread.sleep(2000);
	}
	public void clickmpWallet() {
		click(mpWallet);
	}
	public void clickHomeBtn() throws InterruptedException {
		Thread.sleep(3000);
		click(mpHomeBtn);
		Thread.sleep(5000);
	}
	public void clickMyOrdersBtn() throws InterruptedException {
		Thread.sleep(3000);
		click(mpMyOrders);
		Thread.sleep(5000);
	}
	public void clickCartBtn() throws InterruptedException {
		Thread.sleep(3000);
		click(mpViewCart);
		Thread.sleep(5000);
	}
	public void verifyPplMsgDisplayed() {
		boolean msg = mpPPLtext.isDisplayed();
		Assert.assertEquals(msg, true);

	}
	public void clickOkBtn() {
		click(mpOkayBtn);
	}
	public void clickStartShopping() throws InterruptedException {
		Thread.sleep(2000);
		click(mpStartShoppingBtn);
		Thread.sleep(3000);
	}
	public void clickSearch() {
		click(searchBtn);
	}

	public void searchProduct(String product) throws InterruptedException {
		searchField.sendKeys(product);
		Thread.sleep(2000);
		click(searchBtn);

	}
	public void clickAddToCart() throws InterruptedException {
		Thread.sleep(2000);
		click(pdAddToCart);
	}

	public void clickAddBtn() throws InterruptedException {
		Thread.sleep(2000);
		click(addition);
	}
	public void clickSubBtn() {
		click(substract);
	}
	public void clickSortBy() throws InterruptedException {
		Thread.sleep(2000);
		click(sortBy);
	}
	public void selectHightoLow() throws InterruptedException {
		Thread.sleep(2000);
		click(highToLow);
	}
	public void selectLowtoHigh() throws InterruptedException {
		Thread.sleep(2000);
		click(lowToHigh);
	}
	public void clickFilter() throws InterruptedException {
		Thread.sleep(2000);
		click(filter);
	}
	public void selectSeller() throws InterruptedException {
		Thread.sleep(3000);
		click(drpdwnSeller);
		click(fstItem);
		click(applyFilter);
	}

	public void selectSubCategory() throws InterruptedException {
		Thread.sleep(2000);
		click(drpdwnSubCategory);
		Thread.sleep(2000);
		click(fstItem);
		click(applyFilter);
	}
	public void selectReset() throws InterruptedException {
		Thread.sleep(2000);
		click(reset);
		click(applyFilter);
		Thread.sleep(8000);
	}

	public void clickCategoriesBtn() throws InterruptedException {
		Thread.sleep(2000);
		click(categoriesBtn);
	}
	public void clickCatSeeds() throws InterruptedException {
		Thread.sleep(2000);
		click(catSeeds);
	}
	public void clickCatFertlisers() throws InterruptedException {
		Thread.sleep(2000);
		click(catFertlisers);
	}
	public void clickCatFungicides() throws InterruptedException {
		Thread.sleep(2000);
		click(catFungicides);
	}
	public void clickCatRegulators() throws InterruptedException {
		Thread.sleep(2000);
		click(catRegulators);
	}
	public void clickCatInsecticides() throws InterruptedException {
		Thread.sleep(2000);
		click(catInsecticides);
	}
	public void clickCatHerbicides() throws InterruptedException {
		Thread.sleep(2000);
		click(catHerbicides);
	}
	public void clickCatSpecialPlantNutrition() throws InterruptedException {
		Thread.sleep(2000);
		click(catSpecialPlantNutrition);
	}
	public void myOrderFilterReset() throws InterruptedException {
		Thread.sleep(2000);
		click(reset);
	}
	public void selectProductStatus() throws InterruptedException {
		Thread.sleep(2000);
		click(filterProdStatus);
		Thread.sleep(2000);
		click(fstItem);
		click(applyFilter);
	}
	public void selectOrderStatus() throws InterruptedException {
		Thread.sleep(2000);
		click(filterOrdrStatus);
		Thread.sleep(2000);
		click(fstItem);
		click(applyFilter);
	}

	public void clickApplyFilter() throws InterruptedException {
		Thread.sleep(2000);
		click(applyFilter);
		Thread.sleep(2000);
	}

























}
