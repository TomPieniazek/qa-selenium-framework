package com.tomp.rolonopol.pages;

import com.tomp.rolonopol.config.TestConfig;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    SoftAssert softAssert = new SoftAssert();
    private By header = By.xpath("//span[@class='main-title']");
    private By activeUsersNumber = By.id("stat-users");
    private By managedFarmsNumber = By.id("stat-farms");
    private By totalAreaNumber = By.id("stat-area");
    private By totalStaffNumber = By.id("stat-staff");
    private By stockAnimalsNumber = By.id("stat-animals");
    private By registerButton = By.cssSelector("#cta-section a[href='/register.html']");
    private By signInButton = By.cssSelector("#cta-section a[href='/login.html']");

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
