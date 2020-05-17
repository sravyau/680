package edu.umb.cs680.hw13.multicast;

public class THREEDObserver implements DJIAQuoteObserver, StockQuoteObserver {

	@Override
	public void updateStock(StockEvent arg) {
		StockEvent stockEvent = (StockEvent) arg;
		System.out.print("3D of StockEvent: " + stockEvent.getTicker() + " " + stockEvent.getQuote());

	}

	@Override
	public void updateDJIA(DJIAEvent arg) {
		DJIAEvent djiaEvent = (DJIAEvent) arg;
		System.out.print("3D of DJIAEvent: " + djiaEvent.getDjia());
	}
}
