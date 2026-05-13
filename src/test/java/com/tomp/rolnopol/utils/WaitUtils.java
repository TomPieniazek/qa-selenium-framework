package com.tomp.rolnopol.utils;

import com.tomp.rolnopol.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfig.getInt("timeoutSeconds")));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForText(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
    }

    public void waitForPageTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public void waitForDisappearance(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
