package com.take.assigment.driverutil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getBrowser() {

        WebDriver driver = null;
        WebDriver driver2 = null;
        String browser = System.getProperty("browser", DriverType.CHROME.toString()).toUpperCase();
        //String browser2 = System.getProperty("browser", DriverType.FIREFOX.toString()).toUpperCase();

        DriverType driverType = DriverType.valueOf(browser);
        boolean headless = Boolean.parseBoolean(System.getProperty("test.headless"));

        //DriverType driverType2 = DriverType.valueOf(browser2);
        //mvn test "-Dtest.headless=false"

        switch (driverType) {
            case CHROMEFF:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                WebDriverManager.firefoxdriver().setup();
          //      driver2 = new FirefoxDriver();

                break;
            case CHROME:
                final ChromeOptions chromeOptions = new ChromeOptions();

                WebDriverManager.chromedriver().setup();
                if (headless == true){
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                     driver = new ChromeDriver(options);
                }
                else

                 driver = new ChromeDriver();


                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                if (headless == true){
                    FirefoxOptions options = new FirefoxOptions();
                    options.setHeadless(true);
                    driver = new FirefoxDriver(options);
                }
                else
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }
}
