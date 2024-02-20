package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage (final WebDriver driver){
        this.driver = driver;
    }

    private WebElement emailField() {
        return this.driver.findElement(By.id("input-email"));
    }
    private WebElement passwordField() {
        return this.driver.findElement(By.id("input-password"));
    }

    private WebElement loginBtn() {
        return this.driver.findElement(By.cssSelector("input.btn-primary"));
    }

    public void login (final String email, final String password) {
        emailField().clear();
        emailField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
    }

    public String getMyAccountPageHeader() {
        return this.driver.findElement(By.tagName("h2")).getText();
    }
}
