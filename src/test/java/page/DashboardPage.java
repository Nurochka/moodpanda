package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage extends BasePage{

    private static final String RATING_SELECT = "//td//select";
    private static final String UPDATE_BUTTON = "//button[contains(@class, 'is-outdlined')]";

    public DashboardPage setupRating(int ratingPosition, String rating){
        $$(By.xpath(RATING_SELECT)).get(ratingPosition).selectOptionByValue(rating);
        return this;
    }

    public DashboardPage clickUpdateButton(int buttonPosition){
        $$(By.xpath(UPDATE_BUTTON)).get(buttonPosition).click();
        return this;
    }


}
