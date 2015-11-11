
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class RotorFactory {

	public Rotor getRotor(int number) {
		if (number == 1)
			return new Rotor(1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'R');
		if (number == 2)
			return new Rotor(2, "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'F');
		if (number == 3)
			return new Rotor(3, "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'W');
		if (number == 4)
			return new Rotor(4, "ESOVPZJAYQUIRHXLNFTGKDCMWB", 'K');
		if (number == 5)
			return new Rotor(5, "VZBRGITYUPSDNHLXAWMJQOFECK", 'A');
		if (number == 6)
			return new Rotor(6, "JPGVOUMFYQBENHZRDKASXLICTW", 'A', 'N');
		if (number == 7)
			return new Rotor(7, "NZJHGRCXMYSWBOUFAIVLPEKQDT", 'A', 'N');
		if (number == 8)
			return new Rotor(8, "FKQHTLXOCBJSPDZRAMEWNIUYGV", 'A', 'N');
		return null;
	}

}
