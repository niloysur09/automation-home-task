package test.monefy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Balances {
    public AndroidElement balanceButton;
    public AndroidElement incomeButton;
    public AndroidElement expenseButton;
    public List<AndroidElement> amount;
    public List<AndroidElement> category;

    public Balances(AndroidDriver<AndroidElement> driver){
        balanceButton = driver.findElementById("com.monefy.app.lite:id/balance_amount");
        amount = driver.findElementsById("com.monefy.app.lite:id/textViewWholeAmount");
        category = driver.findElementsById("com.monefy.app.lite:id/textViewCategoryName");
    }

    public static BigDecimal incomesMinusExpenses(int amountListSize, List<AndroidElement> categoryElement, List<AndroidElement> amountElement) {
        BigDecimal totalIncome = new BigDecimal(0).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal totalExpense = new BigDecimal(0).setScale(2, RoundingMode.HALF_DOWN);
        for (int i = 0; i < amountListSize; i++) {
            String category = categoryElement.get(i).getText();
            String amount = amountElement.get(i).getText().replace("$", "");
            amount = amount.replace(",", "");
            if (category.equals("Deposits") || category.equals("Salary") ||category.equals("Savings")){
                totalIncome = totalIncome.add(new BigDecimal(amount));
            }else{
                totalExpense = totalExpense.add(new BigDecimal(amount));
            }
        }
        BigDecimal result;
        result = new BigDecimal(String.valueOf(totalIncome)).subtract(totalExpense);
        return result;
    }

}

