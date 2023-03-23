package org.lev.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CommonPage {

    protected static final By SUMMARY_FIELD = By.xpath("//div[text()='Summary']");
    protected static final By GRID_AND_CHART_FIELD = By.xpath("//div[contains(text(), 'Grid')]");
    protected static final By HISTOGRAM_FIELD = By.xpath("//div[text()='Histogram']");
    protected static final By SCATTER_PLOT_FIELD = By.xpath("//div[text()='Scatter-plot']");
    protected static final By REPORTS_FIELD = By.xpath("//div[text()='Reports']");

    //Summary tab
    private final By algoPerformanceTable = By.xpath("//div[@class='app-title flex-1 widget__header'][contains(text(), 'Performance')]/../../..");

    //Grid&chart tab
    private final By ordersGridTable = By.xpath("//div[@class='app-title flex-1 widget__header']/../../..");
    private final By ordersGridTableHeader = By.xpath("//div[@class='app-title flex-1 widget__header']");
    private final By gridIdColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Id')]/../../..");
    private final By gridTypeColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Type')]/../../..");
    private final By gridInstrumentColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Instrument')]/../../..");
    private final By gridSideColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Side')]/../../..");
    private final By gridStartTimeColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Start')]/../../..");
    private final By gridEndTimeColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'End')]/../../..");
    private final By gridExecTypeColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Exec')][contains(text(), 'type')]/../../..");
    private final By gridExecSizeColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Exec')][contains(text(), 'size')]/../../..");
    private final By gridSizeColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Size')]/../../..");
    private final By gridShortfallColumnHeader = By.xpath("//span[@class='ag-header-cell-text'][contains(text(), 'Shortfall')]/../../..");

    By horizontalScroll = By.xpath("//div[@class='ag-body-horizontal-scroll-viewport']");

    //Histogram tab
    By attributeChose = By.xpath("//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid'][@title='Price imp. (amount)']");
    By intervalInput = By.xpath("//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid'][@title='50']");

    //ScatterplotPage tab
    By scatterPlotContainer = By.xpath("//div[@class='scatter-plot-container']");
    By scatterPlotInputs = By.xpath("//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid']");


    public SelenideElement getSummaryElement() {
        $(SUMMARY_FIELD).shouldBe(visible);
        return $(SUMMARY_FIELD);
    }

    public SelenideElement getGridAndChartElement() {
        $(GRID_AND_CHART_FIELD).shouldBe(visible);
        return $(GRID_AND_CHART_FIELD);
    }

    public SelenideElement getHistogramElement() {
        $(HISTOGRAM_FIELD).shouldBe(visible);
        return $(HISTOGRAM_FIELD);
    }

    public SelenideElement getScatterPlotElement() {
        $(SCATTER_PLOT_FIELD).shouldBe(visible);
        return $(SCATTER_PLOT_FIELD);
    }

    public SelenideElement getReportsElement() {
        $(REPORTS_FIELD).shouldBe(visible);
        return $(REPORTS_FIELD);
    }

    public void goToSummary(){
        $(SUMMARY_FIELD).shouldBe(visible).click();
    }

    public void goToGridAndChart(){
        $(GRID_AND_CHART_FIELD).shouldBe(visible).click();
    }

    public void goToHistogram(){
        $(HISTOGRAM_FIELD).shouldBe(visible).click();
    }

    public void goToScatterPlot(){
        $(SCATTER_PLOT_FIELD).shouldBe(visible).click();
    }

    public void getAlgoPerformanceTableElement(){
        $(algoPerformanceTable).shouldBe(visible);
    }

    public void getOrdersGridTableElements(){
        $(ordersGridTable).shouldBe(visible);
        $(ordersGridTableHeader).shouldBe(visible);
        $(gridIdColumnHeader).shouldBe(exist);
        $(gridTypeColumnHeader).shouldBe(exist);
        $(gridInstrumentColumnHeader).shouldBe(exist);
        $(gridSideColumnHeader).shouldBe(exist);
        $(gridStartTimeColumnHeader).shouldBe(exist);
        $(gridEndTimeColumnHeader).shouldBe(exist);
        $(gridExecTypeColumnHeader).shouldBe(exist);
        $(gridExecSizeColumnHeader).shouldBe(exist);
        SelenideElement element = $(horizontalScroll);
        executeJavaScript("arguments[0].scrollLeft +=1350", element);
        $(gridSizeColumnHeader).shouldBe(exist);
        $(gridShortfallColumnHeader).shouldBe(exist);
    }

    public void getAttributeField(){
        $(attributeChose).shouldBe(visible);
        $(intervalInput).shouldBe(visible);
    }

    public int getScatterPlotFields(){
        $(scatterPlotContainer).shouldBe(visible);
        ElementsCollection inputs = $$(scatterPlotInputs);
        for (SelenideElement element: inputs)
             {
            element.shouldBe(visible);
        }
        return inputs.size();
    }
}
