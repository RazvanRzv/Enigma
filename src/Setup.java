
/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Setup {

	public Rotor[]		rotors;
	public Plugboard	plugboard;
	public Reflector	reflector;	// reflectorul este un rotor fara notch.
	public char[]		alphabet;

	public Setup(String alphabet, String reflAndRot, String rotorsOffsets,
			String ringsOffsets, String pairs) {
		this.alphabet = alphabet.toCharArray();
		this.plugboard = new Plugboard(alphabet);
		String[] plugboardPairs = pairs.split("\\s+");
		if (!plugboardPairs[0].equals("")) {
			for (String pair : plugboardPairs) {
				plugboard.setPair(pair.charAt(1), pair.charAt(2));
			}
		}
		String[] rotorsUsed = reflAndRot.split("\\s+");
		this.reflector = new ReflectorFactory()
				.getReflector(rotorsUsed[0].charAt(0));
		this.reflector.setAlphabet(alphabet);
		int numOfRotors = rotorsUsed.length - 1;
		this.rotors = new Rotor[numOfRotors];
		for (int i = numOfRotors; i >= 1; i--) {
			this.rotors[numOfRotors - i] = new RotorFactory()
					.getRotor(Integer.parseInt(rotorsUsed[i]));
			this.rotors[numOfRotors - i].setAlphabet(alphabet);
			this.rotors[numOfRotors - i].setOffset(rotorsOffsets.charAt(i - 1));
			this.rotors[numOfRotors - i].setRingOffset(ringsOffsets.charAt(i - 1));
		}
	}

}
