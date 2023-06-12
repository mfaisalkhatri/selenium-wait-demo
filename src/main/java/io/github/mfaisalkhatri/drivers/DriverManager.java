package io.github.mfaisalkhatri.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    WebDriver driver;

    public void createChromeDriver() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
