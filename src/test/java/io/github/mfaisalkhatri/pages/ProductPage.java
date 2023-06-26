package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addPalmTreoCameraLensToCart() {
        final Actions actions = new Actions(driver);
        actions.moveToElement(palmTreoCameraLens())
                .pause(200)
                .moveToElement(addToCartBtn())
                .pause(100)
                .click()
                .perform();
    }

    public void checkoutProduct() {
        //Thread.sleep(2000);
        checkoutBtn().click();
    }

    public String successMessageText() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
                

        WebElement successMessage = wait.until(driver -> notificationPopUp().findElement(By.tagName("p")));
        //WebElement foo = wait.until(driver -> {return driver.findElement(By.id("foo"))});
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return successMessage.getText();
    }

    private WebElement addToCartBtn() {
        return driver.findElement(By.cssSelector("div.product-action > button.btn.btn-cart.cart-29"));
    }

    private WebElement checkoutBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement checkoutBtn = notificationPopUp().findElement(By.cssSelector("div.form-row > div:nth-child(2) > a"));
        return wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
    }

    private WebElement notificationPopUp() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return driver.findElement(By.id("notification-box-top"));
    }

    private WebElement palmTreoCameraLens() {
        return driver.findElement(By.cssSelector(".product-layout"));
    }
}

