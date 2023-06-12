package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    private WebElement emailField() {
        return driver.findElement(By.id("input-email"));
    }
    private WebElement passwordField() {
        return driver.findElement(By.id("input-password"));
    }

    private WebElement loginBtn() {
        return driver.findElement(By.cssSelector("input.btn-primary"));
    }

    public void login (String email, String password) {
        emailField().clear();
        emailField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
    }

    public String getMyAccountPageHeader() {
        return driver.findElement(By.tagName("h2")).getText();
    }
}
