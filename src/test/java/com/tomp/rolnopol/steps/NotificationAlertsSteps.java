package com.tomp.rolnopol.steps;

import com.tomp.rolnopol.driver.DriverManager;
import com.tomp.rolnopol.pages.NotificationAlertsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class NotificationAlertsSteps {
    private final WebDriver driver = DriverManager.getDriver();
    NotificationAlertsPage notificationAlertsPage = new NotificationAlertsPage(driver);

    @Then("success notification should appear on screen with {string} message")
    public void userVerifiesSuccessNotification(String expectedMessage) {
        notificationAlertsPage.assertSuccessNotificationAlert("Success", expectedMessage, true);
    }

    @Then("error notification should appear on screen with {string} message")
    public void userVerifiesErrorNotification(String expectedMessage) {
        notificationAlertsPage.assertErrorNotificationAlert("Error", expectedMessage, true);
    }
}
