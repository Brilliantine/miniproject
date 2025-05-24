package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.example.pages.LinksPage;
import java.util.*;

public class LinksTest {
    public static void main(String[] args){
        // 1. Настройка драйвера
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LinksPage linksPage = new LinksPage(driver);
        linksPage.open();
        linksPage.searchLinks();
        int countLinks = linksPage.countLinks();
        System.out.println("***Всего ссылок: "+countLinks);
        linksPage.uniqueLinks();
        System.out.println("***Внешние ссылки:");
        linksPage.printExternalLinks();
        System.out.println("***Внутренние ссылки: ");
        linksPage.printInternalLinks();
        int countExternalLinks = linksPage.countExternalLinks();
        System.out.println("***Внешних ссылок: "+countExternalLinks);
        int countInternalLinks = linksPage.countInternalLinks();
        System.out.println("***Внутренних ссылок: "+countInternalLinks);

        driver.quit();
    }
}
