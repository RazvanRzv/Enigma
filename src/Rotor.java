import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Rotor {

	private int								number;
	private String							mapping;
	private String							alphabet	= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String							alf			= "ADG";
	private char							notch;
	private char							notch2;										// for
																						// rotors
																						// 6,7,8;

	private HashMap<Character, Character>	map;
	private HashMap<Character, Character>	map2;
	private HashMap<Character, Character>	reverseMap;


	public Rotor(int number, String mapping, char notch) {
		this.number = number;
		this.mapping = mapping;
		this.notch = notch;
		map = new HashMap<Character, Character>();
		map2 = new HashMap<Character, Character>();
		reverseMap = new HashMap<Character, Character>();

		createMapping();
	}

	public Rotor(int number, String mapping, char notch, char notch2) {
		this(number, mapping, notch);
		this.notch2 = notch2;

	}

	public void createMapping() {

		for (int i = 0; i < mapping.length(); i++) {
			map.put(alphabet.charAt(i), mapping.charAt(i));
		}
		for (int i = 0; i < mapping.length(); i++) {
			reverseMap.put(mapping.charAt(i), alphabet.charAt(i));
		}
		
		for(int i = 0; i < alf.length(); i++) {
			char pos = alf.charAt(i);
			int index = alphabet.indexOf(pos);
			map2.put(alphabet.charAt(index), mapping.charAt(index));
		}
		
	}


	private char intToChar(int x) {
		return (char) ((int) 'A' + x);
	}

	private int charToInt(char x) {
		return x - 'A';
	}

	public void print() {
		System.out.println("ROTOR");
		// for (int i = 0; i < mapping.length(); i++) {
		// // System.out.print((char)(map[i]+ (int)'A') + " ");
		// System.out.print(alphabet.charAt(i) + " ");
		// }
		// System.out.println();
		System.out.println("size: " + map.size());
		// for (int i = 0; i < mapping.length(); i++) {
		// System.out.print(mapping.charAt(i) + " ");
		System.out.println(map);
		System.out.println(reverseMap);
		// }
		System.out.println();
		System.out.println(map2);
		// for (int i = 0; i < mapping.length(); i++) {
		// System.out.print(intToChar(reverseMap[i]) + " ");
		// }
	}
}
