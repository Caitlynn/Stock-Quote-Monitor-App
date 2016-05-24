package stock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class inherits Monitor class, and implements the abstract functions
 * from the super class, it generates a textArea and add the textarea to jPanel
 * author: Caitlynn and Dawood
 * version: 1.0
 */
public class TextMonitor extends Monitor{

    private JTextArea textArea;

    /**
     * the constructor of this class
     * @param stockq
     */
    public TextMonitor(StockQuote stockq) {
        super(stockq);
    }

    /**
     * override the generateMonitor function to add information
     * to the textArea
     * @param s
     */
    @Override
    protected void generateMonitor(StockInfo s) {
        this.textArea = new JTextArea("Numerical stock information\n");

        appendSymbol(s.symbol);
        appendLastTrade(s.lastTrade);
        appendDate(s.date);
        appendTime(s.time);
        appendChange(s.change);
        appendOpen(s.open);
        appendDayHigh(s.dayhigh);
        appendDayLow(s.daylow);
        appendVolumn(s.volumn);

        this.jPanel.add(textArea, BorderLayout.NORTH);

    }

    /**
     * override the abstract function
     * update the stockInfo and the
     * textArea
     *
     * @param s
     */
    @Override
    protected void updateMonitor(StockInfo s) {
        stockInfo = s;
        this.textArea.setText("Numerical stock information\n");
        appendSymbol(s.symbol);
        appendLastTrade(s.lastTrade);
        appendDate(s.date);
        appendTime(s.time);
        appendChange(s.change);
        appendOpen(s.open);
        appendDayHigh(s.dayhigh);
        appendDayLow(s.daylow);
        appendVolumn(s.volumn);
    }

    /**
     * this function adds the symbol to the textArea
     * if the symbol is not null
     * @param symbol
     */
    private void appendSymbol(String symbol){
        if (symbol != null) {
            this.textArea.append("Stock symbol:\n" + symbol + "\n------------------------\n");
        }
    }

    /**
     * this function adds the last trade to the textArea
     * if the last trade is not null
     * @param lasttrade
     */
    private void appendLastTrade(Double lasttrade){
        if (lasttrade != null) {
            this.textArea.append("Last trade price(AU$):\n" + lasttrade.toString() + "\n------------------------\n");
        }
    }

    /**
     * this function adds the date to the textArea
     * if the date is not null
     * @param date
     */
    private void appendDate(Date date){
        if (date != null) {
            this.textArea.append("Date:\n" + new SimpleDateFormat("EEEE d/MMM/yyyy").format(date)+ "\n------------------------\n");
        }
    }

    /**
     * this function adds the time to the textArea
     * if the time is not null
     * @param time
     */
    private void appendTime(Date time){
        if (time != null)
            this.textArea.append("Time:\n" + new SimpleDateFormat("h:mm a").format(time) + "\n------------------------\n");
    }

    /**
     * this function adds the change to the textArea
     * if the change is not null
     * @param change
     */
    private void appendChange(Double change){
        if (change != null) {
            this.textArea.append("Different since last change(AU$):\n" + change + "\n------------------------\n");
        }
    }

    /**
     * this function adds the open to the textArea
     * if the open is not null
     * @param open
     */
    private void appendOpen(Double open){
        if (open != null) {
            this.textArea.append("Open price today(AU$):\n" + open + "\n------------------------\n");
        }
    }

    /**
     * this function adds the dayhigh to the textArea
     * if the dayhigh is not null
     * @param dayhigh
     */
    private void appendDayHigh(Double dayhigh){
        if (dayhigh != null) {
            this.textArea.append("Highest price today(AU$):\n" + dayhigh + "\n------------------------\n");
        }
    }

    /**
     * this function  adds the daylow to the textArea
     * if the daylow is not null
     * @param daylow
     */
    private void appendDayLow(Double daylow){
        if (daylow != null) {
            this.textArea.append("Lowest price today(AU$):\n" + daylow + "\n------------------------\n");
        }
    }

    /**
     * this function adds the volumn to the textArea
     * if the volumn is not null
     * @param volumn
     */
    private void appendVolumn(Double volumn){
        if (volumn != null) {
            this.textArea.append("Number of traded stocks today:\n" + volumn + "\n------------------------\n");
        }
    }

    /**
     * this function returns jPanel
     * @return Jpanel
     */
    @Override
    public JPanel getPanel(){
        return this.jPanel;
    }

}
