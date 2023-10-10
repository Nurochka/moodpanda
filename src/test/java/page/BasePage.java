package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private static final String LOGOUT_LINK = "//section//a[contains(text(), 'Logout')]";

    public LoginPage logout() {
        $(By.xpath(LOGOUT_LINK)).click();
        return new LoginPage();
    }


}


