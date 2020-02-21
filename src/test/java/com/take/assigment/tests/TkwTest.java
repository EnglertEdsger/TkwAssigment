package com.take.assigment.tests;
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


public class TkwTest {


    private WebDriver driver;

    private TkwSearchPage TkwSearchPage;
    private OrderPage orderPage;
    private Adress adress;

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
        addMenuItems(2);
        clickOrderStep();
        fillAdress(  adress.getAdress(),adress.getPostcode(),adress.getCity(),adress.getName(),adress.getEmail(),adress.getPhoneNumber());
        pickDropDownsAdressInfo("As soon as possible");
        amountToPay(1);
        clickSubmit();
        confirmationPage(orderPage.confirmationPage());
    }

    @Test
    public void orderLessComplexCase() {
        openPage();
        searchFor8888("8888");
        verifyRestaurantsList();
        selectRestaurant();
        addMenuItems(1);
        clickOrderStep();
        fillAdress(  adress.getAdress(),adress.getPostcode(),adress.getCity(),adress.getName(),adress.getEmail(),adress.getPhoneNumber());
        pickDropDownsAdressInfo("As soon as possible");
        clickSubmit();
        confirmationPage(orderPage.confirmationPage());
    }



    @Step("Open the main page")
    private void openPage() {
        System.out.println("opening page");
        TkwSearchPage.openURL();
    }
    @Step("Search for the adress : {0}")
    private void searchFor8888(String postcode){
        System.out.println("search for 8888");
        TkwSearchPage.searchForAdress(postcode);

    }
    @Step("Verify that the list of restaurants is not empty")
    private void verifyRestaurantsList(){
        TkwSearchPage.foundRestaurantsVerification();
    }
    @Step("Select a restaurant from the list and check if menu displayed")
    private void selectRestaurant(){
        TkwSearchPage.selectRestaurant(3);
    }
    @Step("Add items to the basket")
    private void addMenuItems(int itemsNumber){
        orderPage.addItem(itemsNumber);
    }
    @Step("Click order and check if adress page is displayed")
    private void clickOrderStep(){
        orderPage.clickOrder();
    }
    @Step("Fill delivery informations, Adress: {0} Postcode: {1} City: {2} Name: {3} Email: {4} Phone number {5}")
    private void fillAdress(String adress, String postcode,String city, String name, String email, String phoneNumber){
        orderPage.fillAdressInfo(adress,postcode,city,name,email,phoneNumber);
    }
    @Step("Pick delivery time : {0}")
    private void pickDropDownsAdressInfo(String deliveryTime){
        orderPage.pickDropDownsAdressInfoPage(deliveryTime);
    }
    @Step("Select amount to pay")
    private void amountToPay(int amountToPay)
    {
        orderPage.pickDropDownIPay(amountToPay);
    }
    @Step("Click submit and order")
    private void clickSubmit(){
        orderPage.clickOrderConfirm();
    }
    @Step("Check submit page, refference numer is [0]")
    private void confirmationPage(String id){

    }
    @AfterTest
    private void tearDown(){
        driver.quit();
    }
    @AfterSuite
    private void generateRaport(){
        TkwSearchPage.allureReport();

    }

    }





