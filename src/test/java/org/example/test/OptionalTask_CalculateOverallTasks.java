package org.example.test;

import org.example.pages.EntityType;
import org.example.pages.HomePage;
import org.example.pages.tasks.PartnerTasksPage;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.example.common.CustomLogger.logger;
public class OptionalTask_CalculateOverallTasks extends BaseTest {

    @Test
    public void calculateNumberOfTasks() throws InterruptedException {
        logger.info("Partners Tasks Page was opened");
        PartnerTasksPage partnerTasksPage = (PartnerTasksPage) (new HomePage(driver)).goToTasksPage(EntityType.PARTNERS);

        logger.info("The last page number was received");
        int lastPageNumber = Integer.parseInt(partnerTasksPage.getTheLastPageNumber());

        logger.info("The list of overall tasks for Partners are collected");
        ArrayList<String> listOfTasks =  partnerTasksPage.getListOfTasksForGivenNumberOfPages(lastPageNumber);

        partnerTasksPage.printTheNamesOfTheTasks(listOfTasks);
        System.out.println("Overall number of tasks is: " + listOfTasks.size());
        }

}
