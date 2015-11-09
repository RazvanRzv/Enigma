import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Plugboard {

	private HashMap<Character, Character>	map;
	private String							alphabet	= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public Plugboard(int dim) {
		map	= new HashMap<Character, Character>();
		for(int i = 0; i < alphabet.length(); i++) {
			map.put(alphabet.charAt(i), alphabet.charAt(i));
		}
	}

	public void setPair(char a, char b) {
		map.put(a, b);
		map.put(b, a);
	}

	public void print() {
//		for (int i = 0; i < map.length; i++) {
//			System.out.print(intToChar(map[i]) + " ");
//		}
		System.out.println(map);
	}

}
