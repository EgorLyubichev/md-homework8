package org.lev.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {

    private static final String USERNAME = "selenium_chrome";
    private static final String USER_PASSWORD = "Axa@Demo";

    private static final By LOGIN_FIELD = By.xpath("//input[@formcontrolname='username']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@formcontrolname='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//button[@class='app-blue-btn w-100']");

    public void getAuthorization() {
        $(LOGIN_FIELD).setValue(USERNAME);
        $(PASSWORD_FIELD).setValue(USER_PASSWORD).pressEnter();
        $(SIGN_IN_BUTTON).click();
    }
}
