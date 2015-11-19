
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public abstract class EnigmaMachine implements Encrypter {

	protected Rotor[]	rotors;
	protected Reflector	reflector;
	protected Plugboard	plugboard;
	protected char[]	alphabet;

	public EnigmaMachine(Setup setup) {
		this.rotors = setup.rotors;
		this.alphabet = setup.alphabet;
		this.reflector = setup.reflector;
		this.plugboard = setup.plugboard;

	}

	protected abstract void rotateRotors();

	private char charAtPos(int pos) {
		return alphabet[pos];
	}

	private int getCharPos(char ch) {
		for (int i = 0; i < alphabet.length; i++) {
			if (ch == alphabet[i]) {
				return i;
			}
		}
		return -1;
	}

	private int mod(int x, int mod) {
		int ret = x % mod;
		if (ret >= 0)
			return ret;
		return mod + ret;
	}

	private char cryptChar(char ch) {
		ch = Character.toUpperCase(ch);
		if (ch < 'A' || ch > 'Z')
			return ch;
		
		System.out.print(ch + "->");
		
		ch = plugboard.getMap().get(ch);
		System.out.print(ch + "->");
		
		rotateRotors();

		for (int i = 0; i < rotors.length; i++) {
			ch = charAtPos(mod(getCharPos(ch) + rotors[i].getOffset() - rotors[i].getRingOffset(),
					alphabet.length));
			ch = rotors[i].mapChar(ch); // maparea caracterului prin rotor
			ch = charAtPos(mod(getCharPos(ch) + rotors[i].getRingOffset()
					- rotors[i].getOffset(), alphabet.length));
			System.out.print(ch + "->");
		}

		ch = reflector.getMap().get(ch);
		System.out.print(ch + "->");

		for (int i = rotors.length - 1; i >= 0; i--) {
			ch = charAtPos(mod(getCharPos(ch) + rotors[i].getOffset()- rotors[i].getRingOffset(),
					alphabet.length));
			ch = rotors[i].revMapChar(ch);
			ch = charAtPos(mod(getCharPos(ch) + rotors[i].getRingOffset()
					- rotors[i].getOffset(), alphabet.length));
			System.out.print(ch + "->");
		}

		ch = plugboard.getMap().get(ch);
		System.out.print(ch);
		System.out.println();
		return ch;

	}

	@Override
	public String encrypt(String text) {
		String toReturn = "";

		for (int i = 0; i < text.length(); i++) {
			toReturn += cryptChar(text.charAt(i));
		}

		return toReturn;
	}
}
