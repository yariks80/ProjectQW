package com.it.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.it.common.Constants.*;

 class DriverFactory {
   public static WebDriver getDriver() {
        WebDriver driver;
        String driverName = System.getProperty("driver");
        if (driverName != null && "gecko".equals(driverName)) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        } else {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        return driver;

    }
}
