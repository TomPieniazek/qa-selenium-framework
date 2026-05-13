package com.tomp.rolnopol.steps;

import com.tomp.rolnopol.context.ScenarioContext;
import com.tomp.rolnopol.driver.DriverManager;
import com.tomp.rolnopol.pages.RegisterPage;
import com.tomp.rolnopol.testdata.RegisterUserData;
import com.tomp.rolnopol.testdata.UserDataFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    private final WebDriver driver = DriverManager.getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("user fills registration form with random data")
    public void userFillsRegistrationFormWithRandomData() {
        RegisterUserData user = UserDataFactory.randomUser();
        ScenarioContext.setUserData(user);
        registerPage.fillRegistrationForm(user);
    }

    @When("user fills registration form with random data leaving optional fields empty")
    public void userFillsRegistrationFormWithRandomDataAndNoOptionalFields() {
        RegisterUserData user = UserDataFactory.randomUserWithoutOptionalFields();
        ScenarioContext.setUserData(user);
        registerPage.fillRegistrationForm(user);
    }

    @When("user fills registration form with duplicated data")
    public void userFillsRegistrationFormWithDuplicatedData() {
        registerPage.fillRegistrationForm(ScenarioContext.getUserData());
    }

    @When("user clicks the Create Account button")
    public void userClicksTheCreateAccountButton() {
        registerPage.clickCreateAccountButton();
        System.out.println(ScenarioContext.getUserData().toString());
    }
}
