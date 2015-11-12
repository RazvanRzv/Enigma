
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Setup {

	// private Rotor[] rotors;
	// // private String alphabet;
	// private Plugboard plugboard;
	// private Reflector reflector;

	public Rotor[]		rotors;
	public Plugboard	plugboard;
	public Reflector	reflector;	// reflectorul este un rotor fara notch.
	public char[]		alphabet;

	public Setup(String alphabet, String reflAndRot, String pairs) {
		this.alphabet = alphabet.toCharArray();
		this.plugboard = new Plugboard(alphabet);
		String[] plugboardPairs = pairs.split(" ");
		if(!plugboardPairs[0].equals("")) {
			for (String pair : plugboardPairs) {
				plugboard.setPair(pair.charAt(1), pair.charAt(2));
			}
		}

		String[] rotorsUsed = reflAndRot.split(" ");
		this.reflector = new ReflectorFactory().getReflector(rotorsUsed[0].charAt(0));
		this.reflector.setAlphabet(alphabet);
		this.rotors = new Rotor[rotorsUsed.length - 1];
		int n = rotorsUsed.length - 1;
		for (int i = n; i >= 1; i--) {
			this.rotors[n - i] = new RotorFactory()
					.getRotor(Integer.parseInt(rotorsUsed[i]));
			this.rotors[n - i].setAlphabet(alphabet);
		}
	}

}
