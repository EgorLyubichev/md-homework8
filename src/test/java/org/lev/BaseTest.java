package org.lev;

import org.lev.pages.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    BasePage basePage = new BasePage();

    @BeforeTest
    public void openStartPage(){
        basePage.openAuthorizationPage();
    }

    @AfterTest
    public void closeResources(){
        basePage.closeResources();
    }
}
