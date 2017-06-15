package com.kit.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by evgeniya on 09.06.2017.
 */

public class WebDriverTestBase {
    protected WebDriver webDriver;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","E:\\Kit\\Selenium\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//WebDriver будет ждать 5 секунд, пока подгрузится єлемент

    }

    @AfterSuite
    public void tearDown(){
        webDriver.close();  //closes a browser
        //webDriver.quit(); //closes a browser's tab
    }
}
