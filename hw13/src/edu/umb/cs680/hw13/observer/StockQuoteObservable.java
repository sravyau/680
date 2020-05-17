package edu.umb.cs680.hw13.observer;

import java.util.Observable;

public class StockQuoteObservable extends Observable {

	public void changeQuote(String t, float q) {
		this.setChanged();
		this.notifyObservers(new StockEvent(t, q));
	}
}
