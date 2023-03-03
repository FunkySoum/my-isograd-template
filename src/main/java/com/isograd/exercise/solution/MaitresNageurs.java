/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	
public class MaitresNageurs {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		MaitresNageurs isoContest = new MaitresNageurs();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		int nbNageurs = 0;
		int nbMaitres = getIntInLines(1);
		
		lines.remove(0);
		lines.remove(0);
		lines.add("23:00 F");
		
		int res = 0;
		
		int precHoraire = 0;
		boolean alarme = false;
		for(int i=0;i<lines.size();i++) {
			
			int horaire = getHeureInLines(i, 0);
			String action = getStringInLines(i, 1);
			
			if("E".equals(action)) {
				nbNageurs++;
			} else if("S".equals(action)) {
				nbNageurs--;
			} 
			
			if(nbNageurs>nbMaitres*10) {
				
				if(alarme) {
					
					res += (horaire-precHoraire);
					
				}
				
				precHoraire = horaire;
				alarme = true;
				
			} else {
				
				if(alarme) {
					
					res += (horaire-precHoraire);
					
				}
				
				precHoraire = horaire;
				alarme = false;
				
			}
			
			
		}
		
		System.out.println(res);
		
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
	


