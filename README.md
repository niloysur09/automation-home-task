# automation-home-task

## Introduction

This is the "Test Automation" for "Monefy" mobile app, which contains a set of automated steps based on Android application. This automation test is built using Appium and using java as a language.

## Test cases identified for automation (prioritized)

1. Add Income by tapping on Income button present in home screen

2. Add Expense from the shortcut icons present in home screen

3. Add Expense by tapping on Income button present in home screen

4. Verify the Balance calculation displayed within the app is correct or not

5. Verify the total amount displayed for Income and Expense in home screen is correct or not

## Details on the Automation Coverage

This automation is done using "TestNG" framework, so all the user inputs are configurable from outside (fully Parameterized, no need to open code). Test cases are contained under the "TestMonefyApp.java" with "@Test" annotations and there are other java classes as well for different screens. There is no need to create more test cases as these 5 test cases can be run for any "Category" types which are avaialbe within the app. Only need to input the Income and Expense amounts and Category name and thats all. For Exmaple, the current "testng.xml" file has 2 different sets of inputs. So it can be said that the test cases can cover te above test scenarios for any number or categories, "Just input and Run.."

More over as this Automation tests using Appium and TestNG so it could be run in parallel/in Threads. In thats case at the same time it can be run in parallel for different Categories, that give a good amount of Coverage (all categories of income and expense) and also the excution time will be vry less (compared to if create income and expense using loops via code). So, key points are - 

* High Flexibility
* Great Coverage
* Faster Execution time

List of Category names presnet in the app and also can input while running test from testng.xml (just input the name from here thats all) - 

 Expense : 
 
 * food
 * car
 * transport
 * entertainment
 * house
 * taxi
 * eating
 * clothes
 * toiletry
 * sports
 * health
 * communications
 * bills
 * pets
 * gifts
 
 Income : 
 * deposits
 * salary
 * savings

## How to set up

1. Install Appium - Either Appium desktop app or install using npm comment, more details can be found here: https://appium.io/docs/en/about-appium/getting-started/?lang=en
2. Install any preferred IDE, I have used Eclipse here
3. Java should be installed in the system
4. As TestNG framework is used here so need to insatll it. It can be installed either from Eclipse Marketplance or manually from https://testng.org/doc/download.html
5. Add the JAR files present in the "lib" folder to System Library
6. Required Android studio to be installed as well

## How to Run

1. Clone the Project
2. Start the appium server using default host and port
3. Open Android studio -> AVD manager -> select a device where the test will be run
4. Configure the "textng.xml" with desired inputs
5. Open the project in IDE (Eclipse) and run the "testng.xml" file as a "TestNG Suite" OR alternatively run "testng.xml" file from command prompt/terminal
