package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    DriverManager driverManager;

    @BeforeTest(alwaysRun = true)
    public void testSetup() {
        driverManager = new DriverManager();
        driverManager.createChromeDriver();
        driverManager.getDriver().get("https://ecommerce-playground.lambdatest.io/");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
