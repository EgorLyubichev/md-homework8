package org.lev.pages;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    private static final String DELTIXUAT_LOGIN_PAGE_URL = "https://app.tca.deltixuat.com/login";

    public void openAuthorizationPage(){
        open(DELTIXUAT_LOGIN_PAGE_URL);
    }

    public void closeResources(){
        closeWindow();
        closeWebDriver();
    }
}
