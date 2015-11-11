import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Plugboard {

	public HashMap<Character, Character>	map;

	public Plugboard(String alphabet) {
		map = new HashMap<Character, Character>();
		for (int i = 0; i < alphabet.length(); i++) {
			map.put(alphabet.charAt(i), alphabet.charAt(i));
		}
	}

	public void setPair(char a, char b) {
		map.put(a, b);
		map.put(b, a);
	}

	public HashMap<Character, Character> getMap() {
		return map;
	}
	
	public void print() {
		System.out.println(map);
	}

}
