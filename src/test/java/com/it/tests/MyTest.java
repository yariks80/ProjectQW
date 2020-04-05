package com.it.tests;

import com.it.users.User;
import com.it.users.UserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyTest extends BaseTest {

    @Test
    public void testName() {
        List<User> users = UserFactory.getRandomUsers(10);
        users.forEach(System.out::println);
        app.login.login(validUser);
        Assert.assertEquals(app.dashboard.getLinkUserEmail(),validUser.email);
    }
}
