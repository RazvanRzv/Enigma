
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class EnigmaMachine implements Encrypter {

	public Rotor[]		rotors;
	private Reflector	reflector;
	private Plugboard	plugboard;

	public EnigmaMachine(Setup setup) {
		rotors = setup.rotors;
		// this.rotors = new Rotor[3];
		// for(int i = 0; i < 3; i++) {
		// rotors[i] = setup.rotors[i];
		// }
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

	public char cryptChar(char ch) {
		ch = Character.toUpperCase(ch);
		if (ch == ' ')
			return ch;

		// for (int i = 0; i < 3; i++) {
		// System.out.println(rotors[i].mapping);
		// System.out.println(rotors[1].getRevMap());
		// }

		rotateRotors();
		for (int i = 0; i < 3; i++) {
			if (ch + rotors[i].offset > 'Z') {
				ch = rotors[i].getMap()
						.get((char) ('A' - 1 + (ch + rotors[i].offset) % 'Z')); // caz in care caracterul iese din alfabet
			} else
				ch = rotors[i].getMap()
						.get((char) ((ch + rotors[i].offset) % 'Z'));
			ch = (char) (ch - rotors[i].offset);
			if (ch < 'A') {
				ch = (char) ('A' + mod(ch - 'A', 26));
			}
		}
		ch = reflector.getMap().get(ch);
		for (int i = 2; i >= 0; i--) {
			if (ch + rotors[i].offset > 'Z') {
				ch = rotors[i].getRevMap()
						.get((char) ('A' - 1 + (ch + rotors[i].offset) % 'Z')); // caz in care caracterul iese din alfabet
			} else
				ch = rotors[i].getRevMap()
						.get((char) ((ch + rotors[i].offset) % 'Z'));
			ch = (char) (ch - rotors[i].offset);
			if (ch < 'A') {
				ch = (char) ('A' + mod(ch - 'A', 26)); // caz in care caracterul iese din alfabet
			}
		}
		ch = plugboard.map.get(ch);
		return ch;
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
