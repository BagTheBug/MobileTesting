package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Udemy {
	public static void main(String args[]) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.activity.SplashActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://localhost:4723/wd/hub"), cap);
		driver.findElement(MobileBy.id("com.udemy.android:id/signin_button")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in with email\")")).click();
		driver.findElement(MobileBy.id("com.udemy.android:id/email_edit")).sendKeys("mullaimc@gmail.com");
		driver.findElement(MobileBy.id("com.udemy.android:id/nextBtn")).click();
		driver.findElement(MobileBy.id("com.udemy.android:id/password")).sendKeys("Mullai@1994");
		driver.findElement(MobileBy.id("com.udemy.android:id/signin_button")).click();
		driver.findElement(MobileBy.AccessibilityId("Account tab")).click();

		Dimension d = driver.manage().window().getSize();
		int width = d.width;
		int height = d.height;
		int x1 = width / 2;
		int y1 = 4 * height / 2;
		int x2 = width / 2;
		int y2 = height / 2;

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		while (driver.findElements(MobileBy.id("com.udemy.android:id/sign_out")).size() == 0) {
			driver.executeScript("moblie:shell", ImmutableMap.of("command", "input swipe" + x1 + y1 + x2 + y2));

		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("com.udemy.android:id/sign_out")).click();
		driver.findElement(MobileBy.id("android:id/button1")).click();
	}
}
