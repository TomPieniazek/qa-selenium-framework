package com.tomp.rolnopol.pages;

import com.tomp.rolnopol.config.TestConfig;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By header = By.xpath("//span[@class='main-title']");
    private final By activeUsersNumber = By.id("stat-users");
    private final By managedFarmsNumber = By.id("stat-farms");
    private final By totalAreaNumber = By.id("stat-area");
    private final By totalStaffNumber = By.id("stat-staff");
    private final By stockAnimalsNumber = By.id("stat-animals");
    private final By registerButton = By.cssSelector("#cta-section a[href='/register.html']");
    private final By signInButton = By.cssSelector("#cta-section a[href='/login.html']");

    public void openPage() {
        driver.get(TestConfig.get("baseUrl"));
    }

    public void waitForCorrectStatistics(DataTable dataTable) {
        Map<String, String> expectedStatistics = dataTable.asMaps(String.class, String.class).getFirst();

        waitUtils.waitForText(activeUsersNumber, expectedStatistics.get("Active Users"));
        waitUtils.waitForText(managedFarmsNumber, expectedStatistics.get("Managed Farms"));
        waitUtils.waitForText(totalAreaNumber, expectedStatistics.get("Total Area"));
        waitUtils.waitForText(totalStaffNumber, expectedStatistics.get("Total Staff"));
        waitUtils.waitForText(stockAnimalsNumber, expectedStatistics.get("Stock Animals"));
    }

    public void clickRegisterButton() {
        waitUtils.waitForVisibility(registerButton).click();
        waitUtils.waitForPageTitle("Register - Rolnopol");
    }

    public void clickLogInButton() {
        waitUtils.waitForVisibility(signInButton).click();
        waitUtils.waitForPageTitle("Login - Rolnopol");
    }

    public String getHeaderText() {
        return getText(header);
    }
}
