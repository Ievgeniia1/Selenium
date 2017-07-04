package com.kit.thomascook;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 30.06.2017.
 */
public class thomasCookTest extends WebDriverTestBase {

    @Test
    public void thomasCookTest() {

        webDriver.get("https://www.thomascook.com/");
        WebElement dropdown = webDriver.findElement(By.id("SearchbarForm-duration"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("1 Night");
        assertTrue(select.getFirstSelectedOption().getText().equals("1 Night"));
    }
}