package com.tomp.rolnopol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NotificationAlertsPage extends BasePage {

    public NotificationAlertsPage(WebDriver driver) {
        super(driver);
    }

    private final By errorNotificationContainer = By.cssSelector(".notifications-container div.error");
    private final By successNotificationContainer = By.cssSelector(".notifications-container div.success");
    private final By notificationTitle = By.cssSelector(".notifications-container div.notification-title");
    private final By notificationMessage = By.cssSelector(".notifications-container div.notification-message");
    private final By closeNotificationButton = By.cssSelector("button.notification-close");

    public void assertSuccessNotificationAlert(String title, String message, boolean closeNotification) {
        waitUtils.waitForVisibility(successNotificationContainer);
        Assert.assertEquals(getText(notificationTitle), title, "Success notification title is incorrect!");
        Assert.assertEquals(getText(notificationMessage), message, "Success notification message is incorrect!");
        if (closeNotification) {
            click(closeNotificationButton);
            waitUtils.waitForDisappearance(successNotificationContainer);
        }
    }

    public void assertErrorNotificationAlert(String title, String message, boolean closeNotification) {
        waitUtils.waitForVisibility(errorNotificationContainer);
        Assert.assertEquals(getText(notificationTitle), title, "Error notification title is incorrect!");
        Assert.assertEquals(getText(notificationMessage), message, "Error notification message is incorrect!");
        if (closeNotification) {
            click(closeNotificationButton);
            waitUtils.waitForDisappearance(errorNotificationContainer);
        }
    }
}
