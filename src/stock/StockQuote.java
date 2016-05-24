package stock;
import java.util.Date;

/**
 * this class is where all the data from the apis
 * are stored, data should all be formated before
 * parsing to the constructor
 * author: Caitlynn and Dawood
 * version: 1.0
 */
public class StockQuote extends Observable{

    private StockInfo stockInfo;


    /**
     * this is the stockquote constructor
     * @param asymbol
     * @param alastTrade
     * @param adate
     * @param atime
     * @param achange
     * @param aopen
     * @param adayHigh
     * @param adayLow
     * @param avolumn
     */
    public StockQuote(String asymbol, Double alastTrade, Date adate, Date atime, Double achange, Double aopen, Double adayHigh, Double adayLow, Double avolumn){
        this.stockInfo = new StockInfo();
        this.stockInfo.symbol = asymbol;
        this.stockInfo.lastTrade = alastTrade;
        this.stockInfo.date = adate;
        this.stockInfo.time = atime;
        this.stockInfo.change = achange;
        this.stockInfo.open = aopen;
        this.stockInfo.dayhigh = adayHigh;
        this.stockInfo.daylow = adayLow;
        this.stockInfo.volumn = avolumn;

    }

    /**
     * this update function only notify the observers
     */
    public void update(){
        this.notifyObservers();
    }


    /**
     * this function return the stockInfo of a stockQuote
     * @return StockInfo
     */
    public StockInfo getInfo() {
        return this.stockInfo;
    }


}
