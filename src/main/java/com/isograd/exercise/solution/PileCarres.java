/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;


public class PileCarres {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		PileCarres isoContest = new PileCarres();
		
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			System.err.println(line);
			lines.add(line);
		}

		String[] cotes = lines.get(1).split(" ");
		
		int res = 0;
		int current = 0;
		int prev = 0;
		for(int i=0;i<cotes.length;i++) {
			
			if(i!=0) {
				prev = Integer.parseInt(cotes[i-1]);
			}
			current = Integer.parseInt(cotes[i]);
			
			res += 4 * current;
			
			if(prev > current){
				res -= current;
			} else {
				res -= prev;
			}
			
			
		}
		
		System.out.println(res);
		
	}
	
	
}


