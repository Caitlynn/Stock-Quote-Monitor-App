package stock;

import javax.swing.*;
import java.text.SimpleDateFormat;

/**
 * this class inherits Monitor class, and implements the abstract functions
 * from the super class, it also calls GenerateGraph class to generate
 * the line chart and set the line chart to a panel, and it renders the
 * the data to jPanel from the super class

 * author: Caitlynn and  Dawood
 * version: 1.0
 */
public class GraphicMonitor extends Monitor {

    protected GenerateGraph g;

    /**
     * initialise the class
     * @param stockInfo
     */
    public GraphicMonitor(StockQuote stockInfo) {
        super(stockInfo);

    }

    /**
     * override the abstract function by generating a graph
     * @param s
     */
    @Override
    protected void generateMonitor(StockInfo s) {
        this.g = new GenerateGraph(s.symbol);

    }

    /**
     * override the abstract function
     * call add data to update the graph by
     * adding more data to the graph
     *
     * @param s
     */
    @Override
    protected void updateMonitor(StockInfo s) {
        g.addData( new SimpleDateFormat("h:mm a").format(s.time), s.lastTrade);
    }

    /**
     * this function add the ChartPanel to jPanel and
     * returns the jPanel
     *
     * @return JPanel
     */
    public JPanel getPanel() {
        jPanel.add(g.getChartPanel());
        return jPanel;

    }

}



