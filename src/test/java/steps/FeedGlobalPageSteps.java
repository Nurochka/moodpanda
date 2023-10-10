package steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import page.FeedGlobalPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedGlobalPageSteps extends FeedGlobalPage {

    private static final String REPLY_SUCCESS_MESSAGE = "//*[contains(text(), 'Your comment was posted')]";

    FeedGlobalPage feedGlobalPage = new FeedGlobalPage();

    public DashboardPageSteps clickEditPost(){
        feedGlobalPage.clickEditPostLink();
        return new DashboardPageSteps();
    }


    public FeedGlobalPageSteps addReply(int postPosition, String replyText){
        feedGlobalPage.clickReply(postPosition)
                .fillInReplyField(replyText)
                .clickSendReplyButton();
        return this;
    }

    public boolean isSuccessMessageDisplayed(){
        return $(By.xpath(REPLY_SUCCESS_MESSAGE)).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public ProfilePageSteps navigateToYourProfile(){
        feedGlobalPage.clickYourProfileLink();
        return new ProfilePageSteps();
    }

}
