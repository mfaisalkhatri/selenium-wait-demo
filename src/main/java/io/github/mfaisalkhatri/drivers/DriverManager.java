package io.github.mfaisalkhatri.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static java.text.MessageFormat.format;

public class DriverManager {

    WebDriver driver;
    private static final String LT_USERNAME = System.getProperty("LT_USERNAME");
    private static final String LT_ACCESS_KEY = System.getProperty("LT_ACCESS_KEY");
    private static final String GRID_URL = "@hub.lambdatest.com/wd/hub";

    public void createChromeDriverInCloud() {
        final ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        final HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", LT_USERNAME);
        ltOptions.put("accessKey", LT_ACCESS_KEY);
        ltOptions.put("resolution", "2560x1440");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("build", "LambdaTest ECommerce Playground Build");
        ltOptions.put("name", "LambdaTest ECommerce Playground Tests");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        try {
            driver = new RemoteWebDriver(new URL(format("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_KEY, GRID_URL)), browserOptions);
        } catch (MalformedURLException e) {
            throw new Error("RemoteDriver's URL not set correctly!");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void createChromeDriverLocal() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
