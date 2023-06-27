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
        HomePage homePage = new HomePage(driverManager.getDriver());
        homePage.navigateToLoginPage();
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.login(System.getProperty("username"),System.getProperty("password"));
        assertEquals(loginPage.getMyAccountPageHeader(),"My Account");
    }

    @Test
    public void testSearchProduct() {
        String productName = "Palm Treo Pro";
        HomePage homePage = new HomePage(driverManager.getDriver());
        homePage.searchProduct(productName);
        assertEquals(homePage.searchResultText(), productName);
    }

    @Test
    public void testAddProductToCart ()  {
        ProductPage productPage = new ProductPage(driverManager.getDriver());
        productPage.addPalmTreoCameraLensToCart();
        final String expectedMessage = "{0}\n{1}\n{2}\n{3}\n{4}";
        assertEquals(productPage.successMessageText(), format(expectedMessage, "Success: You have added", "Palm Treo Pro", "to your",
                "shopping cart", "!"));
        productPage.checkoutProduct();
    }
}
