package com.isograd.exercise;

import java.io.FileNotFoundException;

import org.junit.Test;

public class IsoContestTest {

	
	@Test
	public void tesIsoConstestNominal() throws FileNotFoundException {
		
		IsogradReader reader = new IsogradReader("src/test/resources/IsogradReader/localNominal.txt");
		
		IsoContest isoContest = new IsoContest();
		isoContest.setReader(reader);
		isoContest.traitement();
		
		System.err.println("Expected : xktwan");
	}
	
}
