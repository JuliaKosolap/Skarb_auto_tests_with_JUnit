package org.example.test;

import org.example.pages.EntityType;
import org.example.pages.HomePage;
import org.example.pages.tasks.PartnerTasksPage;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.example.common.CustomLogger.logger;

public class OptionalTask_CalculateTasksOnFivePages extends BaseTest {

    @Test
    public void calculateNumberOfTasksOnFivePages() throws InterruptedException {
        logger.info("Partners Tasks Page was opened");
        PartnerTasksPage partnerTasksPage = (PartnerTasksPage) (new HomePage(driver)).goToTasksPage(EntityType.PARTNERS);

        logger.info("The list of tasks for Partners on 5 pages are collected");
        ArrayList<String> listOfTasks = partnerTasksPage.getListOfTasksForGivenNumberOfPages(5);

        partnerTasksPage.printTheNamesOfTheTasks(listOfTasks);
        System.out.println("Overall number of tasks on 5 pages is: " + listOfTasks.size());

    }
}
