/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;

import java.util.*;


public class IsoContest {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		IsoContest isoContest = new IsoContest();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
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


