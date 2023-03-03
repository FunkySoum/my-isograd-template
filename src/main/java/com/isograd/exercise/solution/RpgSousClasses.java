/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	

public class RpgSousClasses {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		lines.remove(0);
		
		HashMap<String, Classe> data = new HashMap<String, Classe>();
		
		for(int i=0;i<lines.size();i++) {
			
			String classe = getStringInLines(i,0);
			String sousClasse = getStringInLines(i,1);
			
			if(!data.containsKey(classe)) {
				data.put(classe, new Classe(classe, sousClasse));
			} else {
				Classe c = data.get(classe);
				c.listSousClasse.add(sousClasse);
				data.put(classe, c);
			}
			
			if(!data.containsKey(sousClasse)) {
				data.put(sousClasse, new Classe(sousClasse));
			}
			
			Classe sClasse = data.get(sousClasse);
			sClasse.hasparent = true;
			data.put(sousClasse, sClasse);
			
		}
		
		List<String> res = new ArrayList<String>();
		int max = 0;
		for(String key : data.keySet()) {
			
			Classe cur = data.get(key);
			
			if(!cur.hasparent) {
			
				int curSousClasses = cur.getNbSousClasses(data);
				
				if(curSousClasses==max) {
					res.add(cur.id);
				} else if(curSousClasses>max) {
					res.clear();
					res.add(cur.id);
					max = curSousClasses;
				}
				
			}			
			
		}
		
		printRes(res);
		
		
	}
	
	
	
	private static void printRes(List<String> res) {
		
		String strRes = "";
		for(int i=0;i<res.size();i++) {
			
			if(i==0) {
				strRes += res.get(i);
			} else {
				strRes += " " + res.get(i);
			}
			
		}
		
		System.out.println(strRes);
		
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

class Classe {
	
	public String id;
	public List<String> listSousClasse;
	public boolean hasparent = false;
	
	public Classe(String classe) {
		
		this.id = classe;
		this.listSousClasse = new ArrayList<String>();
		
	}
	
	public int getNbSousClasses(HashMap<String, Classe> data) {
		
		int res = 0;
		if(listSousClasse.isEmpty()) {
			res = 1;
		}
		
		//int res = listSousClasse.size();
		
		for(String s : listSousClasse) {
			res += data.get(s).getNbSousClasses(data);
		}
		
		return res;
	}

	public Classe(String classe, String sousClasse) {
		
		this.id = classe;
		this.listSousClasse = new ArrayList<String>();
		this.listSousClasse.add(sousClasse);
		
	}
	
	public void addSousClasse(String sousClasse) {
		this.listSousClasse.add(sousClasse);
	}
	
}




