package org.lev;

import com.codeborne.selenide.SelenideElement;
import org.lev.pages.AuthorizationPage;
import org.lev.pages.CommonPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.lev.TestConstant.GRID_AND_CHART;
import static org.lev.TestConstant.HISTOGRAM;
import static org.lev.TestConstant.REPORTS;
import static org.lev.TestConstant.SCATTER_PLOT;
import static org.lev.TestConstant.SUMMARY;

public class TestAuthorizationPage extends BaseTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    CommonPage commonPage = new CommonPage();

    @BeforeTest
    public void passAuthorization(){
        authorizationPage.getAuthorization();
        //Ожидание для запуска с мобильного интернета, т.к. он медленный и не успевает (((
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAuthorizationUser() {
        SelenideElement summaryElement = commonPage.getSummaryElement();
        SelenideElement gridAndChartElement = commonPage.getGridAndChartElement();
        SelenideElement histogramElement = commonPage.getHistogramElement();
        SelenideElement scatterPlotElement = commonPage.getScatterPlotElement();
        SelenideElement reportsElement = commonPage.getReportsElement();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(summaryElement.getText(), SUMMARY);
        soft.assertEquals(gridAndChartElement.getText(), GRID_AND_CHART);
        soft.assertEquals(histogramElement.getText(), HISTOGRAM);
        soft.assertEquals(scatterPlotElement.getText(), SCATTER_PLOT);
        soft.assertEquals(reportsElement.getText(), REPORTS);
        soft.assertAll();
    }
}
