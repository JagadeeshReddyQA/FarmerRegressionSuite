package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FarmerMyRewardsPage {
	public FarmerMyRewardsPage(AndroidDriver<AndroidElement> device_driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(device_driver), this);
	}
	@AndroidFindBy(accessibility = "My Rewards Title") 
	public WebElement RewardsPageTitle;	
	@AndroidFindBy(accessibility = "Rewards Statement Button Action")
	public WebElement RewardsStatementsBtn;
	//Coming Soon Msg
	@AndroidFindBy(accessibility = "Rewards Coming Soon")
	public WebElement Coming_Soon_Msg;
	
	
	
	
	
	

}
