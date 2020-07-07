package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonTodayDeals {
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
		driver.findElement(MobileBy.id("in.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon")).click();
		
	}
}
