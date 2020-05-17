package edu.umb.cs680.hw13.multicast;

import java.util.ArrayList;

public class DJIAQuoteObservable {

	public ArrayList<DJIAQuoteObserver> observers = new ArrayList<DJIAQuoteObserver>();
	private boolean changed;

	public void changeQuote(float q) {
		setChanged();
		notifyObservers(new DJIAEvent(q));
	}

	public void addObserver(DJIAQuoteObserver observer) {
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

	public void notifyObservers(DJIAEvent arg) {
		if (hasChanged()) {
			for (DJIAQuoteObserver o : this.observers) {
				o.updateDJIA(arg);
			}
			clearChanged();
		}
	}

}