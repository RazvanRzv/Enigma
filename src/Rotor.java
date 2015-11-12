import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Rotor extends Reflector {

	private char							notch;
	private char							notch2;			// for
															// rotors
															// 6,7,8;
	private HashMap<Character, Character>	reverseMap;
	// private int offset;
	public int								offset;
	public int								ringOffset	= 0;

	public Rotor(int number, String mapping, char notch) {
		super(number, mapping);
		reverseMap = new HashMap<Character, Character>();
		this.offset = 0;
		this.ringOffset = 0;
		this.notch = notch;
	}

	public Rotor(int number, String mapping, char notch, char notch2) {
		this(number, mapping, notch);
		this.notch2 = notch2;

	}

	public HashMap<Character, Character> getMap() {
		return map;
	}

	public HashMap<Character, Character> getRevMap() {
		return reverseMap;
	}

	@Override
	protected void createMapping() {
		super.createMapping();
		for (int i = 0; i < ALPHABET.length(); i++) {
			reverseMap.put(mapping.charAt(i), ALPHABET.charAt(i));
		}

	}

	public char mapChar(char ch) {
		return map.get(ch);
	}
	
	public char revMapChar(char ch) {
		return reverseMap.get(ch);
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void rotateRotor() {
		offset++;
	}

	public void setRingOffset(int value) {
		ringOffset = (int) 'A' + value;
	}

	public int getNotch() {
		return notch - 'A';
	}

	public void print() {
		super.print();

		System.out.println("rev map: " + reverseMap);
	}
}
