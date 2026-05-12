package com.tomp.rolonopol.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.tomp.rolonopol.steps",
                "com.tomp.rolonopol.hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class HomePageTestsRunner extends AbstractTestNGCucumberTests {
}
