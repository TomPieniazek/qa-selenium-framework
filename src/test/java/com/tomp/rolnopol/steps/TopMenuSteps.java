package com.tomp.rolnopol.steps;

import com.tomp.rolnopol.driver.DriverManager;
import com.tomp.rolnopol.pages.TopMenuPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TopMenuSteps {
    private final WebDriver driver = DriverManager.getDriver();
    TopMenuPage topMenuPage = new TopMenuPage(driver);

    @When("user navigates( back) to Home page via top menu")
    public void userNavigatesToHomePageViaTopMenu() {
        topMenuPage.openHomePage();
    }

    @When("user navigates( back) to Register page via top menu")
    public void userNavigatesToRegisterPageViaTopMenu() {
        topMenuPage.openRegisterPage();
    }

    @When("user navigates( back) to Login page via top menu")
    public void userNavigatesToLoginPageViaTopMenu() {
        topMenuPage.openLogInPage();
    }
}