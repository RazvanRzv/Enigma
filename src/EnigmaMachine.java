
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class EnigmaMachine {

	private Rotor[]		allRotors	= {
			new Rotor(1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'R'),
			new Rotor(2, "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'F'),
			new Rotor(3, "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'W'),
			new Rotor(4, "ESOVPZJAYQUIRHXLNFTGKDCMWB", 'K'),
			new Rotor(5, "VZBRGITYUPSDNHLXAWMJQOFECK", 'A'),
			new Rotor(6, "JPGVOUMFYQBENHZRDKASXLICTW", 'A', 'N'),
			new Rotor(7, "NZJHGRCXMYSWBOUFAIVLPEKQDT", 'A', 'N'),
			new Rotor(8, "FKQHTLXOCBJSPDZRAMEWNIUYGV", 'A', 'N') };

	// new Rotor(6, "YRUHQSLDPXNGOKMIEBFZCWVJAT", ' '),
	// new Rotor(7, "FVPJIAOYEDRZXWGCTKUQSBNMHL", ' ')

	private Rotor[]		rotors;
	private Reflector	reflector;
	private Plugboard	plugboard;

	public EnigmaMachine(int numberOfRotors) {
		rotors = new Rotor[numberOfRotors];
		plugboard = new Plugboard(26);
		initRotors(1, 3, 6);
//		initPlugboard("");
		 initPlugboard("(AF) (CD) (GE)");
	}

	private void initRotors(int rot1, int rot2, int rot3) {
		rotors[0] = allRotors[rot1 - 1];
		rotors[1] = allRotors[rot2 - 1];
		rotors[2] = allRotors[rot3 - 1];
	}

	private void initPlugboard(String setup) {
		if (setup.equals("")) {
			return;
		}
		String[] tokenized = setup.split(" ");
		System.out.println("length: " + tokenized.length);
		for (String token : tokenized) {
			plugboard.setPair(token.charAt(1), token.charAt(2));
		}
	}

	public void print() {
		for (int i = 0; i < 3; i++) {
			// rotors[i].print();
			// System.out.println();
		}
		plugboard.print();
	}
}
