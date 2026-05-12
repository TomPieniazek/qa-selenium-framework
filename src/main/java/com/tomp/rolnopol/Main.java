package com.tomp.rolnopol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();
        assertEquals(driver.getTitle(),"Rolnopol", "The page title is incorrect.");
        driver.quit();
    }
}