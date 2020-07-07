package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AmazonShopByCategory {
	public static void main(String args[]) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.amazon.mShop.android.shopping");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.windowshop.home.HomeLauncherActivity");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.xpath("//android.widget.GridLayout/android.widget.ImageView[1]")).click();
		driver.findElement(MobileBy.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
		driver.findElement(MobileBy.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon")).click();

		if (driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Explore all categories\")"))
				.size()!=0) {
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Explore all categories\")")).click();
		} else {
			driver.findElement(MobileBy.xpath(
					"//android.widget.TextView[@resource-id='in.amazon.mShop.android.shopping:id/drawer_item_title' and @text='Shop by Category']"))
					.click();
		}
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(MobileBy.xpath("//android.view.View[@text='Fire TV Stick']"))).click()
				.perform();
		// driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fire TV
		// Stick\")")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("UiSelector().text(\"Fire TV Stick with all-new Alexa Voice Remote\")"))
				.click();

		TouchAction action = new TouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		int width = d.width;
		int height = d.height;
		int x1 = width / 2;
		int y1 = 4 * height / 5;
		int x2 = width / 2;
		int y2 = height / 2;
		action.press(PointOption.point(x1, y1)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
				.moveTo(PointOption.point(x2, y2)).release().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Configuration: Fire TV Stick\")")).click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("UiSelector().text(\"Fire TV Stick + Echo Dot 6999.00 In stock.\")"))
				.click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"DONE\")")).click();
		driver.findElement(
				MobileBy.xpath("//android.view.View[@content-desc=\"ADD TO WISH LIST\"]/android.widget.TextView"))
				.click();

	}
}
