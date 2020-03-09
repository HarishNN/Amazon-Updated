package AndroidAutomation.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartApplication {

		private static AndroidDriver driver;
		public static void main(String[] args) throws MalformedURLException, InterruptedException {


			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "A50");
			capabilities.setCapability(MobileCapabilityType.UDID,"RZ8M91SL5TF");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			
	//		capabilities.setCapability(MobileCapabilityType.APP, "/Users/anandyadav/Desktop/Appium/Amazon Shopping.apk");
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		capabilities.setCapability("noReset", "true");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);
			driver.findElementByXPath("//android.widget.ImageView[@content-desc='Navigation panel, button, double tap to open side panel']").click();
			Thread.sleep(5000);
		    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Language A/क\"));");
	
			Thread.sleep(2000);
			driver.findElementByXPath("//*[@text='Settings']").click();
			Thread.sleep(2000);
			driver.findElementByXpath("//a[@id='icp-touch-link-country']").click();
			Thread.sleep(2000);
			
			WebElement ele =driver.findElement(By.className("a-native-dropdown"));
			Select dropdown = new Select(ele);
			dropdown.selectByVisibleText("Australia");
	
			driver.quit();

	}

}