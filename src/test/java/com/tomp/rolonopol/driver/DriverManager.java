package com.tomp.rolonopol.driver;

import com.tomp.rolonopol.config.TestConfig;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    private static WebDriver createDriver() {
        String browser = TestConfig.get("browser").toLowerCase();

        return switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Browser not supported");
        };
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
            driver.manage().window().setSize(new Dimension(
                    TestConfig.getInt("windowWidth"),
                    TestConfig.getInt("windowHeight")
            ));
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
