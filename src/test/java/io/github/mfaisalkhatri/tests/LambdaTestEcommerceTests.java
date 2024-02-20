package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.pages.HomePage;
import io.github.mfaisalkhatri.pages.LoginPage;
import io.github.mfaisalkhatri.pages.ProductPage;
import org.testng.annotations.Test;


import static java.text.MessageFormat.format;
import static org.testng.Assert.assertEquals;

public class LambdaTestEcommerceTests extends BaseTest{

    @Test
    public void testLogin() {
        final HomePage homePage = new HomePage(this.driverManager.getDriver());
        homePage.navigateToLoginPage();
        final LoginPage loginPage = new LoginPage(this.driverManager.getDriver());
        loginPage.login(System.getProperty("username"),System.getProperty("password"));
        assertEquals(loginPage.getMyAccountPageHeader(),"My Account");
    }

    @Test
    public void testSearchProduct() {
        final String productName = "Palm Treo Pro";
        final HomePage homePage = new HomePage(this.driverManager.getDriver());
        homePage.searchProduct(productName);
        assertEquals(homePage.searchResultText(), productName);
    }

    @Test
    public void testAddProductToCart ()  {
        final ProductPage productPage = new ProductPage(this.driverManager.getDriver());
        productPage.addPalmTreoCameraLensToCart();
        final String expectedMessage = "{0}\n{1}\n{2}\n{3}\n{4}";
        assertEquals(productPage.successMessageText(), format(expectedMessage, "Success: You have added", "Palm Treo Pro", "to your",
                "shopping cart", "!"));
        productPage.checkoutProduct();
    }
}
