import java.util.HashMap;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Main {

	public static void main(String[] args) {

		Setup setup = new Setup("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "B 1 2 3", "");
		EnigmaMachine em = new EnigmaMachine(setup);
		String toCrypt = "MI-A IESIT TEMA !!";
		System.out.println(toCrypt);
		System.out.println(em.encrypt(toCrypt));
	}
}
