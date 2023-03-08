/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	
public class StationsService {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		StationsService isoContest = new StationsService();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		int reservoir = getIntInLines(0);
		int conso = getIntInLines(1);
		float maxKm = reservoir/conso*100;
		
		int destFinale = getIntInLines(5);
		
		int stationA = getIntInLines(2);
		int stationB = getIntInLines(3);
		int stationC = getIntInLines(4);
		
		
		float toA = (stationA);
		float toB = (stationB-stationA);
		float toC = (stationC-stationB);
		float toF = (destFinale-stationC);
		
		if(toA<=maxKm && toB<=maxKm && toC<=maxKm && toF<=maxKm) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
		}
		
	}
	
	
	
	public static String getStringInLines(int numeroLigne) {
		return lines.get(numeroLigne);
	}
	
	public static String getStringInLines(int numeroLigne, int position) {
		return getStringInLines(numeroLigne, position, " ");
	}
	
	private static String getStringInLines(int numeroLigne, int position, String separateur) {
		String[] data = lines.get(numeroLigne).split(separateur);
		return data[position];
	}
	
	public static int getIntInLines(int numeroLigne) {
		return Integer.parseInt(lines.get(numeroLigne));
	}
	
	public static int getIntInLines(int numeroLigne, int position) {
		return getIntInLines(numeroLigne, position, " ");
	}
	
	private static int getIntInLines(int numeroLigne, int position, String separateur) {
		String[] data = lines.get(numeroLigne).split(separateur);
		return Integer.parseInt(data[position]);
	}
	
	public static int getHeureInLines(int numeroLigne) {
		String[] heure = lines.get(numeroLigne).split(":");
		return Integer.parseInt(heure[0])*60+Integer.parseInt(heure[1]);
	}
	
	public static int getHeureInLines(int numeroLigne, int position) {
		return getHeureInLines(numeroLigne, position, " ");
	}
	
	private static int getHeureInLines(int numeroLigne, int position, String separateur) {
		String[] data = lines.get(numeroLigne).split(separateur);
		String[] heure = data[position].split(":");
		return Integer.parseInt(heure[0])*60+Integer.parseInt(heure[1]);
	}
	
}
	


