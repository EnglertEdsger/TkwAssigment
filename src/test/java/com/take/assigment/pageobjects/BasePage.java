package com.take.assigment.pageobjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.take.assigment.dataObjects.Adress;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BasePage implements ITestListener {
//    BasePage(){
//        this.driver = driver;
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//
//    }

    final int TIMEOUT =3000;
     WebDriver driver;

     void clickIfWait(WebElement element) {
        element.click();

    }
     void clickIfVisible(WebElement element){
        boolean isDssplayed = element.isDisplayed();
    if (isDssplayed = true) { element.click();}
    }

    protected void write(WebElement element, String text) {
        element.sendKeys(text);
    }
     void writeAndClear(WebElement element, String text)
{
    element.clear();
    element.sendKeys(text);
}
    public void allureReport(){

        String command = "cmd.exe /c allure serve C:\\School\\TkwAssigment\\allure-results";
        String command1 = "echo %PATH%";

        try {
            Process p = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Adress testDataMapper(){
        ObjectMapper mapper = new ObjectMapper();
        Adress adressObject = null;

        try {


            File adressFile = new File("adressTestData.json");
            System.out.println(adressFile.getAbsolutePath());

            adressObject = mapper.readValue( adressFile, Adress.class);

            System.out.println(adressObject);

            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(adressObject);
            System.out.println(prettyStaff1);
            System.out.println(adressObject.getEmail());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return adressObject;
    }
    @Attachment
    private String logOutput(List<String> outputList) {
        StringBuilder output = new StringBuilder();
        for (String o : outputList)
            output.append(o).append("<br/>");
        return output.toString();
    }


    public void onTestSuccess(ITestResult testResult) {
        logOutput(Reporter.getOutput(testResult));
        onTestSuccess(testResult);
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void deletePostCodeCookies(){
        {

            driver.manage().deleteCookieNamed("postcode");
        }
    }
}
