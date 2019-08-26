import java.util.Scanner;

public class Spielfeld {

	int anzahlZeilen = 4;
	int anzahlSpalten = 4;
	int zeile = 0;
	int spalte = 0;

	int[][] spielfeld = new int[anzahlZeilen][anzahlSpalten];

	public void printSpielfeld() {

		for (int zeile = 1; zeile <= anzahlZeilen - 1; zeile++) {

			System.out.println();
			for (int spalte = 1; spalte <= anzahlSpalten - 1; spalte++) {

				System.out.print(spielfeld[zeile][spalte] + " ");

			}

		}

	}

	public void spielzugSpieler1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("In welcher Zeile willst du deine Spielfigur setzen?");
		zeile = sc.nextInt();
		while (zeile < 1 || zeile > 3) {
			System.out.println("Falsche Eingabe: Bitte wähle eine Zahl zwischen 1 und 3.");
			zeile = sc.nextInt();
		}
		System.out.println("In welcher Spalte willst du deine Spielfigur setzen?");
		spalte = sc.nextInt();
		while (spalte < 1 || spalte > 3) {
			System.out.println("Falsche Eingabe: Bitte wähle eine Zahl zwischen 1 und 3.");
			spalte = sc.nextInt();
		}

		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[0].length; j++) {

				if (i == zeile && j == spalte) {
					spielfeld[i][j] = 1;
				}

			}

		}
		printSpielfeld();
	}

	public void spielzugSpieler2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("In welche Zeile willst du deine Spielfigur setzen?");
		zeile = sc.nextInt();
		while (zeile < 1 || zeile > 3) {
			System.out.println("Falsche Eingabe: Bitte wähle eine Zahl zwischen 1 und 3.");
			zeile = sc.nextInt();
		}
		System.out.println("In welche Spalte willst du deine Spielfigur setzen?");
		spalte = sc.nextInt();
		while (spalte < 1 || spalte > 3) {
			System.out.println("Falsche Eingabe: Bitte wähle eine Zahl zwischen 1 und 3.");
			spalte = sc.nextInt();
		}

		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[0].length; j++) {

				if (i == zeile && j == spalte) {
					spielfeld[i][j] = 2;
				}

			}

		}
		printSpielfeld();
	}

	public boolean checkWinSpieler1() {
		if (spielfeld[1][1] == 1 && spielfeld[1][2] == 1 && spielfeld[1][3] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[2][1] == 1 && spielfeld[2][2] == 1 && spielfeld[2][3] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[3][1] == 1 && spielfeld[3][2] == 1 && spielfeld[3][3] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][1] == 1 && spielfeld[2][1] == 1 && spielfeld[3][1] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][2] == 1 && spielfeld[2][2] == 1 && spielfeld[3][2] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][3] == 1 && spielfeld[2][3] == 1 && spielfeld[3][3] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][1] == 1 && spielfeld[2][2] == 1 && spielfeld[3][3] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][3] == 1 && spielfeld[2][2] == 1 && spielfeld[3][1] == 1) {

			System.out.println();
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public boolean checkWinSpieler2() {
		if (spielfeld[1][1] == 2 && spielfeld[1][2] == 2 && spielfeld[1][3] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[2][1] == 2 && spielfeld[2][2] == 2 && spielfeld[2][3] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[3][1] == 2 && spielfeld[3][2] == 2 && spielfeld[3][3] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][1] == 2 && spielfeld[2][1] == 2 && spielfeld[3][1] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][2] == 2 && spielfeld[2][2] == 2 && spielfeld[3][2] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][3] == 2 && spielfeld[2][3] == 2 && spielfeld[3][3] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][1] == 2 && spielfeld[2][2] == 2 && spielfeld[3][3] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else if (spielfeld[1][3] == 2 && spielfeld[2][2] == 2 && spielfeld[3][1] == 2) {

			System.out.println();
			System.out.println();
			return true;
		} else {
			return false;
		}
	}
}