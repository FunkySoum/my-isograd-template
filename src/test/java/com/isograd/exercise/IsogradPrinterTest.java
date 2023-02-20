package com.isograd.exercise;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsogradPrinterTest {

	@Test
	public void testIsogradPrinterPrintHeureMinute0() {
		
		IsogradPrinter printer = new IsogradPrinter();
		
		String toTest = printer.toStringHeureMinute(0);
		System.err.println(toTest);
		
		assertEquals(toTest, "00:00");
		
	}
	
	@Test
	public void testIsogradPrinterPrintHeureMinute62() {
		
		IsogradPrinter printer = new IsogradPrinter();
		
		String toTest = printer.toStringHeureMinute(62);
		System.err.println(toTest);
		
		assertEquals(toTest, "01:02");
		
	}
	
	
}
