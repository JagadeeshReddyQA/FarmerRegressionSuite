package generic;

import java.time.Duration;
import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.FarmerHomePage;

public class AppiumGeneric extends BaseTest{

	@SuppressWarnings("rawtypes")
	public static void quickActionSwipe() throws InterruptedException {
		FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
		WebElement panel = farmerHomePage.QuickActionBar;
		org.openqa.selenium.Dimension dimension= panel.getSize();
		Thread.sleep(2000);
		System.out.println("Touch Actions Banner Swipe");
		//System.out.println("Dimensions Are: "+dimension);
		int Anchor = panel.getSize().getWidth();
		//System.out.println("Anchor:"+Anchor);
		Double ScreenWidthStart = dimension.getWidth() * 0.9;
		int scrollStart = ScreenWidthStart.intValue();
		//System.out.println("scrollStart:"+scrollStart);
		Double ScreenWidthEnd = dimension.getWidth() * 0.1;
		int scrollEnd = ScreenWidthEnd.intValue();
		//System.out.println("scrollEnd:"+scrollEnd);
		new TouchAction((PerformsTouchActions)device_driver)
		.press(PointOption.point(scrollStart,Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(scrollEnd,Anchor))
		.release().perform();

	}

	@SuppressWarnings("rawtypes")
	public static void cropSwipe() {
		FarmerHomePage farmerHomePage = new FarmerHomePage(device_driver);
		WebElement cropPanel = farmerHomePage.ViewAllCrops;
		org.openqa.selenium.Dimension cropPanelDimension= cropPanel.getSize();
		System.out.println("Crops Banner Swipe");
		//System.out.println("Dimensions Are: "+cropPanelDimension);
		int Anchor = cropPanel.getSize().getWidth() + 770;
		//System.out.println("Anchor:"+Anchor);
		Double ScreenWidthStart = cropPanelDimension.getWidth() * 0.9;
		int scrollStart = ScreenWidthStart.intValue();
		//System.out.println("scrollStart:"+scrollStart);
		Double ScreenWidthEnd = cropPanelDimension.getWidth() * 0.0;
		int scrollEnd = ScreenWidthEnd.intValue();
		//System.out.println("scrollEnd:"+scrollEnd);
		new TouchAction((PerformsTouchActions)device_driver)
		.press(PointOption.point(scrollStart,Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(scrollEnd,Anchor))
		.release().perform();

	}
	
	public static void scrollIntoView(String Text){
  
        String mySelector = "new UiSelector().text(\"" + Text + "\").instance(0)";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector + ");";
        device_driver.findElementByAndroidUIAutomator(command);

        /*((AndroidDriver<MobileElement>) AppDriver.getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
                */
        
       
        
      //String logout="Logout";
		//device_driver.findElementByAndroidUIAutomator(
		//		"new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().textContains(\""
		//				+ logout + "\").instance(0))");
    }

}
