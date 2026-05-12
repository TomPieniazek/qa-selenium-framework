package com.tomp.rolonopol.pages;

import com.tomp.rolonopol.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void hoverOverElement(By locator) {
        WebElement elem = waitUtils.waitForVisibility(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).perform();
    }

    public String getText(By locator) {
        return waitUtils.waitForVisibility(locator).getText();
    }
}
