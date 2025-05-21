package org.example.tests;

import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LoginTest {
    public static void main (String args[]){
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("network.cookie.cookieBehavior",0);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        System.out.println("Заголовок страницы:" + loginPage.getTitle());

        driver.quit();
    }

}
