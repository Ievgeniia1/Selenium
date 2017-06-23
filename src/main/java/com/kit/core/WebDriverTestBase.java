package com.kit.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by evgeniya on 09.06.2017.
 */

public class WebDriverTestBase {
    protected WebDriver webDriver;
    private String browser = System.getProperty("browser");

    @BeforeClass
    public void setUp(){
//        ChromeDriverManager.getInstance().setup();
//        webDriver = new ChromeDriver();
        setBrowser();
        setWebDriverSetting();
    }

    public void setWebDriverSetting(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//WebDriver будет ждать 5 секунд, пока подгрузится єлемент
        webDriver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS); //for Page loading
        webDriver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS); //for JS scripts loading
    }

    public void  setBrowser(){
        Browser runBrowser = EnumUtils.isValidEnum(Browser.class, browser) ? Browser.valueOf(browser.toUpperCase()) : Browser.CHROME;
                switch (runBrowser){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                break;
            case FF:
                FirefoxDriverManager.getInstance().setup();
                webDriver = new FirefoxDriver();
                break;
        }

    }

    @AfterClass
    public void tearDown(){
        webDriver.close();  //closes a browser , quit closes tab

    }
}
