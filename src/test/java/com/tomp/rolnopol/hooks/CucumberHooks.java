package com.tomp.rolnopol.hooks;

import com.tomp.rolnopol.context.ScenarioContext;
import com.tomp.rolnopol.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        ScenarioContext.clearUserData();
        DriverManager.quitDriver();
    }
}
