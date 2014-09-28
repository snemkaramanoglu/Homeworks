/* Furkan ÖZBAY and Sinem KARAMANOÐLU are pair for this homework*/

package Projeler;

import java.util.Scanner;

public class Bag {
	static int[] bagArray = new int[100];
	static int index = 0;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String x = null;
		String[] a = null;
		while (true) {
			try {
				System.out
						.println("Add(A), Delete(D), Find(F), Size(S), Min(m), Max(M), List(L), Quit(Q) >>");
				x = scan.nextLine();
				a = new String[x.split(" ").length];
				a = x.split(" ");

				switch (a[0]) {
				case "A":
					add(Integer.parseInt(a[1]));
					break;
				case "D":
					delete(Integer.parseInt(a[1]));
					break;
				case "F":
					find(Integer.parseInt(a[1]));
					break;
				case "S":
					size();
					break;
				case "m":
					min();
					break;
				case "M":
					max();
					break;
				case "L":
					list();
					break;
				case "Q":
					quit();
				default:
					System.out.println("You entered unknown command");

				}
			} catch (Exception e) {
				System.out.println("Please enter the command properly");
			}
		}

	}

	public static void add(int number) {
		bagArray[index] = number;
		++index;
		System.out.println(number + " is added to the Bag.");
	}

	public static void delete(int number) {
		boolean found = false;
		boolean found2 = false;
		int i;
		for (i = 0; i < bagArray.length; i++) {
			if (number == bagArray[i]) {
				found = true;
				break;
			}
		}
		if (found) {
			for (int j = i; j < bagArray.length - 1; j++) {
				found2 = true;
				bagArray[j] = bagArray[j + 1];
			}
			System.out.println(number + " is deleted from the Bag.");
		}
		if (found2)
			--index;

		if (!found) {
			System.out.println("Cannot delete " + number
					+ ". It does not exist in the Bag.");
		}
	}

	public static void find(int number) {
		boolean found = false;
		int i;
		for (i = 0; i < bagArray.length; i++) {
			if (number == bagArray[i]) {
				found = true;
				break;
			}
		}
		if (found) {
			if (count(bagArray[i]) == 1)
				System.out.println("There is (" + count(bagArray[i]) + ") "
						+ number + " in the Bag.");
			else
				System.out.println("There are (" + count(bagArray[i]) + ") "
						+ number + " in the Bag.");
		} else
			System.out.println(number + " does not exist in the Bag.");

	}

	public static void size() {
		int counter = 0;
		for (int i = 0; i < bagArray.length; i++) {
			if (bagArray[i] != 0) {
				counter++;
			}
		}
		if(counter>1) System.out.println("There are "+ counter +"numbers in the Bag.");
		else System.out.println("There is "+counter+" numbers in the Bag.");
	  }

	public static void min() {
		int x = bagArray[0];
		for (int i = 0; i < bagArray.length - 1; i++) {
			if (bagArray[i + 1] != 0) {
				if (x > bagArray[i + 1])
					x = bagArray[i + 1];
			}
		}
		System.out.println("Minimum: " + x);
	}

	public static void max() {
		int x = bagArray[0];
		for (int i = 0; i < bagArray.length - 1; i++) {
			if (bagArray[i + 1] != 0) {
				if (x < bagArray[i + 1])
					x = bagArray[i + 1];
			}
		}
		System.out.println("Maximum: " + x);
	}

	public static void list() {
		//Pdfdeki gibi çizilecekse %9=0 olanlarda +
		//geri kalanlar -
		int[] reg = new int[100];
		boolean found = true;
		System.out.println("+-----------+-----------+");
		System.out.println("|   Number  |   Occurs  |");
		for (int i = 0; i < bagArray.length; i++) {

			for (int j = 0; j < i; j++) {
				if (bagArray[i] != reg[j])
					found = true;
				else {
					found = false;
					break;
				}
			}
			if (bagArray[i] != 0 & found) {
				System.out.println("+-----------+-----------+");
				System.out.format("|%11d|", bagArray[i]);
				System.out.format("%11d|", count(bagArray[i]));
				System.out.println();
				reg[i] = bagArray[i];
			}
		}
		System.out.println("+-----------+-----------+");
	}

	public static int count(int number) {
		int counter = 0;
		for (int i = 0; i < bagArray.length; i++) {
			if (bagArray[i] != 0) {
				if (number == bagArray[i])
					++counter;
			}
		}
		return counter;
	}

	public static void quit() {
		System.out.println("Bye");
		System.exit(0);
	}
}
