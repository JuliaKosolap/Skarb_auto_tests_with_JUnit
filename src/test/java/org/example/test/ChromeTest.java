package org.example.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void goToHomePageTest() {
        WebElement title = driver.findElement(By.cssSelector("h4.text-dark-red"));
        Assertions.assertEquals(title.getText(), "SKARB NGO");
    }
    @Test
    public void checkContactUsTest() throws InterruptedException {
        WebElement contactUs = driver.findElement(By.partialLinkText("Contact us"));
        contactUs.click();
        WebElement page = driver.findElement(By.cssSelector("title.info_title.title--red"));
        Assertions.assertEquals(page.getText(), "Contact us");

    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
