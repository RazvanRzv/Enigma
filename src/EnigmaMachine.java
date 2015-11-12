
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class EnigmaMachine implements Encrypter {

	public Rotor[]		rotors;
	private Reflector	reflector;
	private Plugboard	plugboard;
	private char[]		alphabet;

	public EnigmaMachine(Setup setup) {
		this.rotors = setup.rotors;
		this.alphabet = setup.alphabet;
		this.reflector = setup.reflector;
		this.plugboard = setup.plugboard;
	}

	public void rotateRotors() {

		rotors[0].rotateRotor();

		if (rotors[0].offset == rotors[0].getNotch())
			rotors[1].rotateRotor();

		else if (rotors[1].offset == rotors[1].getNotch()) {
			rotors[2].rotateRotor();
			rotors[1].rotateRotor();
		}

		for (int i = 0; i < rotors.length; i++) {
			rotors[i].setOffset(rotors[i].offset % 26);
		}
	}

	@Override
	public String encrypt(String text) {
		String toReturn = "";

		for (int i = 0; i < text.length(); i++) {
			toReturn += cryptChar(text.charAt(i));
		}

		return toReturn;
	}

	private char cryptChar(char ch) {
		ch = Character.toUpperCase(ch);
		if (ch < 'A' || ch > 'Z')
			return ch;

		ch = plugboard.getMap().get(ch);

		rotateRotors();

		for (int i = 0; i < rotors.length; i++) {
			ch = charAtPos(
					mod(getCharPos(ch) + rotors[i].offset, alphabet.length)); // caracterul
																				// din
																				// alfabet
																				// dupa
																				// aplicarea
																				// offsetului
			ch = rotors[i].mapChar(ch); // maparea caracterului prin rotor
			ch = charAtPos(mod(
					getCharPos(ch) + rotors[i].ringOffset - rotors[i].offset,
					alphabet.length)); // caracterul din alfabet dupa scaderea
										// offsetului
		}

		ch = reflector.getMap().get(ch);

		for (int i = rotors.length - 1; i >= 0; i--) {
			ch = charAtPos(
					mod(getCharPos(ch) + rotors[i].offset, alphabet.length));
			ch = rotors[i].revMapChar(ch);
			ch = charAtPos(mod(
					getCharPos(ch) + rotors[i].ringOffset - rotors[i].offset,
					alphabet.length));
		}

		ch = plugboard.getMap().get(ch);

		return ch;

	}

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

	public void print() {
		for (int i = 0; i < 3; i++) {
			rotors[i].print();
		}
		reflector.print();
		// plugboard.print();
	}

}
