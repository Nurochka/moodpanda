package page;

import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String LOGIN_URL = "https://moodpanda.com/login";
    private static final String EMAIL_INPUT = "//input[@type='text']";
    private static final String PASSWORD_INPUT = "//input[@type='password']";
    private static final String LOGIN_BUTTON = "//button";

    public LoginPage openLoginPage() {
        open(LOGIN_URL);
        return this;
    }

    public LoginPage enterEmail(String email) {
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        $(By.xpath(LOGIN_BUTTON)).click();
    }

}
