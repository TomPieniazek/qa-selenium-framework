package com.tomp.rolnopol.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "",
        glue = {
                "com.tomp.rolnopol.steps",
                "com.tomp.rolnopol.hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class HomePageTestsRunner extends AbstractTestNGCucumberTests {
}
