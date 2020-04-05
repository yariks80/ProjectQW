package com.it.tests;

import com.it.App;
import org.testng.annotations.AfterSuite;
import com.it.users.User;
import com.it.users.UserFactory;

public  abstract class BaseTest {
     App app=new App();
     User validUser= UserFactory.getValidUser();

    @AfterSuite
    public void afterSuite() {
        app.common.stopApp();
    }
}
