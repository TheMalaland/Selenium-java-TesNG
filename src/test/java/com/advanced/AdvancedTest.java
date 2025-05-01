package com.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;


//         driver.get("https://the-internet.herokuapp.com/basic_auth");



public class AdvancedTest {
    WebDriver driver;


    @BeforeClass
    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Ejecutar en modo headless
        driver = new ChromeDriver(options); // Asegúrate de tener el ChromeDriver en el PATH
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //run the test for dropdown feature
    @Test
    public void dropdownFeature(){

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.cssSelector("div[class='example'] h3"));
        String text = dropdown.getText();
        Assert.assertEquals(text, "Dropdown List");

    }

    //run the test for dropdown feature text

    @Test
    public void dropdownFeatureText() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Localizar el menú desplegable
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // Usar la clase Select para manejar el menú desplegable
        Select select = new Select(dropdown);

        // Obtener la opción seleccionada actualmente
        String selectedOption = select.getFirstSelectedOption().getText();

        // Verificar que la opción seleccionada sea "Please select an option"
        Assert.assertEquals(selectedOption, "Please select an option");
    }





    
}
