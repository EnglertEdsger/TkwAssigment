package com.take.assigment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TkwSearchPage extends BasePage {
    WebDriverWait wait;
String tkwStart = "https://www.thuisbezorgd.nl/en/";

       // private WebDriver driver;



    @FindBy(id = "imysearchstring")
        WebElement searchBox;

    @FindBy (xpath = "//span[normalize-space()='8888 Alpha']")
        WebElement alphaAdres;
    @FindBy(xpath = "//h1[normalize-space()='Time to order food']")
        WebElement timeToOrderBanner;
    @FindBy (id = "submit_deliveryarea")
        WebElement searchButton;
    @FindBys({
            @FindBy(xpath = "//div[contains(@id,'irestaurant')]")
    })
    private List<WebElement> restaurantsList;
    @FindBy (xpath = "//div[contains(@class,'menucard__category-name')]")
    WebElement menuCard;

    @FindBy(xpath = "//div[contains(@class,'checkout-orderbutton-btn')]")
    WebElement submitButton;
//   //div[normalize-space()=contains(@class,'meal-container js-meal-container js-meal-search')]

    public TkwSearchPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
            WebDriverWait wait = new WebDriverWait(driver, 5);
        }

        public void openURL(){
            driver.get(tkwStart);

        }

        public void searchForAdress(String searchTerm) {
            System.out.println("Type in 8888");
            write(searchBox,searchTerm);
            System.out.println("Click outside of a search box");
            clickIfWait(timeToOrderBanner);
            System.out.println("Click the search button");
            clickIfWait(searchButton);
            System.out.println("Click on 8888 Alpha adress");
            clickIfWait(alphaAdres);

        }
        public void foundRestaurantsVerification(){
        System.out.println("Check if there more than one restuaran on the list");
            Assert.assertNotEquals(restaurantsList.size(),0);
        }
        public void selectRestaurant(int restaurantOnList){
        WebElement restaurant = restaurantsList.get(restaurantOnList);
        clickIfWait(restaurant);
        Assert.assertTrue(menuCard.isDisplayed());
        }
        public void clickSubmit(){
        clickIfWait(submitButton);
        }
        public void clickSearch(){
            clickIfWait(searchButton);
        }
    }

