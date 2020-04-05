package com.it.driver;

import com.it.common.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MyDriver implements WebDriver {
    private static WebDriver driver;
    public WebDriverWait wait;
    private static int count;

    private MyDriver() {
        this.driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public static MyDriver getInstance() {
        return new MyDriver();

    }

    @Override
    public void get(String url) {
        driver.get(url);

    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    public void sendKeysOneByOne(WebElement element, String text) {
        element.clear();
        for (String s : text.split("")) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.sendKeys(s);
        }
    }

    /**
     * Scroll Up
     */
    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }

    /**
     * Scroll Down
     */

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public boolean isElementPresent(By locator) {
        boolean result = false;
        driver.manage().timeouts().
                implicitlyWait(0, TimeUnit.SECONDS);
        try {
            List<WebElement> list = driver.findElements(locator);
            driver.manage().timeouts().
                    implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
            result = list.size() != 0 && list.get(0).isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            //NOP
        }
        return result;
    }
    public void takeSnapShot()  {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot//screen" + count + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
           count++;

    }
}


