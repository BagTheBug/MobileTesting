package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class GoogleSearch {
	/**
	 * Google search from native app
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String args[]) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.chromium.chrome.browser.document.ChromeLauncherActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://localhost:4723/wd/hub"), cap);
		driver.findElement(MobileBy.id("com.android.chrome:id/search_box_text")).sendKeys("Appium");
		driver.longPressKey(new KeyEvent(AndroidKey.ENTER));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
