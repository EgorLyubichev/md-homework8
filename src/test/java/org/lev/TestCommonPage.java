package org.lev;

import org.lev.pages.CommonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCommonPage extends TestAuthorizationPage{

    CommonPage commonPage = new CommonPage();

    @Test
    public void testAlgoPerformanceTable() {
        commonPage.goToSummary();
        commonPage.getAlgoPerformanceTableElement();
    }

    @Test
    public void testGridOrdersTable() {
        commonPage.goToGridAndChart();
        commonPage.getOrdersGridTableElements();
    }

    @Test
    public void testHistogramFields(){
        commonPage.goToHistogram();
        commonPage.getAttributeField();
    }

    @Test
    public void testScatterPlotElements(){
        commonPage.goToScatterPlot();
        int size = commonPage.getScatterPlotFields();
        Assert.assertEquals(size, 3);
    }
}
