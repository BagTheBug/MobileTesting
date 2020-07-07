package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class UdemyCourse {
	public static void main(String args[]) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.CombinedDeepLinkActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Browse\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search all courses\")"))
				.sendKeys("Selenium");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BUTTON_SELECT));
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"selenium\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"UiSelector().text(\"Selenium WebDriver with Java -Basics to Advanced+Frameworks\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"SIGN IN\")")).click();
	}

}
