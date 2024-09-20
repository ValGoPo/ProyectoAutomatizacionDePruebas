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


@Epic("Logout Functionality")
@Feature("Logout Tests")
public class LogoutTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        //Se inicia sesion para el test
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Thread.sleep(2000);
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(2000);
    }

    @Test(description = "TEST CASE - PRUEBA DONDE SE VE REFLEJADO EL LOGOUT DE LA CUENTA", groups = {"login"})
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Salir de la sesión activa")
    @Description("Esta prueba verifica que un usuario puede salir de su sesión activa en la web.")
    public void testLogout() throws InterruptedException {
        //Se mapean selectores de la web para el Logout
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        Thread.sleep(2000);

        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();
        Thread.sleep(2000);

        //TEST CASE - VERIFICAR QUE EL USUARIO ES REDIRIGIDO A LA PAGINA DE LOGIN DESPUES DEL LOGOUT
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://www.saucedemo.com/"));
    }

    @AfterMethod
    public void CloseChrome() {
        driver.quit();
    }
}

