package com.kit.thomascook;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.thomasCook.ThomasHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 30.06.2017.
 */
public class thomasNewTest extends WebDriverTestBase {
    String url = "https://www.thomascook.com/";
    String value="string:1";
    String text = "1 Night";

    @Test
    public void testThomas(){
        ThomasHomePage thomasHomePage = new ThomasHomePage(webDriver);
        thomasHomePage.open(url);
        thomasHomePage.selectFromDropdown(value);
        assertTrue(thomasHomePage.getText().equals(text));
    }
}
