/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	
public class BattleDeck {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		BattleDeck isoContest = new BattleDeck();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		Deck autre = new Deck(lines.get(1));
		Deck moi = new Deck(lines.get(2));
		
		while(!autre.cartes.isEmpty() && !moi.cartes.isEmpty()) {
			
			 if(moi.getFirstValue()==autre.getFirstValue()) {
				 autre.cartes.remove(0);
				 moi.cartes.remove(0);
			 } else if(moi.getFirstValue()>autre.getFirstValue()) {
				 moi.mettreDessous();
				 autre.cartes.remove(0);
			 } else {
				 autre.mettreDessous();
				 moi.cartes.remove(0);
			 }
			
		}
		
		if(moi.cartes.isEmpty()&&autre.cartes.isEmpty()) {
			System.out.println("N");
		} else if(moi.cartes.isEmpty()) {
			System.out.println("P");
		} else {
			System.out.println("G");
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

class Deck {
	
	List<Carte> cartes = new ArrayList<Carte>();
	
	public Deck(String listeCarte) {
		
		this.cartes = new ArrayList<Carte>();
		
		String[] slipt = listeCarte.split(" ");
		
		for(String s : slipt) {
			this.cartes.add(new Carte(s));
		}
		
		
	}
	
	int getFirstValue(){
		return cartes.get(0).value;
	}
	
	void mettreDessous() {
		Carte todo = cartes.get(0);
		
		cartes.remove(0);
		cartes.add(todo);
	}
	
	void retirer() {
		cartes.remove(0);
	}
	
}

class Carte {
    
    int value;
    
    public Carte(String s){
        this.value = Integer.valueOf(s);
    }
}
