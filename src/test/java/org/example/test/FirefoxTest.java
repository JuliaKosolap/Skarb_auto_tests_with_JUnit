package org.example.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }
    @Test
    public void getToHomePageTest() {
        WebElement title = driver.findElement(By.cssSelector("h4.text-dark-red"));
        Assertions.assertEquals(title.getText(), "SKARB NGO");
    }
    @AfterEach
        public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
