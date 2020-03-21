package com.it.tests;

import com.it.pages.BasePage;
import com.it.pages.DashboardPage;
import com.it.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {

    @Test
    public void testName() {
        app.login.login("ittest2","337774a");
        Assert.assertEquals(app.dashboard.getLinkUserEmail(),"ittest2@i.ua");
    }
}
