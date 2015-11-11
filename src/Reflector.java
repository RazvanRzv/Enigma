import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Reflector {

	public static final String				ALPHABET	= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	protected int							number;
	protected String						mapping;

	protected String						alphabet;
	protected HashMap<Character, Character>	map;

	public Reflector(int number, String mapping) {
		this.number = number;
		this.mapping = mapping;
		map = new HashMap<Character, Character>();
	}

	protected void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
		createMapping();
	}

	protected void createMapping() {
		for (int i = 0; i < alphabet.length(); i++) {
			char pos = alphabet.charAt(i);
			int index = ALPHABET.indexOf(pos);
			map.put(ALPHABET.charAt(index), mapping.charAt(index));
		}
	}

	public HashMap<Character, Character> getMap(){
		return map;
	}
	
	public void print() {
		System.out.println("map: " + map);
	}
}
