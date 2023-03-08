/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	
public class MessageCachePatternMatcher {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		MessageCachePatternMatcher isoContest = new MessageCachePatternMatcher();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		String toFind = lines.get(0);
		String toFindPattern = "^(.)*";
		for(int i=0;i<toFind.length();i++) {
			toFindPattern += toFind.charAt(i)+"(.)*";
		}
		toFindPattern += "$";
		
		System.err.println(toFindPattern);
		
		lines.remove(0);
		lines.remove(0);
		
		String texte = "";
		for (String s : lines) {
			texte += s;
		}
		
		Pattern p = Pattern.compile(toFindPattern);
		Matcher m = p.matcher(texte);
		
		if(m.find()) {
			System.out.println("1");
		} else {
			System.out.println("0");
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
	


