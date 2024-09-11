package com.example.proyectoautomatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Navegar a la página principal antes de cada prueba
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test //TEST CASE - PROBAR LOGIN EXITOSO
    public void testValidLogin() throws InterruptedException {
        // Se mapea las rutas de los selectores de la web
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Thread.sleep(2000);

        // Se ingresa datos correctos de Login
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(2000);

        // Validar que el login fue exitoso
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/inventory.html"));
        Thread.sleep(1000);
    }

    @Test //TEST CASE - PROBAR LOGIN FALLIDO
    public void testInvalidLogin() throws InterruptedException {
        // Se mapea las rutas de los selectores de la web
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Thread.sleep(2000);

        // Se ingresa datos incorrectos de Login
        username.sendKeys("problem_user");
        password.sendKeys("password123");
        loginButton.click();
        Thread.sleep(2000);

        // Validar que el login fue fallido
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Thread.sleep(2000);
    }

    @AfterMethod
    public void CloseChrome() {
        driver.quit();
    }
}
