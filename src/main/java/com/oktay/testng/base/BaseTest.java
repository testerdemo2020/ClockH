package com.oktay.testng.base;

import com.oktay.testng.constants.General_Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/*
 *  Created 5.11.2021
 */
public class BaseTest implements General_Constants {

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty(MSEDGE_DRIVER_NAME, MSEDGE_DRIVER_PATH);
            driver = new FirefoxDriver();
        }

        driver.manage().window().fullscreen();
        driver.navigate().to(URL_FLIPKART);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    	driver.quit();
    }
}
