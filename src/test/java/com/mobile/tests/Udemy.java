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
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.CombinedDeepLinkActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"New here? Create an account\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign up with email\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Name\")")).sendKeys("Mullai");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email\")")).sendKeys("mullaimc@gmail.com");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password (8+ characters)\")"))
				.sendKeys("Mullai@1994");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Create account\")")).click();
	}
}
