package edu.umb.cs680.hw13.observer;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof StockEvent) {
			StockEvent stockEvent = (StockEvent) arg;
			System.out.print("TableChart of StockEvent: " + stockEvent.getTicker() + " " + stockEvent.getQuote());
		} else if (arg instanceof DJIAEvent) {
			DJIAEvent djiaEvent = (DJIAEvent) arg;
			System.out.print("TableChart of DJIAEvent: " + djiaEvent.getDjia());
		}
	}

}
