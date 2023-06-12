package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public void checkoutProduct() throws InterruptedException {
        Thread.sleep(2000);
        checkoutBtn().click();
    }

    public String successMessageText() throws InterruptedException {
        Thread.sleep(2000);
        return notificationPopUp().findElement(By.tagName("p"))
                .getText();
    }

    private WebElement addToCartBtn() {
        return driver.findElement(By.cssSelector("div.product-action > button.btn.btn-cart.cart-29"));
    }

    private WebElement checkoutBtn() {
        return notificationPopUp().findElement(By.cssSelector("div.form-row > div:nth-child(2) > a"));
    }

    private WebElement notificationPopUp() {
        return driver.findElement(By.id("notification-box-top"));
    }

    private WebElement palmTreoCameraLens() {
        return driver.findElement(By.cssSelector(".product-layout"));
    }
}

