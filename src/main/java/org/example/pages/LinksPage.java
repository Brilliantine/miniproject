package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class LinksPage {
    private WebDriver driver;
    private final String baseUrl = "https://the-internet.herokuapp.com";
    private List<WebElement> links;
    private List<String> extLinks;
    private List<String> internLinks;
    private Set<String> uniqueUrls = new HashSet<>();

    public LinksPage(WebDriver driver){
        this.driver=driver;
    }
    public void open (){
        driver.get(baseUrl);
    }
    public void searchLinks (){
        links=driver.findElements(By.tagName("a"));
    }
    public int countLinks(){
        return links.size();
    }
    public void uniqueLinks(){
        for (WebElement link : links){
            String href = link.getAttribute("href");
            if(href!=null){uniqueUrls.add(href);}
        }
        System.out.println("***Уникальных ссылок: "+uniqueUrls.size());
    }
    public void printExternalLinks(){
        extLinks = new ArrayList<>();
        for(WebElement link : links){
            String href = link.getAttribute("href");
            if(href != null && !href.startsWith(baseUrl)){
                extLinks.add(href);
                System.out.println("- "+href);
            }
        }
        if(extLinks.isEmpty()){
            System.out.println("Внешних ссылок на данной странице не обнаружено");
        }
    }
    public int countExternalLinks(){
        return extLinks.size();
    }
    public void printInternalLinks(){
        internLinks = new ArrayList<>();
        for(WebElement link : links){
            String href = link.getAttribute("href");
            if(href != null && href.startsWith(baseUrl)){
                internLinks.add(href);
                System.out.println("- "+href);
            }
        }
        if(internLinks.isEmpty()){
            System.out.println("Внутренних ссылок на данной странице не отбнаружено");
        }
    }
    public int countInternalLinks(){
        return internLinks.size();
    }
}
