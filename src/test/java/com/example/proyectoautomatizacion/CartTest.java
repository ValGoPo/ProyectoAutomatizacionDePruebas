package com.example.proyectoautomatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Se inicia sesion para hacer una compra
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }

    @Test //TEST CASE - PROBAR AGREGAR UN PRODUCTO AL CARRITO
    public void testAddToCart() throws InterruptedException {
        //SE MAPEA EL BOTON DE AGREGAR ITEM
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        Thread.sleep(2000);

        //TEST CASE - VERIFICAR LA CANTIDAD DE PRODUCTOS EN EL CARRITO
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "1");
    }

    @Test //TEST CASE - PROBAR ELIMINAR UN PRODUCTO DEL CARRITO
    public void testRemoveFromCart() throws InterruptedException {
        //SE AGREGA ALGO AL CARRITO
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        Thread.sleep(2000);

        //SE ELIMINA DEL CARRITO
        WebElement removeFromCartButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeFromCartButton.click();
        Thread.sleep(2000);

        //TEST CASE - VERIFICAR QUE EL CARRITO ESTA VACIO DESPUES DE ELIMINAR UN PRODUCTO
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue(cartBadge == null || cartBadge.getText().isEmpty());
    }
    @AfterMethod
    public void CloseChrome() {
        driver.quit();
    }
}
