package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class LinksPage {
    private WebDriver driver;

    LinksPage(WebDriver driver){
        this.driver=driver;
    }
    public void open(){driver.get("https://the-internet.herokuapp.com/");}
    public void searchLinks(){
        List<WebElement>links=driver.findElements(By.tagName("a"));
    }
}
