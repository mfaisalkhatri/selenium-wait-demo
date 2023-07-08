package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
    }

    private WebElement searchField() {
        return this.driver.findElement(By.name("search"));
    }

    private WebElement searchBtn() {
        return this.driver.findElement(By.cssSelector("button[type='submit'][class='type-text']"));
    }

    public void searchProduct(final String productName) {
        searchField().clear();
        searchField().sendKeys(productName);
        searchBtn().click();
    }

    public String searchResultText() {
        return this.driver.findElement(By.cssSelector("div.product-layout:nth-child(1) div:nth-child(1) h4 > a.text-ellipsis-2")).getText();
    }

    public void navigateToLoginPage() {
        this.driver.findElement(By.linkText("My account"))
                .click();
        this.driver.findElement(By.linkText("Login")).click();
    }
}
