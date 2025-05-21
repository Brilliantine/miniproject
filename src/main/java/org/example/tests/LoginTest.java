package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.example.pages.LoginPage;

public class LoginTest {
    public static void main(String args[]){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        System.out.println("Заголовок страницы: "+loginPage.getTitle());
        driver.quit();
    }

}
