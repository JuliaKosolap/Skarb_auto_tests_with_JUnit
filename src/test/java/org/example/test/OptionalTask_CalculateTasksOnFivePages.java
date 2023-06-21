package org.example.test;

import org.example.pages.BasePage;
import org.example.pages.HomePage;
import org.example.pages.PartnerTasksPage;
import org.example.pages.TasksType;
import org.example.setup.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OptionalTask_CalculateTasksOnFivePages extends BaseTest {
    private String baseUrl = "https://skarb.foxminded.ua/";
    @BeforeMethod
    public void testSetUp() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    //This method opens the Volunteer Tasks Page
    private PartnerTasksPage goToPartnersTasksPage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());
        return (PartnerTasksPage) homePage.goToTasksPage(TasksType.PARTNERS);
    }
    @Test
    public void calculateNumberOfTasksOnFivePages() throws InterruptedException {
        PartnerTasksPage partnerTasksPage = goToPartnersTasksPage();
        ArrayList<String> listOfTasks = partnerTasksPage.getListOfTasksForGivenNumberOfPages(5);
        System.out.println(listOfTasks.size());
        for (int i = 0; i < listOfTasks.size(); i++) {
            System.out.println("Task #" + (i + 1) + ": " + listOfTasks.get(i));
        }
        System.out.println("Overall number of tasks on 5 pages is: " + listOfTasks.size());

    }
}
