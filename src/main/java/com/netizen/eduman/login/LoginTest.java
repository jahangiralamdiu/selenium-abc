/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netizen.eduman.login;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author jahangir
 */
public class LoginTest {

    public static void main(String[] args) {
        LoginTest loginTest = new LoginTest();
        WebDriver driver = loginTest.getChromeWebDriver();
        loginTest.testTitle(driver);
        loginTest.testLogin(driver);
        driver.close();
        System.exit(0);
    }

    private void testTitle(WebDriver driver) {
        String expectedTitle = "Netizen IT Limited";
        // get the actual value of the title
        String actualTitle = driver.getTitle();
        System.out.println("Title :" + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    private void testLogin(WebDriver driver) {
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.className("btn-sign-in"));
        userName.sendKeys("01923774442");
        password.sendKeys("123456");
        submit.click();
    }

    private WebDriver getChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/jahangir/Documents/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://edumanbd.com:8443/em/login.do");
        return driver;
    }
}
