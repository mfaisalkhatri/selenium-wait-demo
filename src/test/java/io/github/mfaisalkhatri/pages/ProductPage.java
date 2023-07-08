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

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addPalmTreoCameraLensToCart() {
        final Actions actions = new Actions(this.driver);
        actions.moveToElement(palmTreoCameraLens())
                .pause(200)
                .moveToElement(addToCartBtn())
                .pause(100)
                .click()
                .perform();
    }

    public void checkoutProduct() {
        checkoutBtn().click();
    }

    public String successMessageText() {
        final Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        final WebElement successMessage = wait.until(driver -> notificationPopUp().findElement(By.tagName("p")));
        return successMessage.getText();    
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return notificationPopUp().findElement(By.tagName("p")).getText();
    }

    private WebElement addToCartBtn() {
        return this.driver.findElement(By.cssSelector("div.product-action > button.btn.btn-cart.cart-29"));
    }

    private WebElement checkoutBtn() {
        final WebElement checkoutBtn = notificationPopUp().findElement(By.cssSelector("div.form-row > div:nth-child(2) > a"));
        return this.wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return notificationPopUp().findElement(By.cssSelector("div.form-row > div:nth-child(2) > a"));
    }

    private WebElement notificationPopUp() {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification-box-top")));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //return driver.findElement(By.id("notification-box-top"));
    }

    private WebElement palmTreoCameraLens() {
        return this.driver.findElement(By.cssSelector(".product-layout"));
    }
}

