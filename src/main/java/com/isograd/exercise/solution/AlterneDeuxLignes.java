/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;


public class AlterneDeuxLignes {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		AlterneDeuxLignes isoContest = new AlterneDeuxLignes();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}

		String ligneA = lines.get(0);
		String ligneB = lines.get(1);
		
		String res = "";
		for(int i=0;i<ligneA.length();i++) {
			
			res += String.valueOf(ligneA.charAt(i)) + String.valueOf(ligneB.charAt(i));
			
		}
		
		System.out.println(res);
		
	}
	
	
}


