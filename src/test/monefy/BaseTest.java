package test.monefy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static AppiumDriverLocalService service;
    
    @BeforeSuite
    public void globalSetup () throws IOException {
    	AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    	serviceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
    	serviceBuilder.withAppiumJS(new File("/usr/local/bin/appium"));
    	service = AppiumDriverLocalService.buildService(serviceBuilder);
    }

    @AfterSuite
    public void globalTearDown () {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl () {
        return service.getUrl();
    }
    
    public static void printMsg(String value) {
        System.out.println(value);
    }

    public static void typeAmountId(String value, AndroidDriver<AndroidElement> driver) {
        int aLength = value.length();
        int count = 0;
        String dot = ".";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.monefy.app.lite:id/textViewNote").sendKeys("Test Note for Automation");
        for (int i = 1; i <= aLength; i++) {
            String aSubstring = value.substring(count, i);
            if (aSubstring.equals(dot)) {
                aSubstring = "Dot";
            }

            AndroidElement input = driver.findElementById("com.monefy.app.lite:id/buttonKeyboard" + aSubstring);
            input.click();
            count++;
        }
    }

    public static BigDecimal str2BigDecimal(String num) {
        BigDecimal newValue;
        newValue = new BigDecimal(num).setScale(2, RoundingMode.DOWN);
        return newValue;
    }

    public static String removeChar(String str, String charValue) {
        int aLength = charValue.length();
        int count = 0;
        for (int i = 1; i <= aLength; i++) {
            String aSubstring = charValue.substring(count, i);
            str = str.replace(aSubstring, "");
            count++;
        }
        return str;
    }

    public static boolean areEqual(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.equals(secondNumber);
    }

    public static boolean isNumeric(String str) {
        try {
            BigDecimal newValue = new BigDecimal(str).setScale(2, RoundingMode.DOWN);
            printMsg("Income/Expense value is numeric!, value: " + newValue.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
