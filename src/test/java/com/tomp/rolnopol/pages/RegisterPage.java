package com.tomp.rolnopol.pages;

import com.tomp.rolnopol.config.TestConfig;
import com.tomp.rolnopol.testdata.RegisterUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By emailInput = By.cssSelector("#registerForm input[data-testid=email-input]");
    private final By displayNameInput = By.cssSelector("#registerForm input[data-testid=display-name-input]");
    private final By passwordInput = By.cssSelector("#registerForm input[data-testid=password-input]");
    private final By createAccountButton = By.cssSelector("button[data-testid=register-submit-btn]");

    public void openPage() {
        driver.get(TestConfig.get("baseUrl") + "/register.html");
        waitUtils.waitForVisibility(createAccountButton);
    }

    public void fillRegistrationForm(RegisterUserData user) {
        type(emailInput, user.email());
        if (user.displayName() != null)
            type(displayNameInput, user.displayName());
        type(passwordInput, user.password());
    }

    public void clickCreateAccountButton() {
        waitUtils.waitForVisibility(createAccountButton).click();
    }
}
