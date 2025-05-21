package org.example.tests;

import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    public static void main (String args[]){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.enterUsername("testovtestov");
        loginPage.enterPassword("Qwerty123");
        loginPage.clickLogin();

        System.out.println("Заголовок страницы:" + loginPage.getTitle());

        driver.quit();
    }

}
