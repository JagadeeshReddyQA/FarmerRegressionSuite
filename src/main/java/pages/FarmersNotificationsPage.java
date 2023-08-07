package pages;

import org.openqa.selenium.support.PageFactory;

import generic.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmersNotificationsPage extends BaseTest{
	public FarmersNotificationsPage(AndroidDriver<AndroidElement> device_driver) {
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	//Notifications Screen

	//Title
	@AndroidFindBy(accessibility = "Title")
	public MobileElement notificationTitle;
	
	//Read all button
	@AndroidFindBy(id = "com.GrainbankFarmer.app:id/textViewReadAll")
	public MobileElement readAllBtn;
	
	//Snack_Bar Error
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/snackbar_text")
	public MobileElement snackBarMsg;
	
	//Displaying last n days msg
	@AndroidFindBy(id="com.GrainbankFarmer.app:id/textViewDayCount")
	public MobileElement displayLastnDaysMsg;

	//CollapseOrExpandBtn
	@AndroidFindBy(xpath="(//android.widget.ImageView[@index=2])[1]")
	public MobileElement collapseOrExpandBtn;

	//Message Content
	@AndroidFindBy(xpath = "(//android.widget.TextView[@index=3])[1]")
	public MobileElement msgContent;
	
	
	public void clickReadAll() throws InterruptedException {
		Thread.sleep(4000);
		click(readAllBtn);
	}
	public void name() {
		
	}
	
	
}
