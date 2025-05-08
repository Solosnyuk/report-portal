package taskUi.reportPortal;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWidgetTest extends BaseUiTest {

    @Test
    public void testNewWidgetCreation() {
        String nameDashboard = generateName();
        String nameWidget = generateName();

        DashboardsPage dashboardsPage = new LoginPage(getDriver())
                .login("default", "1q2w3e")
                .goDashboards()
                .addNewDashboard(nameDashboard, "Test board")
                .addNewWidget(nameWidget, "Max");

        Assert.assertEquals(dashboardsPage.getNameWidget(), nameWidget);
    }
}
