import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class LoginTest {

    public String browser="chrome";

    @Test
    public void validateLoginPageWithUserIdPasswordAndLoginOptions(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        login.validateLoginPageWithUserIdPasswordAndLoginOptions();
    }
    @Test
    public void validateLoginPageWithValidUserIdAndPassword(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        login.loginWithValidUserIdPassword();
    }
    /*@AfterTest
    public void closeBrowser(){
        LoginPage login=new LoginPage();
        login.closeBrowser();

    }*/
}
