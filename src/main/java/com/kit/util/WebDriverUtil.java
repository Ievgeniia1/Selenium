package com.kit.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;

import static com.google.common.io.Files.toByteArray;

/**
 * Created by evgeniya on 16.06.2017.
 */
public class WebDriverUtil {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor executor;
    long explicitWait = Long.parseLong(PropertiesCache.getProperty("time.outline.seconds"));

    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, explicitWait);
    }

    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition) {
        return  (WebElement)webDriverWait.until(expectedCondition);
    }

    public void jsClick(String locator, String type){
        executor = (JavascriptExecutor) webDriver;
        switch(type){
            case "id":
                executor.executeScript("document.getElementById(\"" + locator + "\").click()");
                break;
            case "name":
                executor.executeScript("document.getElementsByName(\"" + locator + "\")[0].click()"); //возвращает массив,
                // нужно взять первый элемент [0]
                break;

        }


    }

    @Attachment(value = "{0}")
     public byte[] saveScreenshot(String attachName) {
               try {
                        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                        return toByteArray(scrFile);
                    } catch (Exception e) {
                        System.out.println("Is not saved screenshot" + e);
                    }
                return new byte[0];
          }


}
