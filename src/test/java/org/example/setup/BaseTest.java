package org.example.setup;

import org.example.pages.WebDriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.example.common.Props.initProperties;
import static org.example.common.Props.resetProperties;


public class BaseTest {
    protected static WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeAll
    public static void setUp(){
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeEach
    public void testSetUp() throws IOException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        initProperties();
    }

    @AfterAll
    public static void tearDown(){
        resetProperties();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
    //method that allows to switch between windows in a current browser
    public void switchBetweenWindows() {
        String parentPage = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parentPage.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }
}
