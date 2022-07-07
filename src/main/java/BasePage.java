import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage {
    protected WebDriver driver = null;


    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void isElementDisplayed(By locator, String elementName) {
        if (getElement(locator).isDisplayed()) {
            System.out.println(elementName + " is displayed on the webpage");
        } else {
            System.out.println(elementName + " is not displayed on the webpage");
        }

    }

    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
            js.executeScript("arguments[0].setAttribute('style', ''border:2px solid red;'", element);
            Thread.sleep(2000);}
        catch (Exception e){}
        js.executeScript("arguments[0].setAttribute('style', '');", element);
        return element;
    }

    public List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }

    public void enterText(By locator, String content) {
        WebElement element=getElement(locator);
        element.clear();
        element.sendKeys(content);
    }

    public void clickElement(By locator, String linkname) {
        getElement(locator).click();
        System.out.println("click action performed on the " + linkname);
    }

    public void takeScreenShot() {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd hh-mm-ss");
            String time = sdf.format(date);
            TakesScreenshot screenShot = ((TakesScreenshot) driver);
            File file = screenShot.getScreenshotAs(OutputType.FILE);
            FileHandler.createDir(new File("ScreenShots"));
            FileHandler.copy(file, new File("ScreenShots\\" + time + ".png"));
        } catch (Exception e) {
        }
    }
    /*public void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
        js.executeScript("arguments[0].setAttribute('style', ''border:2px solid red;'", element);
        Thread.sleep(2000);}
        catch (Exception e){}
        js.executeScript("arguments[0].setAttribute('style', '');", element);

    }
*/
    public void navigateBack() {
        driver.navigate().back();
    }

    public void closeBrowser() {
        driver.quit();
    }


}
