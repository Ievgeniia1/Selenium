package com.kit;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 30.06.2017.
 */
public class W3c extends WebDriverTestBase {
    String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";
    String matchingText= "Opel";


    @Test (enabled = false)
    public void iFrameTest(){
        webDriver.get(url);
        webDriver.switchTo().frame("iframeResult");

        WebElement select = webDriver.findElement(By.cssSelector("html>body>select"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("Opel");

        String selected = dropdown.getFirstSelectedOption().getText();
        assertTrue(selected.equals(matchingText));
    }
}
