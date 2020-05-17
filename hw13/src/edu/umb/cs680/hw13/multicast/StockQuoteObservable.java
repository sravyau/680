package edu.umb.cs680.hw13.multicast;

import java.util.ArrayList;

public class StockQuoteObservable {

	public ArrayList<StockQuoteObserver> observers = new ArrayList<StockQuoteObserver>();
	private boolean changed;

	public void changeQuote(String t, float q) {
		setChanged();
		notifyObservers(new StockEvent(t, q));
	}

	public void addObserver(StockQuoteObserver observer) {
		this.observers.add(observer);
	}

	public void setChanged() {
		this.changed = true;
	}

	public boolean hasChanged() {
		return this.changed;
	}

	public void clearChanged() {
		this.changed = false;
	}

	public void notifyObservers(StockEvent arg) {
		if (hasChanged()) {
			for (StockQuoteObserver o : this.observers) {
				o.updateStock(arg);
			}
			clearChanged();
		}
	}
}
