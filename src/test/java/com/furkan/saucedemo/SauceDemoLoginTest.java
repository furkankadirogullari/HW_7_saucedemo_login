package com.furkan.saucedemo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemoLoginTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        try {
            Thread.sleep(3000); // Wait three seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    @Order(1)
    void loginWithStandardUser() {
        login("standard_user", "secret_sauce");
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @Order(2)
    void loginWithProblemUser() {
        login("problem_user", "secret_sauce");
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @Order(3)
    void loginWithPerformanceGlitchUser() {
        login("performance_glitch_user", "secret_sauce");
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @Order(4)
    void loginWithLockedOutUser_shouldShowErrorMessage() {
        login("locked_out_user", "secret_sauce");
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorMsg.isDisplayed());
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMsg.getText());
    }
}
