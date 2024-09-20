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


@Epic("Login Functionality")
@Feature("Login Tests")
public class LoginTest {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        // Navegar a la página principal antes de cada prueba
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @Test(description = "TEST CASE - PRUEBA DE LOGIN EXITOSO CON CREDENCIALES VALIDAS", groups = {"login"})
    @Step("Ejecutando prueba de inicio de sesión como {user}")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login con credenciales correctas")
    @Description("Esta prueba verifica que un usuario puede hacer login exitosamente con credenciales válidas.")
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

    @Test(description = "TEST CASE - PRUEBA DE LOGIN FALLIDO CON CREDENCIALES INVALIDAS", groups = {"login"})
    @Severity(SeverityLevel.NORMAL)
    @Story("Login con credenciales incorrectas")
    @Description("Esta prueba verifica que un usuario no puede hacer login con credenciales inválidas.")
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

//allure serve allure-results

