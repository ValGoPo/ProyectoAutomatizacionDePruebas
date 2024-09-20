package com.example.proyectoautomatizacion;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("CheckoutTest Functionality")
@Feature("CheckoutTest Tests")
public class CheckoutTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Se inicia sesion para verificar el checkout
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }

    @Test(description = "TEST CASE - PROBAR COMPLETAR LA INFORMACION DE USUARIO PARA EL CHECKOUT", groups = {"Checkout"})
    @Severity(SeverityLevel.BLOCKER)
    @Story("Agregar al carrito, verifica carrito y hace checkout")
    @Description("Esta prueba verifica la funcionabilidad completa del checkout de compras.")
    public void testCheckout() throws InterruptedException {
        //Se agrega un producto
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        Thread.sleep(1000);

        //Se va al apartado de carrito
        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();

        //Se hace click en checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Thread.sleep(3000);

        //Se rellena la informacion del usuario
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement postalCode = driver.findElement(By.id("postal-code"));
        firstName.sendKeys("Valeria");
        lastName.sendKeys(" Gonzalez");
        postalCode.sendKeys("30701");
        Thread.sleep(3000);

        //Se continua con el checkout
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        Thread.sleep(3000);

        //TEST CASE - VERIFICAR LA PAGINA DE CONFIRMACION DE LA ORDEN
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        //TEST CASE - PROBAR LA VISUALIZACION DE COMPRA EXITOSA
        WebElement orderConfirmation = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(orderConfirmation.isDisplayed());
        Thread.sleep(3000);
    }

    @AfterMethod
    public void CloseChrome() {
        driver.quit();
    }
}
