package com.kit.core.stylus;

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
public class stylusOldTest {
    private WebDriver myDriver;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "E:\\Kit\\Selenium\\src\\main\\resources\\chromedriver.exe");
        myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.get("http://stylus.com.ua/");




    }


    @Test
    public void test(){

        String searchText ="Sony";
        String searchText2 = "Z2";
        WebElement inputField = myDriver.findElement(By.name("q"));
        inputField.sendKeys("Sony Z2");
        WebElement searchButton = myDriver.findElement(By.xpath(".//*[@id='head-search']/form/input[2]"));
        searchButton.click();

        //next page
        WebElement link = myDriver.findElement(By.cssSelector(".item.out-of-stock"));

        assertTrue(link.getText().contains(searchText));
        assertTrue(link.getText().contains(searchText2));

        link.click();
        //next page
        WebElement itemCode =myDriver.findElement(By.xpath(".//*[@id='product-block']/header/div[1]/span"));
        assertTrue(itemCode.getText().contains("Код товара"));
    }


    @AfterTest
    public void tearDown(){
        myDriver.close();
    }
}
