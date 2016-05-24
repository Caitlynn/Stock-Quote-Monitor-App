package stock;

import StockQuoteTLService.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

/**
 * this class implements the StockQuoteServiceInterface's function getQuote
 * by calling the api functions and format the data got from the api
 * this class also has it's own thread, to make sure the data gets updated
 * every 5 seconds
 *
 * author: Caitlynn and Dawood
 * version: 1.0
 */

public class TimeLapseService extends Thread implements StockQuoteServiceInterface{
    private String symbol;
    private StockQuote newstock;

    /**
     * this is the contructor of this class
     */
    public TimeLapseService(){
        start();
    }

    /**
     * this function override the interface's function
     * and cast the data into the right format
     * @param symbol
     * @return StockQuote
     */
    @Override
    public StockQuote getQuote(String symbol) {
        this.symbol = symbol;
        Date date = null;
        Date time = null;
        List<String> stockInfo;


        StockQuoteTimeLapseService s = new StockQuoteTimeLapseService();
        stockInfo = s.getStockQuoteTimeLapseServiceHttpSoap12Endpoint().getStockQuote(symbol);
        //transfer the data into Date format
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String dateInStr = stockInfo.get(2);

        try{
            date = dateformat.parse(dateInStr);
        } catch(ParseException e){
            e.printStackTrace();
        }

        //transfer the string time into time type
        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm");
        String timeInStr = stockInfo.get(3);

        try{
            time = timeformat.parse(timeInStr);
        } catch (ParseException e){
            e.printStackTrace();
        }


        StockInfo si = newstock.getInfo();
        si.symbol = stockInfo.get(0);
        si.lastTrade = Double.parseDouble(stockInfo.get(1))/100;
        si.date = date;
        si.time = time;
        si.change = Double.parseDouble(stockInfo.get(4))/100;
        si.open = Double.parseDouble(stockInfo.get(5))/100;
        si.dayhigh = Double.parseDouble(stockInfo.get(6))/100;
        si.daylow = Double.parseDouble(stockInfo.get(7))/100;
        si.volumn = Double.parseDouble(stockInfo.get(8));
        newstock.update();

        return newstock;


    }

    /**
     * set the input StockQuote to newstock
     * @param s
     */
    @Override
    public void setStockQuote(StockQuote s){
        this.newstock = s;
    }

    /**
     * override the function from Thread
     * calls getQuote function every 1 minute
     */
    @Override
    public void run(){
        while (true){
            getQuote(this.symbol);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }




}
