package com.kit.core.stylus;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 19.06.2017.
 */
public class stylusOldTest extends WebDriverTestBase{


    @Test (enabled = true)
    public void test(){

        String searchText ="Sony";
        String searchText2 = "Z2";
        webDriver.get("http://stylus.com.ua/");
        WebElement inputField = webDriver.findElement(By.name("q"));
        inputField.sendKeys("Sony Z2");
        WebElement searchButton = webDriver.findElement(By.xpath(".//*[@id='head-search']/form/input[2]"));
        searchButton.click();

        //next page
        WebElement link = webDriver.findElement(By.cssSelector(".item.out-of-stock"));

        assertTrue(link.getText().contains(searchText));
        assertTrue(link.getText().contains(searchText2));

        link.click();
        //next page
        WebElement itemCode =webDriver.findElement(By.xpath(".//*[@id='product-block']/header/div[1]/span"));
        assertTrue(itemCode.getText().contains("1"));
    }



}
