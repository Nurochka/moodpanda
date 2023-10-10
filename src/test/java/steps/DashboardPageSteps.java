package steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import page.DashboardPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPageSteps extends DashboardPage {

    private static final String SUCCESS_MESSAGE = "//*[contains(text(), 'Post updated')]";

    DashboardPage dashboardPage = new DashboardPage();

    public DashboardPageSteps updateRating(int postPosition, String ratingValue){
        dashboardPage.setupRating(postPosition, ratingValue)
                     .clickUpdateButton(postPosition);
        return this;
    }

    public boolean isSuccessMessageDisplayed(){
        return $(By.xpath(SUCCESS_MESSAGE)).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

}
