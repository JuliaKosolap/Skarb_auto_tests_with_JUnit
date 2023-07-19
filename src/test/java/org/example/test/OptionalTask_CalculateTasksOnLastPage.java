package org.example.test;

import org.example.pages.EntityType;
import org.example.pages.HomePage;
import org.example.pages.tasks.PartnerTasksPage;
import org.example.pages.tasks.VolunteerTasksPage;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.common.CustomLogger.logger;


public class OptionalTask_CalculateTasksOnLastPage extends BaseTest {

    @Test
    public void calculateNumberOfPartnerTasksOnLastPage() {
        logger.info("Partners Tasks Page was opened");
        PartnerTasksPage partnerTasksPage = (PartnerTasksPage) (new HomePage(driver)).
                goToTasksPage(EntityType.PARTNERS);

        logger.info("The list of tasks on the last page are collected");
        List<String> taskNames = partnerTasksPage.getListOfTasksOnLastPage();

        System.out.println("The tasks number on the last page is: " + taskNames.size());
        partnerTasksPage.printTheNamesOfTheTasks(taskNames);
    }
    @Test
    public void calculateNumberOfVolunteerTasksOnLastPage() {
        logger.info("Volunteers Tasks Page was opened");
        VolunteerTasksPage volunteerTasksPage = (VolunteerTasksPage) (new HomePage(driver)).
                goToTasksPage(EntityType.VOLUNTEERS);


        List<String> taskNames = volunteerTasksPage.getListOfTasksOnLastPage();


        System.out.println("The tasks number on the last page is: " + taskNames.size());
        volunteerTasksPage.printTheNamesOfTheTasks(taskNames);
    }
}
