package assignmentjava;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class TechnicalAssignment3 {

    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws Exception {
        // Set the desired capabilities for the Android device
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554"); // Device ID or name
        capabilities.setCapability("platformVersion", "10.0"); // Android version
        capabilities.setCapability("appPackage", "com.example.app"); // App package name
        capabilities.setCapability("appActivity", "com.example.app.MainActivity"); // Main activity
        capabilities.setCapability("noReset", true); // Don't reset app state
        capabilities.setCapability("fullContextList", true);

        // Initialize the Appium driver (Android)
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testMobileAppFlow() {
        // Example: Find an element and perform an action (like click a button)
        MobileElement element = driver.findElement(By.id("com.example.app:id/button1"));
        element.click();

        // Wait for the next screen to appear
        MobileElement nextElement = driver.findElement(By.id("com.example.app:id/textView1"));
        System.out.println("Text on next screen: " + nextElement.getText());

        // Perform additional actions as required
    }

    // Tear down the driver after the tests
    @AfterClass
    public void tearDown() {
        Object driver;
		if (driver != null) {
            driver.wait();
        }
    }