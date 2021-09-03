package test.monefy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CategoryIncomes {
    public static AndroidElement deposits;
    public static AndroidElement salary;
    public static AndroidElement savings;

    public static void selectIncomeCategory(AndroidDriver<AndroidElement> driver, String incomeCategory){
    	switch (incomeCategory) {
		case "deposits":
			deposits = driver.findElementByXPath("//*[@text='Deposits']");
			deposits.click();
			break;
		case "salary":
			salary = driver.findElementByXPath("//*[@text='Salary']");
			salary.click();
			break;
		case "savings":
			savings = driver.findElementByXPath("//*[@text='Savings']");
			savings.click();
			break;
    	}
    }
}
