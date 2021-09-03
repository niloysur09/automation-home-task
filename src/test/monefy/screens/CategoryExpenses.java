package test.monefy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CategoryExpenses {
    public static AndroidElement bills;
    public static AndroidElement car;
    public static AndroidElement clothes;
    public static AndroidElement communications;
    public static AndroidElement eating;
    public static AndroidElement entertainment;
    public static AndroidElement food;
    public static AndroidElement gifts;
    public static AndroidElement health;
    public static AndroidElement house;
    public static AndroidElement pets;
    public static AndroidElement sports;
    public static AndroidElement taxi;
    public static AndroidElement toiletry;
    public static AndroidElement transport;

    public static void selectExpenseCategory(AndroidDriver<AndroidElement> driver, String expenseCategory){
    	switch (expenseCategory) {
		case "bills":
			bills=  driver.findElementByXPath("//*[@text='Bills']");
			bills.click();
			break;
		case "car":
			car=  driver.findElementByXPath("//*[@text='Car']");
			car.click();
			break;
		case "clothes":
			clothes=  driver.findElementByXPath("//*[@text='Clothes']");
			clothes.click();
			break;
		case "communications":
			communications =  driver.findElementByXPath("//*[@text='Communications']");
			communications.click();
			break;
		case "eating":
			 eating =  driver.findElementByXPath("//*[@text='Eating out']");
			 eating.click();
			break;
		case "entertainment":
			entertainment = driver.findElementByXPath("//*[@text='Entertainment']");
			entertainment.click();
			break;
		case "food":
			food =  driver.findElementByXPath("//*[@text='Food']");
			food.click();
			break;
		case "gifts":
			 gifts =  driver.findElementByXPath("//*[@text='Gifts']");
			 gifts.click();
			break;
		case "health":
			health =  driver.findElementByXPath("//*[@text='Health']");
			health.click();
			break;
		case "house":
			house =  driver.findElementByXPath("//*[@text='House']");
			house.click();
			break;
		case "pets":
			pets =  driver.findElementByXPath("//*[@text='Pets']");
			pets.click();
			break;
		case "sports":
			sports =  driver.findElementByXPath("//*[@text='Sports']");
			sports.click();
			break;
		case "taxi":
			taxi =  driver.findElementByXPath("//*[@text='Taxi']");
			taxi.click();
			break;
		case "toiletry":
			toiletry =  driver.findElementByXPath("//*[@text='Toiletry']");
			toiletry.click();
			break;
		case "transport":
			transport =  driver.findElementByXPath("//*[@text='Transport']");
			transport.click();
			break;
    	}
    }

}
