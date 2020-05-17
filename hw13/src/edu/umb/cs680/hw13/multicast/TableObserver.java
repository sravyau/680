package edu.umb.cs680.hw13.multicast;

public class TableObserver implements DJIAQuoteObserver, StockQuoteObserver {

	@Override
	public void updateStock(StockEvent arg) {
		StockEvent stockEvent = (StockEvent) arg;
		System.out.print("TableChart of StockEvent: " + stockEvent.getTicker() + " " + stockEvent.getQuote());

	}

	@Override
	public void updateDJIA(DJIAEvent arg) {
		DJIAEvent djiaEvent = (DJIAEvent) arg;
		System.out.print("TableChart of DJIAEvent: " + djiaEvent.getDjia());
	}
}
