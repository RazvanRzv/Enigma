

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ReflectorFactory {

	public Reflector getReflector(int type) {
		if (type == 'B')
			return new Reflector('B', "YRUHQSLDPXNGOKMIEBFZCWVJAT");
		if (type == 'C')
			return new Reflector('C', "FVPJIAOYEDRZXWGCTKUQSBNMHL");
		return null;
	}
	
}

