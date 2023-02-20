package com.isograd.exercise;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Test;

public class IsogradReaderTest {

	@Test
	public void tesIsogradReaderNominal() throws FileNotFoundException {
		
		IsogradReader reader = new IsogradReader("src/test/resources/IsogradReader/localNominal.txt");
		assertNotNull(reader);
	}
	
}
