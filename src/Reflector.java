import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Reflector {

	public static final String				ALPHABET	= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	protected int							number;
	protected String						mapping;

	protected char[]						alphabet;
	protected HashMap<Character, Character>	map;

	public Reflector(int number, String mapping) {
		this.number = number;
		this.mapping = mapping;
		map = new HashMap<Character, Character>();
	}

	protected void setAlphabet(String alphabet) {
		this.alphabet = alphabet.toCharArray();
		createMapping();
	}

	protected void createMapping() {
		for (int i = 0; i < ALPHABET.length(); i++) {
			map.put(ALPHABET.charAt(i), mapping.charAt(i));
		}
	}

	public HashMap<Character, Character> getMap() {
		return map;
	}

	public void print() {
		System.out.println("map: " + map);
	}
}
