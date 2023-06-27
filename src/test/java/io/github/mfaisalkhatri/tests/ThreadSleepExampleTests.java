package io.github.mfaisalkhatri.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadSleepExampleTests {


    @Test
    public void testThreadSleep() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        Thread.sleep(3000);
        String title = driver.getTitle();

        System.out.println(title);
        driver.quit();
    }

    @Test
    public void testThreadSleepMethodOverload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        Thread.sleep(3000, 2000);
        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);
        driver.quit();
    }

}
