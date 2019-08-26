
public class Main {

	public static void main(String[] args) {


		System.out.println("Wilkommen bei Tic Tac Toe für 2 Spieler.");
		System.out.println("Spielfigur Spieler1: 1");
		System.out.println("Spielfigur Spieler2: 2");
		System.out.println("Spieler 1 beginnt.");

		Spielfeld spielfeld = new Spielfeld();
		spielfeld.printSpielfeld();

		// System.out.println(spielfeld2.checkWinSpieler1());
		// winSpieler1 == false && winSpieler2 == false && draw == false

		System.out.println();
		System.out.println();

		while (spielfeld.checkWinSpieler1() == false) {
			System.out.println("Spieler 1 ist dran.");
			System.out.println();

			spielfeld.spielzugSpieler1();

			spielfeld.checkWinSpieler1();

			if (spielfeld.checkWinSpieler1() == true) {
				System.out.println("Spieler 1 gewinnt!");
				break;
			}

			System.out.println();
			System.out.println();

			System.out.println("Spieler 2 ist dran.");
			System.out.println();

			spielfeld.spielzugSpieler2();

			spielfeld.checkWinSpieler2();

			if (spielfeld.checkWinSpieler2() == true) {
				System.out.println("Spieler 2 gewinnt!");
				break;
			}
			System.out.println();
			System.out.println();

		}

	}
}
