package steps;

import page.ProfilePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class ProfilePageSteps extends ProfilePage {

    ProfilePage profilePage = new ProfilePage();

    public ProfilePageSteps downloadPDFForAllHistoryChart() throws AWTException, InterruptedException {
        profilePage.clickMoodAnalysisLink()
                //.clickAllLink()
                .clickChartMenuButton()
                .clickDownloadPDF();
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    public static boolean checkPdfFileIsDownloaded() throws InterruptedException {
        Thread.sleep(3000);
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        System.out.println(System.getProperty("user.dir"));
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("chart.pdf")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        if (f != null) {
            f.deleteOnExit();
        }
        return found;
    }
}
