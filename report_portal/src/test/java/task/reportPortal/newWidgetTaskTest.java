package task.reportPortal;

import org.testng.Assert;
import org.testng.annotations.Test;

public class newWidgetTaskTest extends BaseTest {
    @Test
    public void NewWidgetTaskProgressTest() {
        String nameDashboard = generateName();
        String nameWidget = generateName();

        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        DashboardsPage dashboardsPage = new DashboardsPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("default", "1q2w3e");
        launchesPage.goDashboards();
        dashboardsPage.addNewDashboard(nameDashboard, "Test board");
        dashboardsPage.addNewWidget(nameWidget, "Max");

        Assert.assertEquals(dashboardsPage.getNameWidget(), nameWidget);
    }
}
