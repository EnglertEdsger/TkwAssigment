package com.take.assigment.pageobjects;

import com.take.assigment.dataObjects.Adress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//div[contains(@class,'menucard__category-name')]")
   private WebElement menuCard;
    @FindBys({
            @FindBy(xpath = "//div[@class='meal__wrapper']")
    })
    private List<WebElement> menuItemsList;
    @FindBy(xpath = "//*[contains(@class,'button_form cartbutton-button')]")
    private  WebElement buttonOrder;
    @FindBy (xpath = "//button[contains(@class,'basket__order-button cartbutton-button')]")
    private WebElement basketButton;
    @FindBy(id = "iaddress")
    private WebElement adressInput;
    @FindBy(id = "ipostcode")
    private WebElement postcodeInput;
    @FindBy(id = "itown")
    private WebElement townInput;
    @FindBy(id = "isurname")
    private WebElement surnameInput;
    @FindBy(id = "iemail")
    private WebElement emailInput;
    @FindBy(id= "iphonenumber")
    private WebElement phoneNumberInput;
    @FindBy(id="ideliverytime")
    private WebElement dropDownDeliveryTime;
    @FindBy(id ="ipayswith")
   private WebElement dropDownIPay;
    @FindBy(xpath = "//span[contains(@class,'order-purchaseid')]")
   private WebElement purchaseId;
    @FindBy(xpath = "//*[contains(@class,'button_form cartbutton-button')]")
  private  WebElement orderAndPayButton;
    @FindBy(xpath = "//*[@id='ideliverytime']/option[@value='asap']")
   private WebElement optionAsap;

    public void addItem( int counter){
        for (int i = 0; i < counter; i++) {
            WebElement menuItem = menuItemsList.get(counter);
            clickIfWait(menuItem);
        }
    }

    public void clickOrder() {
        clickIfWait(basketButton);
      Assert.assertTrue(adressInput.isDisplayed());

    }
    public void fillAdressInfo(String adress, String postcode,String city, String name, String email, String phoneNumber){
        writeAndClear(adressInput,adress);
        writeAndClear(postcodeInput,postcode);
        writeAndClear(townInput,city);
        writeAndClear(surnameInput,name);
        writeAndClear(emailInput,email);
        writeAndClear(phoneNumberInput,phoneNumber);
      //  dropDownDeliveryTime.selectByVisibleText("11:00");



    }
public void pickDropDownsAdressInfoPage(String deliveryTime) {
    Select deliveryTimeSelect = new Select(dropDownDeliveryTime);
   // deliveryTimeSelect.selectByVisibleText(deliveryTime);
    boolean isAsap = optionAsap.isDisplayed();
    if (deliveryTime.equals("As soon as possible") && isAsap) {

        deliveryTimeSelect.selectByVisibleText(deliveryTime);
    }
            else {
        deliveryTimeSelect.selectByIndex(1);
        org.testng.Assert.fail("No asap option, selected differnt time, test marked as failed");

        System.out.println("No asap option, selected differnt time");

    }


}
public void pickDropDownIPay(int index){
    Select iPay = new Select(dropDownIPay);
    iPay.selectByIndex(index);
}

public String confirmationPage(){
    return purchaseId.getText();
    }

    public void clickOrderConfirm(){
      clickIfWait(orderAndPayButton);

    }



}
