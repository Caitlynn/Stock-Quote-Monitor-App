package stock;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * this class extends ApplicationFrame to make a line chart
 *
 * param:String chartTitle
 * exception: N/A
 * return: N/A
 * author: Caitlynn and Dawood
 * version: 1.0
 */
public class GenerateGraph  extends ApplicationFrame {
    private DefaultCategoryDataset dataset;
    private ChartPanel chartPanel;


    /**
     * this function initialise a line chart
     * @param chartTitle
     */
    public GenerateGraph(String chartTitle) {
        super("supertitle");

        JFreeChart chart = ChartFactory.createLineChart(
                chartTitle,
                "Time",
                "Price $",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600,300));

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        axis.setAutoRangeIncludesZero(false);

        setContentPane(chartPanel);
    }

    /**
     * this function initialise dataset
     * @return DefaultCategoryDataset
     */
    private DefaultCategoryDataset createDataset(){
        dataset = new DefaultCategoryDataset();

        return dataset;
    }

    /**
     * this function add the input time and price
     * to the current dataset
     * @param time
     * @param price
     */
    public void addData(String time, double price){
        dataset.addValue(price, "Price $", time );
    }

    /**
     * this function returns  the current chartPanel
     * @return chartPanel
     */
    public ChartPanel getChartPanel(){
        return this.chartPanel;
    }
}

