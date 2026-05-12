package com.tomp.rolonopol.steps;

import com.tomp.rolonopol.driver.DriverManager;
import com.tomp.rolonopol.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {
    private final WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("user opens Rolnopol Home Page")
    public void userOpensHomePage() {
        homePage.openPage();
    }

    @When("user waits for correct Home Page statistics")
    public void userWaitsForCorrectStatistics(DataTable table) {
        homePage.waitForCorrectStatistics(table);
    }

    @Then("Home Page main header should be {string}")
    public void userChecksHomePageHeader(String expectedHeader) {
        Assert.assertEquals(homePage.getHeaderText(), expectedHeader, "The expected header is incorrect!");
    }
}
