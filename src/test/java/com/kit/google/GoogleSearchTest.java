package com.kit.google;

import org.apache.xpath.operations.Equals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 02.06.2017.
 */
public class GoogleSearchTest {

    private  String googleSearch;
    private WebDriver webDriver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","E:\\Kit\\Selenium\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        googleSearch="https://www.googe.com.ua/";
        webDriver.get(googleSearch);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//WebDriver будет ждать 5 секунд, пока подгрузится єлемент

    }

    @Test
    public void searchTest(){
        String searchText = "Selenium";

        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();


        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);

        assertTrue(link.getText().contains(searchText));


    }

}
