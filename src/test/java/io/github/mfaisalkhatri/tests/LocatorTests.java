package io.github.mfaisalkhatri.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;

public class LocatorTests {

    @Test
    public void testLinkText() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.linkText("Ajax Form Submit")).click();
        String header = driver.findElement(By.tagName("h1")).getText();
        assertEquals(header, "Form Submit Demo");
        driver.quit();

    }

    @Test
    public void testPartialLinkText() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.partialLinkText("Healing")).click();
        String header = driver.findElement(By.tagName("h1")).getText();
        assertEquals(header, "Auto Healing");
        driver.quit();

    }

    @Test
    public void testTagNames() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        driver.quit();
    }

    @Test
    public void testXpath() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id=\"input-email\" and @name=\"email\"]")).sendKeys("faisal.k@gmail.com");
        //driver.findElement(By.xpath("//input[@id=\"input-email\" or @name=\"email\"]")).sendKeys("faisal.k@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).sendKeys("Password");
        driver.findElement(By.xpath("//input[text()='Continue']")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testRelativeLocator() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=product/manufacturer/info&manufacturer_id=8");

        WebElement iMac = driver.findElement(By.linkText("iMac"));
        WebElement iMacPriceViaBelow = driver.findElement(with(By.cssSelector("div.price> span")).below(iMac));
        assertEquals(iMacPriceViaBelow.getText(), "$170.00");

        WebElement fetchToTheRight = driver.findElement(with(By.tagName("h4")).toRightOf(iMac));
        assertEquals(fetchToTheRight.getText(), "Apple Cinema 30\"");

        WebElement fetchViaAbove = driver.findElement(with(By.tagName("h4")).above(fetchToTheRight));
        assertEquals(fetchViaAbove.getText(), "iPod Nano");

        WebElement fetchViaToLeftOf=driver.findElement(with(By.tagName("h4")).toLeftOf(fetchViaAbove));
        assertEquals(fetchViaToLeftOf.getText(), "iPod Shuffle");

        driver.quit();
    }

}
