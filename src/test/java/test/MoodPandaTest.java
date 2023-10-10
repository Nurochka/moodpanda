package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.DashboardPageSteps;
import steps.FeedGlobalPageSteps;
import steps.LoginPageSteps;

import java.awt.*;

import static steps.ProfilePageSteps.checkPdfFileIsDownloaded;

public class MoodPandaTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        loginPageSteps = new LoginPageSteps();
        user = new User();
    }

    @Test(description = "Checking Rating can be updated")
    public void checkRatingTest() {
        final int POST_POSITION = 0;
        final String RATING = "1";

        DashboardPageSteps dashboardPageSteps = loginPageSteps.login(user)
                .clickEditPost()
                .updateRating(POST_POSITION, RATING);
        Boolean SuccessMessageDisplayed = dashboardPageSteps.isSuccessMessageDisplayed();
        dashboardPageSteps.logout();

        Assert.assertTrue(SuccessMessageDisplayed, "smth went wrong");
    }

    @Test(description = "Checking Reply to a post can be added")
    public void checkAddingReplyTest() {
        final int REPLY_POST_POSITION = 0;
        final String REPLY_TEXT = "This is test reply";

        FeedGlobalPageSteps feedGlobalPageSteps = loginPageSteps.login(user)
                .addReply(REPLY_POST_POSITION, REPLY_TEXT);
        Boolean SuccessMessageDisplayed = feedGlobalPageSteps.isSuccessMessageDisplayed();
        feedGlobalPageSteps.logout();

        Assert.assertTrue(SuccessMessageDisplayed, "smth went wrong");
    }

    @Test(description = "Check that PDF for History chart is downloaded")
    public void checkPdfIsDownloaded() throws InterruptedException, AWTException {
        loginPageSteps.login(user)
                .navigateToYourProfile()
                .downloadPDFForAllHistoryChart();

        Boolean isDownloaded = checkPdfFileIsDownloaded();
        Assert.assertTrue(isDownloaded, "File is not downloaded");
    }


}
