package org.jbehave.osgi.examples.trader.model;

import static org.jbehave.osgi.examples.trader.model.Stock.AlertStatus.OFF;
import static org.jbehave.osgi.examples.trader.model.Stock.AlertStatus.ON;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    public enum AlertStatus {
        ON, OFF
    };

	private String symbol;
    private double alertPrice;
    private AlertStatus status = OFF;
    private List<Double> prices = new ArrayList<Double>();

    public Stock(String symbol, double alertPrice) {
        this.symbol = symbol;
        this.alertPrice = alertPrice;
    }

    public String getSymbol(){
    	return symbol;
    }
    
    public void tradeAt(double price) {
        this.prices.add(price);
        if (price > alertPrice) {
            status = ON;
        }
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void resetAlert() {
        status = OFF;
    }

    public AlertStatus getStatus() {
        return status;
    }

}
