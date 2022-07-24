package com.learning.login;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ScrollingTest {

    AndroidDriver<WebElement> androidDriver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //app-pachakage app-activity device UDID AUTOMATION_NAME PLATFORM_VERSION PLATFORM_NAME
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.truecaller");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.truecaller.ui.TruecallerInit");

        // DialtactsContactsEntryActivity

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"narzo 50i");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"0412525R50001A0F");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert url != null;
        androidDriver = new AndroidDriver<>(url,desiredCapabilities);
        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void firstTest(){
/**
 * tap on the view
 * scroll the view layout
 */
        String elementText = "WebView";
   androidDriver.findElementsById("android:id/text1").get(10).click();
        AndroidElement listOfElement = (AndroidElement) androidDriver.findElementsById("android:id/text1");
        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().text(\""+elementText+"\""));

        listOfElement.click();
    }

    @Test
    public void trueCallerTest() throws InterruptedException {
/**
 * tap on the view
 * scroll the view layout
 */
        String elementText = "WebView";
        androidDriver.findElementById("com.truecaller:id/nextButton").click();
        androidDriver.findElementsByClassName("android.widget.LinearLayout").get(1).click();
        androidDriver.findElementById("android:id/button1").click();
//        androidDriver.findElementById("android:id/button1").click();
        Thread.sleep(5000);
        androidDriver.findElementById("com.truecaller:id/button_skip").click();
        androidDriver.findElementById("android:id/button2").click();
        androidDriver.findElementByClassName("android.widget.ImageButton").click();
        androidDriver.findElementByName("DISMISS").click();

        //android:id/button2
        //android.widget.ImageButton class
        //DISMISS

        AndroidElement listOfElement = (AndroidElement) androidDriver.findElementsById("android:id/text1");
        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().text(\""+elementText+"\""));

        listOfElement.click();
    }

    @AfterClass
    public void tearDown(){
    androidDriver.quit();;
    }
}
