package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebTesting {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		/*cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		 * cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
		 * "C:\\Users\\MullaiChezhiyan\\Drivers\\chromedriver.exe");
		 * AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new
		 * URL("http://0.0.0.0.4723"), cap);
		 */
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"FILTER\")")).click();
		
		/*
		 * driver.get("http://google.com/");
		 * driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		 * driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		 */
	}

}
