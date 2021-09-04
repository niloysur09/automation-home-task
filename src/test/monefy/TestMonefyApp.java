package test.monefy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.monefy.screens.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class TestMonefyApp extends BaseTest {
    private AndroidDriver<AndroidElement> driver;
    
    @BeforeClass
    public void setUp() throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        System.out.print(classpathRoot);
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir.getCanonicalPath(), "com.monefy.app.lite_2021-08-21.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver<AndroidElement>(getServiceUrl(), capabilities);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 0)
    @Parameters ({"income", "incomeCategory"})
    public void addNewIncome(String income, String incomeCategory) {
        if (!isNumeric(income)) {
            printMsg("Income value is not numeric!, please check input: ");
        }
        else {
        	//Tap on income button in home screen
        	Home home = new Home(driver);
            home.incomeButton.click();
            
            //type the amount
            typeAmountId(income, driver);
            
            //add income
            NewIncomes newIncomes = new NewIncomes(driver);
            newIncomes.categoryButton.click();
            
            //select income category
            CategoryIncomes.selectIncomeCategory(driver , incomeCategory);
        }        
    }
    

	@Test(priority = 1)
    @Parameters ({"expense1", "expenseCategory1"})
    public void addNewExpenseFromHomeScreen(String expense1, String expenseCategory1) {
		if (!isNumeric(expense1)) {
            printMsg("Expense1 value is not numeric!, please check input: ");
        }
		else {
			//select expense category from home screen shortcuts
			Home.selectExpenseCategoryIcon(driver, expenseCategory1);
	        
			//type the amount
	        typeAmountId(expense1, driver);
	        
	        //add expense
	        NewExpenses newExpenses = new NewExpenses(driver);
	        newExpenses.categoryButton.click();
		} 
    }
	
	@Test(priority = 2)
    @Parameters ({"expense2", "expenseCategory2"})
    public void addNewExpenseFromExpenseButton(String expense2, String expenseCategory2) {
		if (!isNumeric(expense2)) {
            printMsg("Expense2 value is not numeric!, please check input: ");
        }
		else {
			//tap on expense button in home screen
			Home home = new Home(driver);
	        home.expenseButton.click();
	        
	        //type the amount
	        typeAmountId(expense2, driver);
	        
	        //add expense
	        NewExpenses newExpenses = new NewExpenses(driver);
	        newExpenses.categoryButton.click();
	        
	        //select expense category
	        CategoryExpenses.selectExpenseCategory(driver, expenseCategory2);
		}
    }
    
    @Test(priority = 3)
    public void validateBalanceCalculation() {
    	/* Validating balance against income - expense */
        
    	//Getting balance
        new Home(driver).balanceButton.click();
        Balances balances = new Balances(driver);
        String balance = balances.balanceButton.getText();
        balance = removeChar(balance, "Balance $,");
        BigDecimal newBalance = str2BigDecimal(balance);

        //Close the right Menu panel
        Home home = new Home(driver);
        home.rightPanelButton.click();
        
        //Back to main screen
        balances.balanceButton.click();

        //Validating total incomes minus total expenses calculation
        BigDecimal validation = Balances.incomesMinusExpenses(balances.amount.size(), balances.category, balances.amount);
        printMsg("Calculated Incomes minus Expenses is: " + validation + " and the Balance dislayed in app is: " + newBalance);

        if (areEqual(validation, newBalance)) {
            printMsg("Successful calculation!");
        } else {
            printMsg("Failed calculation!");
        }
    }
    
    @Test(priority = 4)
    @Parameters ({"income", "expense1", "expense2"})
    public void validateIncomeAndExpenseHomeScreen(String income, String expense1, String expense2) {
    	/* Validating total income displayed in home screen VS total income input */
    	
    	Home home = new Home(driver);
    	
    	String incomeApp = home.incomeAmount.getText();
    	incomeApp = removeChar(incomeApp, "$,");
    	if (incomeApp.equals(income)) {
    		printMsg("Home screen shows correct Income value!, Total Income from App: " + incomeApp + " Total Income value caclulated: " + income);
    	}
    	else {
    		printMsg("Home screen shows correct Income value!, Total Income from App: " + incomeApp + " Total Income value caclulated: " + income);
    	}
    	
    	/* Validating total expense displayed in home screen VS total expense input */
    	
    	String expenseApp = home.expenseAmount.getText();
    	expenseApp = removeChar(expenseApp, "$,");
    	BigDecimal expDecimal1 = str2BigDecimal(expense1);
    	BigDecimal expDecimal2 = str2BigDecimal(expense2);
    	BigDecimal totalExpense = expDecimal1.add(expDecimal2);
    	if (expenseApp.equals(totalExpense.toString())) {
    		printMsg("Home screen shows correct Expense value!, Total Expense from App: " + expenseApp + " Total Expence value caclulated: " + totalExpense.toString());
    	}
    	else {
    		printMsg("Home screen shows correct Expense value!, Total Expense from App: " + expenseApp + " Total Expence value caclulated: " + totalExpense.toString());
    	}
    }

}

