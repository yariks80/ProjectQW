package com.it.helpers;

import com.it.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class CommonHelper extends BasePage {
    public void stopApp() {
        driver.quit();
    }
    public WebDriver getDriver() {
       return driver;
    }

}
