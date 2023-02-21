/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	
	public class Tomates {
		
		private static Vector<String> lines = null;
		
		public static void main(String[] argv) throws Exception {
			
			Tomates isoContest = new Tomates();
			
			String line;
			Scanner sc = new Scanner(System.in);
			lines = new Vector<>();
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				lines.add(line);
			}
			
			String toMatch = getStringInLines(0);
			
			lines.remove(0);
			lines.remove(0);
			
			for(String plat : lines) {
				
				if(platMatch(plat, toMatch)) {
					System.out.println("OUI");
				} else {
					System.out.println("NON");
				}
				
			}
			
			
		}
		
		
		
		private static boolean platMatch(String plat, String toMatch) {
			boolean res = false;
			
			res = plat.equals(toMatch);
			String rotToMatch = toMatch;
			for(int i=0;i<toMatch.length();i++) {
				
				rotToMatch = toMatch.substring(1)+toMatch.charAt(0);
				if(!res) {
					res = plat.equals(rotToMatch);
					toMatch = rotToMatch;
				}
				
				
			}
			
			res = plat.equals(toMatch);
			
			return res;
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
	


