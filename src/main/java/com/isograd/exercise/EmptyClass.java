/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*

public class IsoContest {
	
	private boolean isLocal = false;
	private String filePath = "";

	private IsogradReader lignes = null;
	
	public static void main(String[] argv) throws Exception {

		
		System.err.println("#########");
		System.err.println("# START #");
		System.err.println("#########");
		
		IsoContest isoContest = new IsoContest();
		IsogradReader reader = new IsogradReader(isoContest.isLocal(), isoContest.getFilePath());

		isoContest.setReader(reader);
		isoContest.traitement();
		
	}

	public void traitement() {
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public void setReader(IsogradReader reader) {
		this.lignes = reader;
	}
	
	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public String getFilePath() {
		
		if("".equals(filePath)) {
			return "src/main/resources/localDataFile.txt";
		} else {
			return filePath;
		}
		
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}

class IsogradPrinter {
	
	public String toStringHeureMinute(int heure) {
		return toStringHeureMinute(heure, ":");
	}
	
	public String toStringHeureMinute(int heure, String separateurHeure) {
		
		int hh = heure/60;
		int mm = heure%60;

		String strHh = "";
		if(hh < 10) {
			strHh = "0"+hh;
		} else {
			strHh = ""+hh;
		}
		
		String strMm = "";
		if(mm < 10) {
			strMm = "0"+mm;
		} else {
			strMm = ""+mm;
		}
		
		return strHh + separateurHeure + strMm;
		
	}
	
}

class IsogradReader {

	private List<String> lignes = null;

	
	public IsogradReader() throws FileNotFoundException {
		this(false, "");
	}
	
	public IsogradReader(String file) throws FileNotFoundException {
		this(true, file);
	}
	
	public IsogradReader(boolean isLocal, String localFile) throws FileNotFoundException {
		
		this.lignes = new ArrayList<String>();
		
		String line;
		Scanner sc = null;
		
		if(isLocal) {
			File localDatafile = new File(localFile);
			sc = new Scanner(localDatafile);
		} else {
			sc = new Scanner(System.in);
		}
		
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			addLigne(line);
		}
		
		
	}

	public int length() {
		return lignes.size();
	}
	
	public int size() {
		return lignes.size();
	}
	
	private void addLigne(String ligne) {
		System.err.println(ligne);
		lignes.add(ligne);
	}

	public String getString(int i) {
		return lignes.get(i);
	}

	public String getString(int i, int j) {
		return getString(i, j, " ");
	}

	public String getString(int i, int j, String separator) {
		String[] ligne = lignes.get(i).split(separator);
		return ligne[j];
	}

	public int getInt(int i) {
		return Integer.parseInt(getString(i));
	}

	public int getInt(int i, int j) {
		return Integer.parseInt(getString(i, j));
	}

	public int getInt(int i, int j, String separator) {
		return Integer.parseInt(getString(i, j, separator));
	}

	public float getFloat(int i) {
		return Float.parseFloat(getString(i));
	}

	public float getFloat(int i, int j) {
		return Float.parseFloat(getString(i, j));
	}

	public float getFloat(int i, int j, String separator) {
		return Float.parseFloat(getString(i, j, separator));
	}

	public double getDouble(int i) {
		return Double.parseDouble(getString(i));
	}

	public double getDouble(int i, int j) {
		return Double.parseDouble(getString(i, j));
	}

	public double getDouble(int i, int j, String separator) {
		return Double.parseDouble(getString(i, j, separator));
	}
	
	public int getHeure(int i) {
		return getHeure(i, ":");
	}
	
	public int getHeure(int i, String hourSeparator) {
		String[] strHeure = getString(i).split(hourSeparator);
		return Integer.parseInt(strHeure[0])*60 + Integer.parseInt(strHeure[1]);
	}

	public int getHeure(int i, int j) {
		return getHeure(i, j, ":");
	}
	
	public int getHeure(int i, int j, String hourSeparator) {
		String[] strHeure = getString(i, j).split(hourSeparator);
		return Integer.parseInt(strHeure[0])*60 + Integer.parseInt(strHeure[1]);
	}
	
	public int getHeure(int i, int j, String separator, String hourSeparator) {
		String[] strHeure = getString(i, j, separator).split(hourSeparator);
		return Integer.parseInt(strHeure[0])*60 + Integer.parseInt(strHeure[1]);
	}
	
	
}

*/
