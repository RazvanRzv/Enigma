import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Main {

	public static void main(String[] args) {

		Setup setup = new Setup("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "B 1 2 3", "");
		EnigmaMachine em = new EnigmaMachine(setup);
		System.out.println(em.encrypt("AAAAAAAA"));

		char x = 'C';
		int i = 3;
//		System.out.println(((x - 3) - 'A') );
//		System.out.println(-28 % 26);
//		if (x - i < 65) {
////			System.out.println((char)('A' + ((x - 3) - 'A')% 26));
//		}
		System.out.println(mod(-1, 26));
		// em.print();
		// int j = 0;
		// while (j < 130) {
		// em.rotateRotors();
		// for (int i = 0; i < 3; i++) {
		// System.out.print(em.rotors[i].offset + " ");
		// }
		// System.out.println();
		// j++;
		// }

		// System.out.println(em.crypt('A'));
		// HashMap<Character, Character> hash = new HashMap<Character,
		// Character>();
		// hash.put('A', 'B');
		// hash.put('C', 'D');
		// hash.put('E', 'F');
		// hash.put('Q', 'T');
		// String text = "ABC";
		// System.out.println(hash.get(text.charAt(0)));

	}

	public static int mod(int x, int mod) {
		int ret = x % mod;
		if(ret >= 0) return ret;
		return mod + ret;
	}
}
