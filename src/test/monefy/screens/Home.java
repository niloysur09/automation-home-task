package test.monefy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Home {

    public AndroidElement incomeButton;
    public AndroidElement expenseButton;
    public AndroidElement balanceButton;
    public AndroidElement rightPanelButton;
    public AndroidElement incomeAmount;
    public AndroidElement expenseAmount;
    public static AndroidElement eating;
    public static AndroidElement house;
    public static AndroidElement food;
    public static AndroidElement car;
    public static AndroidElement toiletry;
    public static AndroidElement sports;
    public static AndroidElement health;
    public static AndroidElement communications;
    public static AndroidElement entertainment;
    public static AndroidElement clothes;
    public static AndroidElement taxi;
    public static AndroidElement transport;

    public Home(AndroidDriver<AndroidElement> driver){
        incomeButton = driver.findElementById("com.monefy.app.lite:id/income_button_title");
        expenseButton = driver.findElementById("com.monefy.app.lite:id/expense_button_title");
        balanceButton = driver.findElementById("com.monefy.app.lite:id/balance_amount");
        rightPanelButton = driver.findElementById("com.monefy.app.lite:id/overflow");
        incomeAmount = driver.findElementById("com.monefy.app.lite:id/income_amount_text");
        expenseAmount = driver.findElementById("com.monefy.app.lite:id/expense_amount_text");
    }
    
    public static void selectExpenseCategoryIcon(AndroidDriver<AndroidElement> driver, String expenseCategory){
    	switch (expenseCategory) {
    	case "food":
			food =  driver.findElementByXPath("//android.widget.ImageView[1]");
			food.click();
			break;
    	case "car":
			car=  driver.findElementByXPath("//android.widget.ImageView[2]");
			car.click();
			break;
		case "transport":
			transport =  driver.findElementByXPath("//android.widget.ImageView[3]");
			transport.click();
			break;
		case "entertainment":
			entertainment = driver.findElementByXPath("//android.widget.ImageView[4]");
			entertainment.click();
			break;
		case "house":
			house =  driver.findElementByXPath("//android.widget.ImageView[5]");
			house.click();
			break;
		case "taxi":
			taxi =  driver.findElementByXPath("//android.widget.ImageView[6]");
			taxi.click();
			break;
		case "eating":
			 eating =  driver.findElementByXPath("//android.widget.ImageView[7]");
			 eating.click();
			break;
		case "clothes":
			clothes=  driver.findElementByXPath("//android.widget.ImageView[8]");
			clothes.click();
			break;
		case "toiletry":
			toiletry =  driver.findElementByXPath("//android.widget.ImageView[9]");
			toiletry.click();
			break;
		case "sports":
			sports =  driver.findElementByXPath("//android.widget.ImageView[10]");
			sports.click();
			break;
		case "health":
			health =  driver.findElementByXPath("//android.widget.ImageView[11]");
			health.click();
			break;
		case "communications":
			communications =  driver.findElementByXPath("//android.widget.ImageView[12]");
			communications.click();
			break;
    	}
    }
}
