
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class EnigmaM4 extends EnigmaMachine {

	public EnigmaM4(Setup setup) {
		super(setup);
	}

	@Override
	protected void rotateRotors() {
		rotors[0].rotateRotor();

		if (rotors[0].getOffset() == rotors[0].getNotch())
			rotors[1].rotateRotor();

		else if (rotors[1].getOffset() == rotors[1].getNotch()) {
			rotors[2].rotateRotor();
			rotors[1].rotateRotor();
		}

		for (int i = 0; i < rotors.length; i++) {
			rotors[i].setOffset(rotors[i].getOffset() % alphabet.length);
		}
	}

}
