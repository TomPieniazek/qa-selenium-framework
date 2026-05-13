package com.tomp.rolnopol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    // Default state of top menu.
    private final By homePageIcon = By.cssSelector("a[data-testid=nav-home]");
    private final By alertsIcon = By.cssSelector("a[data-testid=nav-alerts] i");
    private final By documentationIcon = By.cssSelector("a[data-testid=nav-docs] i");
    private final By apiExplorerIcon = By.cssSelector("a[data-testid=nav-api-explorer] i");
    private final By registerIcon = By.cssSelector("a[data-testid=nav-register] i");
    private final By logInIcon = By.cssSelector("a[data-testid=nav-login] i");

    // Available after logging in.
    private final By staffAndFieldManagementIcon = By.cssSelector("a[data-testid=nav-staff-fields] i");
    private final By financialTrackingIcon = By.cssSelector("a[data-testid=nav-financial] i");
    private final By marketplaceIcon = By.cssSelector("a[data-testid=nav-marketplace] i");
    private final By rolnopolMapIcon = By.cssSelector("a[data-testid=nav-map] i");
    private final By profileIcon = By.cssSelector("a[data-testid=nav-profile] i");
    private final By profileUserName = By.cssSelector("span.nav-text-user-name");
    private final By logOutButton = By.cssSelector("button[data-testid=logout-btn]");

    public void openHomePage() {
        click(homePageIcon);
        waitUtils.waitForPageTitle("Rolnopol");
    }

    public void openRegisterPage() {
        click(registerIcon);
        waitUtils.waitForPageTitle("Register - Rolnopol");
    }

    public void openLogInPage() {
        click(logInIcon);
        waitUtils.waitForPageTitle("Login - Rolnopol");
    }

}
