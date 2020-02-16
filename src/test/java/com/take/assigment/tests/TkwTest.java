package com.take.assigment.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.take.assigment.dataObjects.Adress;
import com.take.assigment.driverutil.DriverFactory;
import com.take.assigment.pageobjects.OrderPage;
import com.take.assigment.pageobjects.TkwSearchPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TkwTest {


    private WebDriver driver;

    TkwSearchPage TkwSearchPage;
    OrderPage orderPage;
    Adress adress;

    @BeforeTest
    public void setUp(){
        driver = DriverFactory.getBrowser();
        TkwSearchPage = new TkwSearchPage(driver);
        orderPage = new OrderPage(driver);
        adress = orderPage.testDataMapper();


    }


    @Test
    public void orderComplexCase() {


        openPage();
        searchFor8888("8888");
        verifyRestaurantsList();
        selectRestaurant();
        addMenuItems();
        clickOrderStep();
        fillAdress(  adress.getAdress(),adress.getPostcode(),adress.getCity(),adress.getName(),adress.getEmail(),adress.getPhoneNumber());
        //"As soon as possible"
        pickDropDownsAdressInfo("As soon as possible");
        amountToPay(1);
        clickSubmit();
        confirmationPage(orderPage.confirmationPage());
    }

    @Test
    public void orderLessComplexCase() {


        openPage();
        searchFor8888("8888");
        clickShow();
        verifyRestaurantsList();
        selectRestaurant();
        addMenuItems();
        clickOrderStep();
        fillAdress(  adress.getAdress(),adress.getPostcode(),adress.getCity(),adress.getName(),adress.getEmail(),adress.getPhoneNumber());
        //"As soon as possible"
        pickDropDownsAdressInfo("As soon as possible");
       // amountToPay(1);
        clickSubmit();
        confirmationPage(orderPage.confirmationPage());
    }

//    @Test
//    private void searchForAdress() throws InterruptedException {
//        searchFor8888();
//    }
//    @Test
//    private void verifyFoundRestaurants(){
//        verifyRestaurantsList();
//        selectRestaurant();
//    }


    @Step("Open the main page")
    private void openPage() {
        System.out.println("opening page");
        TkwSearchPage.openURL();
    }
    @Step("Search for the adress : {0}")
    public void searchFor8888(String postcode){
        System.out.println("search for 8888");
        TkwSearchPage.searchForAdress(postcode);

    }
    @Step("Verify that the list of restaurants is not empty")
    public void verifyRestaurantsList(){
        TkwSearchPage.foundRestaurantsVerification();
    }
    @Step("Select a restaurant from the list and check if menu displayed")
    public void selectRestaurant(){
        TkwSearchPage.selectRestaurant(3);
    }
    @Step("Add items to the basket")
    public void addMenuItems(){
        orderPage.addItem();
    }
    @Step("Click order and check if adress page is displayed")
    public void clickOrderStep(){
        orderPage.clickOrder();
    }
    @Step("Fill delivery informations, Adress: {0} Postcode: {1} City: {2} Name: {3} Email: {4} Phone number {5}")
    public void fillAdress(String adress, String postcode,String city, String name, String email, String phoneNumber){
        orderPage.fillAdressInfo(adress,postcode,city,name,email,phoneNumber);
    }
    @Step("Pick delivery time : {0}")
    public void pickDropDownsAdressInfo(String deliveryTime){
        orderPage.pickDropDownsAdressInfoPage(deliveryTime);
    }
    @Step("Select amount to pay")
    public void amountToPay(int amountToPay)
    {
        orderPage.pickDropDownIPay(amountToPay);
    }
    @Step("Click submit and order")
    public void clickSubmit(){
        orderPage.clickOrderConfirm();
    }
    @Step("Check submit page, refference numer is [0]")
    public void confirmationPage(String id){

    }
    @Step
    public void clickShow(){
        TkwSearchPage.clickSearch();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @AfterSuite
    public void generateRaport(){
        TkwSearchPage.allureReport();

    }


}
