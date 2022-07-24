package com.learning.login;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchCalculator {

    WebDriver driver;

    @BeforeClass
    public void testSetUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "narzo 50i");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "0412525R50001A0F");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new RemoteWebDriver(url, desiredCapabilities);
        Thread.sleep(5000);
    }

    @Test
    public void addNumberTest() {
        //locate the Text on the calculator by using By.name()
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        //locate the edit box of the calculator by using By.tagName()
        WebElement results = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        //Check the calculated value on the edit box
        assert results.getText().equals("3") : "Actual value is : " + results.getText() + " did not match with expected value: 3";
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}

