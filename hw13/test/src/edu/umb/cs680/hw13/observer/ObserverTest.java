package edu.umb.cs680.hw13.observer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.multicast.DJIAQuoteObservable;
import edu.umb.cs680.hw13.multicast.PiechartObserver;
import edu.umb.cs680.hw13.multicast.StockQuoteObservable;
import edu.umb.cs680.hw13.multicast.THREEDObserver;
import edu.umb.cs680.hw13.multicast.TableObserver;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class ObserverTest {
	PiechartObserver piechartObserver = new PiechartObserver();
	TableObserver tableObserver = new TableObserver();
	THREEDObserver threeDObserver = new THREEDObserver();
	StockQuoteObservable stock = new StockQuoteObservable();
	DJIAQuoteObservable djia = new DJIAQuoteObservable();

	@Test
	public void DJIATest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Random r = new Random(10);
		float quote = r.nextFloat() * 10;
		djia.addObserver(threeDObserver);
		djia.addObserver(tableObserver);
		djia.addObserver(piechartObserver);
		djia.changeQuote(quote);
		assertEquals(
				"3D of DJIAEvent: " + quote + "TableChart of DJIAEvent: " + quote + "PieChart of DJIAEvent: " + quote,
				outContent.toString());
		outContent.reset();
		quote = r.nextFloat() * 10;
		djia.changeQuote(quote);
		assertEquals(
				"3D of DJIAEvent: " + quote + "TableChart of DJIAEvent: " + quote + "PieChart of DJIAEvent: " + quote,
				outContent.toString());
	}

	@Test
	public void StockTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Random r = new Random(10);
		float quote = r.nextFloat() * 10;
		stock.addObserver(threeDObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(piechartObserver);
		stock.changeQuote("amazon", quote);
		assertEquals("3D of StockEvent: " + "amazon" + " " + quote + "TableChart of StockEvent: " + "amazon" + " " + quote
				+ "PieChart of StockEvent: " + "amazon" + " " + quote, outContent.toString());
		outContent.reset();
		quote = r.nextFloat() * 10;
		stock.changeQuote("google", quote);
		assertEquals("3D of StockEvent: " + "google" + " " + quote + "TableChart of StockEvent: " + "google" + " "
				+ quote + "PieChart of StockEvent: " + "google" + " " + quote, outContent.toString());
	}
}
