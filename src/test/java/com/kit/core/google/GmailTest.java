package com.kit.core.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.gmailPages.MailsListPage;
import com.kit.pages.gmailPages.PasswordPage;
import com.kit.pages.gmailPages.UserNamePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class GmailTest extends WebDriverTestBase{
    private String accountPage = "https://gmail.com/"; //тестовые данные в начале
    private String userName = "testselenium373";
    private String password = "2wsxzaq1";
    private String searchText="Gmail";


    @Test (enabled =  true)
    public void gmailLoginTest(){
        UserNamePage userNamePage = new UserNamePage(webDriver);
        userNamePage.open(accountPage);
        userNamePage.putName(userName);
        userNamePage.clickNext();

        PasswordPage passwordPage = new PasswordPage(webDriver);
        passwordPage.fillPassword(password);

        MailsListPage mailsListPage = new MailsListPage(webDriver);
        assertTrue(mailsListPage.getMailText().contains(searchText));
    }

}
