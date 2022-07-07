import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DashboardTest{
    public String browser="chrome";


    @Test
    public void validateUserIsAtDashboardPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        dashboard.UserNavigationToDashboard();

    }
    @Test
    public void validateDashboardPageWithPlansTilePartnersTilePaymentInfoTileAndAnnouncementsTile(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        login.isElementDisplayed(By.xpath(String.format(dashboard.tileTitle,"Plans")),"Plans tile");
        login.isElementDisplayed(By.xpath(String.format(dashboard.tileTitle,"Partners")),"Partners");
        login.isElementDisplayed(By.xpath(String.format(dashboard.tileTitle,"Payment Info")),"Payment Info");
        login.isElementDisplayed(By.xpath(String.format(dashboard.tileTitle,"Announcements")),"Announcements");

    }

    @Test
     public void validateCountOnPlansTileIsSameAsListOfPlansInPlansPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        dashboard.IsCountOnDashboardIsSameAsListOnPage("Plans");
        login.navigateBack();
        dashboard.IsCountOnDashboardIsSameAsListOnPage("Partners");
        login.navigateBack();
        dashboard.IsCountOnDashboardIsSameAsListOnPage("Payment Info");
    }
    @AfterTest
    public void closeBrowser(){
    LoginPage login=new LoginPage();
    login.closeBrowser();

    }
}

