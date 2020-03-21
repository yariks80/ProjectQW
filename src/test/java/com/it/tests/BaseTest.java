package com.it.tests;

import com.it.App;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public  abstract class BaseTest {
     App app=new App();

    @AfterSuite
    public void afterSuite() {
        app.common.stopApp();
    }
}
