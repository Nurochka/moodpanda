package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage extends BasePage {

    private static final String MOOD_ANALYSIS_LINK = "//div[@class='container is-hidden-touch']/a[contains(.,'Mood analysis')]";
    private static final String ALL_HISTORY_LINK = "//li[@class='is-active']//a//span[contains(text(), 'All')]";
    private static final String CHART_MENU_BUTTON = "//*[local-name() = 'svg']/*[name()='g'][@class='highcharts-exporting-group']";
    private static final String DOWNLOAD_PDF_BUTTON = "//li[contains(text(), 'Download PDF document')]";


    public ProfilePage clickMoodAnalysisLink() {
        $(By.xpath(MOOD_ANALYSIS_LINK)).click();
        return this;
    }

    public ProfilePage clickAllLink() {
        $(By.xpath(ALL_HISTORY_LINK)).click();
        return this;
    }

    public ProfilePage clickChartMenuButton() {
        $$(By.xpath(CHART_MENU_BUTTON)).get(0).click();
        return this;
    }

    public ProfilePage clickDownloadPDF() {
        $(By.xpath(DOWNLOAD_PDF_BUTTON)).click();
        return this;
    }


}
