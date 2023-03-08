/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise.solution;

import java.util.*;

	
public class FriendsKO {
	
	private static Vector<String> lines = null;
	
	public static void main(String[] argv) throws Exception {
		
		FriendsKO isoContest = new FriendsKO();
		
		System.err.println("#############################");
		String line;
		Scanner sc = new Scanner(System.in);
		lines = new Vector<>();
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			lines.add(line);
		}
		
		lines.remove(0);
		
		Friend me = new Friend("1");
		System.err.println("ME : " + me);
		
		for(String l : lines){
			
			if(l.contains("1")) {
				me.addFriendDS(l);
			}
			
		}
		
		
		if(me.idFriend.isEmpty()) {
			System.out.println("-1");
		} else {
			
			List<Friend> others = new ArrayList<Friend>();
			for(String id : me.idFriend) {
				
				Friend a = new Friend(id);
				for(String l : lines){
					
					if(l.contains(id)) {
						a.addFriendDS(l);
					}
					
				}
				
				a.setCommuns(me);
				
				others.add(a);
			}

			Collections.sort(others, new FriendComparator());
			System.err.println(others);
			
			if(others.get(0).communs!=0) {
				System.out.println(others.get(0).id);
			} else {
				System.out.println("-1");
			}
			
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


class Friend{
	
	@Override
	public String toString() {
		return "Friend [id=" + id + ", communs=" + communs + "]";
	}

	String id = "";
	List<String> idFriend = new ArrayList<String>();
	int communs = 0;
	
	public Friend (String s) {
		this.id = s;
	}
	
	public void setCommuns(Friend me) {
		
		communs = 0;
		for(String id : idFriend) {
			
			if(me.idFriend.contains(id)) {
				communs++;
			}
			
		}
		
	}

	public void addFriendDS(String s){
		
		String[] relation = s.split(" ");
		addFriendS(relation[0]);
		addFriendS(relation[1]);
		
	}

	public void addFriendS(String s){
		
		if(!idFriend.contains(s) && !id.equals(s)) {
			idFriend.add(s);
		}
		
	}
	
}

class FriendComparator implements Comparator<Friend> {

	@Override
	public int compare(Friend o1, Friend o2) {

		if(o1.communs!=o2.communs) {
			return o2.communs-o1.communs;
		}else {
			return Integer.valueOf(o2.id) - Integer.valueOf(o1.id);
		}
		
		
	}

}


	


