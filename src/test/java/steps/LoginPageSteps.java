package steps;

import model.User;
import page.FeedGlobalPage;
import page.LoginPage;

public class LoginPageSteps extends LoginPage {

    LoginPage loginPage = new LoginPage();

    public FeedGlobalPageSteps login(User user){
        loginPage.openLoginPage()
                .enterEmail(user.getUserEmail())
                .enterPassword(user.getUserPassword())
                .clickLoginButton();
        return new FeedGlobalPageSteps();

    }



}
