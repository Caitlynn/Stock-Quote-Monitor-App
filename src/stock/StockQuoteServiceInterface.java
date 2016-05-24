package stock;

/**
 * this interface is for getting data from the web API
 * in case of the change of the API
 * we make an interface here
 * param: N/A
 * exception: N/A
 * return: List
 * author: Caitlynn and Dawood
 * version: 1.0
 */
public interface StockQuoteServiceInterface {
    void setStockQuote(StockQuote s);
    StockQuote getQuote(String symbol);
}