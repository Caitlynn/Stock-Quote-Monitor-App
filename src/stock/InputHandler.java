package stock;

import javax.swing.*;

/**
 * this class takes the input data from App Display class
 * and choose the right API to use and choose the right format
 * of the monitor to display
 *
 * author: Caitlynn and Dawood
 * version: 1.0
 */
public class InputHandler{

    private String symbol;
    private boolean isNumerical;
    private boolean isSQSapi;
    private StockQuote stockQuote;
    private Monitor monitor;

    /**
     * this constructor is used to take the information from
     * the app window
     *
     * @param symbol
     * @param isNumerical
     * @param isSQSapi
     */
    public InputHandler(String symbol, boolean isNumerical, boolean isSQSapi) {
        this.symbol = symbol;
        this.isNumerical = isNumerical;
        this.isSQSapi = isSQSapi;
        this.stockQuote = new StockQuote(null,null,null,null,null,null,null,null,null);
        this.monitor = null;
    }

    /**
     * this function choose the right api
     * and initialise a stock quote service to
     * get data
     *
     */
    public void ChooseAPI(){
        if(isSQSapi){
            StockQuoteServiceInterface stockQuoteService = new StockQuoteService();
            stockQuoteService.setStockQuote(this.stockQuote);
            this.stockQuote = stockQuoteService.getQuote(this.symbol);

        } else {
            StockQuoteServiceInterface timeLapseService = new TimeLapseService();
            timeLapseService.setStockQuote(this.stockQuote);
            this.stockQuote = timeLapseService.getQuote(this.symbol);

        }
    }

    /**
     * this returns a JPanel with either text or graph
     * depends on users' choices
     *
     * @return JPanel
     */
    public JPanel ChooseMonitor(){
        if (this.isNumerical){
            this.monitor = new TextMonitor(this.stockQuote);
            return (this.monitor.getPanel());
        } else {
            this.monitor = new GraphicMonitor(this.stockQuote);
            return(this.monitor.getPanel());
        }

    }

   }