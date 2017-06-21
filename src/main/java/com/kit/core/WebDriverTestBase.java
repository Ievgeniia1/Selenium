package com.kit.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
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
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//WebDriver будет ждать 5 секунд, пока подгрузится єлемент

    }

    public void  setBrowser(){
        Browser runBrowser = browser == null? Browser.CHROME:Browser.valueOf(browser);
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
