import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Rotor extends Reflector {

	private char							notch;
	private char							notch2;		// for
														// rotors
														// 6,7,8;
	private HashMap<Character, Character>	reverseMap;
//	private int								offset;
	public int								offset;
	
	public Rotor(int number, String mapping, char notch) {
		super(number, mapping);
		this.offset = 0;
		this.notch = notch;
		reverseMap = new HashMap<Character, Character>();

	}

	public Rotor(int number, String mapping, char notch, char notch2) {
		this(number, mapping, notch);
		this.notch2 = notch2;

	}

	public HashMap<Character, Character> getMap(){
		return map;
	}
	
	public HashMap<Character, Character> getRevMap(){
		return reverseMap;
	}
	
	protected void createMapping() {
		super.createMapping();
		for (int i = 0; i < alphabet.length(); i++) {
			char pos = alphabet.charAt(i);
			int index = ALPHABET.indexOf(pos);
			reverseMap.put(mapping.charAt(index), ALPHABET.charAt(index));
		}

	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public void rotateRotor() {
		offset++;
	}
	
	public int getNotch() {
		return notch - 'A';
	}
	
	public void print() {
		super.print();

		System.out.println("rev map: " + reverseMap);
	}
}
