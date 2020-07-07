package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonCreateAccount {
	public static void main(String args[]) throws MalformedURLException {

		String name = "My Name";
		String email = "myemail@gmail.com";
		String mobNum = "999999999";
		String password = "newPassword";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
				"C:\\Users\\MullaiChezhiyan\\Drivers\\chromedriver.exe");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://amazon.in");
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		driver.findElement(By.xpath("//div[@id='hmenu-customer-name']")).click();
		driver.findElement(By.xpath("//a[@id='register_accordion_header']")).click();
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys(mobNum);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		driver.hideKeyboard();

		String alert = driver.findElement(By.xpath("//*[@id='auth-error-message-box']")).getText();
		System.out.println(alert);
		String Expected = "Your provided Email " + email + " has already been used. Please use another Email address.";
		String messageSupplier = "Expected Fail";
		Assert.doesNotContain(Expected, alert, messageSupplier);

	}
}
