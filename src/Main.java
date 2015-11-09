import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Main {

	public static void main(String[] args) {
		
		
		Rotor rot1 = new Rotor(1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q');
		Rotor rot3 = new Rotor(3, "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'Q');
//		rot3.print();
		Rotor rot6 = new Rotor(7, "NZJHGRCXMYSWBOUFAIVLPEKQDT", 'A', 'N');
		rot6.print();
		Plugboard pb = new Plugboard(26);
		pb.setPair('A', 'F');
//		 pb.print();
		EnigmaMachine em = new EnigmaMachine(3);
//		em.print();

//		HashMap<Character, Character> hash = new HashMap<Character, Character>();
//		hash.put('a', 'b');
//		hash.put('c', 'd');
//		hash.put('e', 'f');
//		hash.put('g', 'h');
//		hash.put('i', 'j');
//		hash.put('k', 'l');
//		hash.put('m', 'n');
//		hash.put('o', 'p');
//		hash.put('q', 'r');
//		System.out.println(hash.get('a'));
		
	}

}
