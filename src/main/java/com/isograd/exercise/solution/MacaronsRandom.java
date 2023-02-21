/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	
public class MacaronsRandom {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		MacaronsRandom isoContest = new MacaronsRandom();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		int l1 = getIntInLines(0,0);
		int l2 = getIntInLines(0,1);
		int l3 = getIntInLines(0,2);
		
		int c1 = getIntInLines(1,0);
		int c2 = getIntInLines(1,1);
		int c3 = getIntInLines(1,2);
		
		Integer[][] grille = new Integer[3][3];
		
		grille[0][0] = 1;
		grille[1][0] = 2;
		grille[2][0] = 3;
		
		grille[0][1] = 4;
		grille[1][1] = 5;
		grille[2][1] = 6;
		
		grille[0][2] = 7;
		grille[1][2] = 8;
		grille[2][2] = 9;
		
		while(!grilleIsValid(grille,l1,l2,l3,c1,c2,c3)) {
			
			switchCases(grille);
			
		}
		
		printGrille(grille);
		
	}
	
	
	
	private static void printGrille(Integer[][] grille) {
		
		System.out.println(""+grille[0][0]+grille[1][0]+grille[2][0]);
		System.out.println(""+grille[0][1]+grille[1][1]+grille[2][1]);
		System.out.println(""+grille[0][2]+grille[1][2]+grille[2][2]);
		
	}



	private static void switchCases(Integer[][] grille) {

		int xA = getRandomNumberInRange(0,2);
		int yA = getRandomNumberInRange(0,2);
		int xB = getRandomNumberInRange(0,2);
		int yB = getRandomNumberInRange(0,2);
		
		int valA = grille[xA][yA];
		int valB = grille[xB][yB];
		
		grille[xA][yA] = valB;
		grille[xB][yB] = valA;
		
	}



	private static boolean grilleIsValid(Integer[][] grille, int l1, int l2, int l3, int c1, int c2, int c3) {
		
		boolean res = false;
		
		if(grilleIsValidLignes(grille, l1, l2, l3) && grilleIsValidColonnes(grille, c1, c2, c3)) {
			res = true;
		}
		
		return res;
		
	}


	private static boolean grilleIsValidColonnes(Integer[][] grille, int c1, int c2, int c3) {
		boolean res = false;
		
		if(grilleIsValideColonne(grille, 0, c1)&&grilleIsValideColonne(grille, 1, c2)&&grilleIsValideColonne(grille, 2, c3)) {
			res = true; 
		}
		
		return res;
	}



	private static boolean grilleIsValideColonne(Integer[][] grille, int numCol, int val) {

		int somme = grille[numCol][0]+grille[numCol][1]+grille[numCol][2];
		
		return val == somme;
	}



	private static boolean grilleIsValidLignes(Integer[][] grille, int l1, int l2, int l3) {

		boolean res = false;
		
		if(grilleIsValideLigne(grille, 0, l1)&&grilleIsValideLigne(grille, 1, l2)&&grilleIsValideLigne(grille, 2, l3)) {
			res = true; 
		}
		
		return res;
	}



	private static boolean grilleIsValideLigne(Integer[][] grille, int numLigne, int val) {

		int somme = grille[0][numLigne]+grille[1][numLigne]+grille[2][numLigne];
		
		return val == somme;
		
	}



	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
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
	


