package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Ejecutar en modo headless
        driver = new ChromeDriver(options); // Asegúrate de tener el ChromeDriver en el PATH
        driver.manage().window().maximize();
    }

    // TestNG test case to open the home page
    @Test
    public void openHomePage() {
        driver.get("https://the-internet.herokuapp.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet");
    }

    //Test case for a/bTcontrol
    @Test
    public void abTcontrol(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTcontrolButton = driver.findElement(By.cssSelector("a[href='/abtest']"));
        abTcontrolButton.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/abtest");
        
        String text = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertTrue(text.contains("This is a way in which businesses are able to simultaneously"));
    
    }

    // Test case for Login
    @Test
    public void loginCorrecto() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();

        String mensaje = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(mensaje.contains("You logged into a secure area!"));
    }

    //Test for basic authentication 
    @Test
    public void basicAuth() {

        driver.get("https://the-internet.herokuapp.com/");
        WebElement basicAuthButton = driver.findElement(By.cssSelector("a[href='/basic_auth']"));
        basicAuthButton.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/basic_auth");

        // In this case, we need to use the username and password in the URL

        String username = "admin";
        String password = "admin";
        String urlWithAuth = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(urlWithAuth);
        String mensaje = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertTrue(mensaje.contains("Congratulations! You must have the proper credentials."));

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
