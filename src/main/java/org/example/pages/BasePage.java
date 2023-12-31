package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

}
