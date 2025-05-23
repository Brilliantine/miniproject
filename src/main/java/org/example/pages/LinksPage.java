package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class LinksPage {
    private WebDriver driver;
    private List<WebElement> links;
    private Set<String> uniqueUrls = new HashSet<>();

    public LinksPage(WebDriver driver){
        this.driver=driver;
    }
    public void open(){driver.get("https://the-internet.herokuapp.com/");}
    public void searchLinks(){
        links=driver.findElements(By.tagName("a"));
        System.out.println("***Всего ссылок** "+links.size());
    }
    public void printTextAndUrl(){
        for (WebElement link : links){
            System.out.println("***Текст: "+link.getText()+" | URL: "+link.getAttribute("href"));
        }
    }
    public void uniqueLinks(){
        for(WebElement link : links){
            String href = link.getAttribute("href");
            if(href!=null){uniqueUrls.add(href);}
        }
        System.out.println("***Уникальных URL: "+uniqueUrls.size());
    }
}
