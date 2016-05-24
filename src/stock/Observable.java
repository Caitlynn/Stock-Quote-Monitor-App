package stock;

import java.util.HashMap;

/**
 * customise the Observable class
 *
 * author: Caitlynn and Dawood
 * version: 1.0
 */
public abstract class Observable {

    //using a HashMap here to avoid same observers
    private HashMap<Observer,Observer> observers = new HashMap<>();

    public void notifyObservers(){
        for (Observer o: this.observers.values()){
            o.update();
        }
    }

    public void addObserver(Observer o){
        this.observers.put(o,o);
    }

    public void removeObserver(Observer o){
        this.observers.remove(o);
    }

}
