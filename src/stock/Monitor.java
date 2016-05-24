package stock;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * this abstract class represents a type: Monitor
 * we have different types of monitors: numerical and graphical
 * we have 3 attributes, to store information
 * we have a jPanel as attribute to render the data to the front end
 */
public abstract class Monitor extends DefaultTableCellRenderer implements Observer {

    protected StockQuote stockQuote;
    protected StockInfo stockInfo;
    protected JPanel jPanel;

    /**
     * super constructor
     * @param s
     */
    public Monitor(StockQuote s){
        this.stockQuote = s;
        this.jPanel = new JPanel();
        this.stockInfo = s.getInfo();
        this.stockQuote.addObserver(this);
        this.generateMonitor(stockInfo);
    }

    /**
     * different kinds of monitor can implement
     * generating monitor in different ways
     * @param s
     */
    protected abstract void generateMonitor(StockInfo s);

    /**
     * different kinds of monitor might have different
     * ways to update monitors
     * @param s
     */
    protected abstract void updateMonitor(StockInfo s);

    /**
     * return the jPanel
     * @return JPanel
     */
    public JPanel getPanel(){
        return jPanel;
    }

    /**
     * override the update function from Observer class
     * by calling it's own update function and also update
     * the stockInfo
     */
    @Override
    public void update(){
        this.stockInfo = stockQuote.getInfo();
        this.updateMonitor(this.stockInfo);
    }

}
