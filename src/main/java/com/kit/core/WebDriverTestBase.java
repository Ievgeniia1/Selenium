package com.kit.core;

import com.kit.util.PropertiesCache;
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
    //How to pass system variable to Selenium framework
    //mvn -DBrowser=CHROME or -DBrowser = FF clean test - to run test on various browsers
    private String browser = System.getProperty("browser");
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit")); //кастинг в long
    long pageLoad = Long.parseLong(PropertiesCache.getProperty("page.load.timeout"));
    long setScript = Long.parseLong(PropertiesCache.getProperty("set.script.timeout"));


    @BeforeClass
    public void setUp(){
//        ChromeDriverManager.getInstance().setup();
//        webDriver = new ChromeDriver();
        setBrowser();
        setWebDriverSetting();
    }

    public void setWebDriverSetting(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);//WebDriver будет ждать 5 секунд, пока подгрузится єлемент
        webDriver.manage().timeouts().pageLoadTimeout(pageLoad,TimeUnit.SECONDS); //for Page loading
        webDriver.manage().timeouts().setScriptTimeout(setScript,TimeUnit.SECONDS); //for JS scripts loading
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
        //webDriver.close();  //closes a browser , quit closes tab

    }
}
