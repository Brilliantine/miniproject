package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class LinksTest {
    public static void main(String[] args){
        // 1. Настройка драйвера
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // 2. Получение всех ссылок
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Всего ссылок: " + links.size());

        // 3. Вывод текста и href
        for (WebElement link : links) {
            System.out.println("Текст: " + link.getText() + " | URL: " + link.getAttribute("href"));
        }

        // 4. Уникальные ссылки (Set)
        Set<String> uniqueUrls = new HashSet<>();
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null) {
                uniqueUrls.add(href);
            }
        }
        System.out.println("Уникальных URL: " + uniqueUrls.size());

        // 5. Карта текст -> href (Map)
        Map<String, String> textToUrl = new HashMap<>();
        for (WebElement link : links) {
            String text = link.getText().trim();
            String href = link.getAttribute("href");
            if (!text.isEmpty() && href != null) {
                textToUrl.put(text, href);
            }
        }

        System.out.println("Карта 'текст -> URL':");
        for (Map.Entry<String, String> entry : textToUrl.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Закрыть браузер
        driver.quit();
    }
}
