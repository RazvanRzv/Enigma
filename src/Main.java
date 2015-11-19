import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Main {

	public static void main(String[] args) {

		test();
//		tries();

		
		
		// Setup setup = new Setup("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "B 1 2 3", "");
		// Setup setup2 = new Setup("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "B 1 2 3",
		// "");
		//// EnigmaFull em = new EnigmaFull(setup);
		// String toCrypt = "AAA !!";
		// System.out.println(toCrypt);
		//// System.out.println(em.encrypt(toCrypt));
		// EnigmaM3 machine = new EnigmaM3(setup2);
		// System.out.println(machine.encrypt(toCrypt));

	}

	public static void tries() {
		Setup setup = new Setup("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "C 2 3 4", "BCQ",
				"AAA", "");
		EnigmaM3 em = new EnigmaM3(setup);
		System.out.println(em.encrypt("THE"));
	}

	public static void test() {
		FileParser fp = new FileParser("test4.txt");
		fp.open();
		String alphabet = fp.getLine();
		String pairs = fp.getLine();
		String rotAndRefl = fp.getLine();
		String rings = fp.getLine();
		String rotors = fp.getLine();
		String operation = fp.getLine();
		String text = fp.getLine();
		String toEncrypt = "";
		while(text != null) {
			toEncrypt += text;
			text = fp.getLine();
		}
		fp.close();
//		System.out.println(toEncrypt);
		// System.out.println(alphabet);
		// System.out.println(pairs);
		// System.out.println(rotAndRefl);
		// System.out.println(rings);
		// System.out.println(rotors);
		// System.out.println(operation);
		// System.out.println(text);

		Setup setup = new Setup(alphabet, rotAndRefl, rotors, rings, pairs);
		EnigmaM3 em = new EnigmaM3(setup);

		if (toEncrypt == "") {
			return;
		}
		System.out.println(em.encrypt(toEncrypt));
	}
}
