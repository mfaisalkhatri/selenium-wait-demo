package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement searchField() {
        return driver.findElement(By.name("search"));
    }

    private WebElement searchBtn() {
        return driver.findElement(By.cssSelector("button[type='submit'][class='type-text']"));
    }

    public void searchProduct(String productName) {
        searchField().clear();
        searchField().sendKeys(productName);
        searchBtn().click();
    }

    public String searchResultText() {
        return driver.findElement(By.cssSelector("div.product-layout:nth-child(1) div:nth-child(1) h4 > a.text-ellipsis-2")).getText();
    }

    public void navigateToLoginPage() {
        driver.findElement(By.linkText("My account"))
                .click();
        driver.findElement(By.linkText("Login")).click();
    }
}
