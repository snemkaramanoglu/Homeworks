package Projeler;

import java.util.Scanner;

public class Sorting {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of elements: ");
		int x = scan.nextInt();
		int[] dizi = new int[x];
		System.out.print("Enter " + x + " elements: ");
		for (int i = 0; i < dizi.length; i++) {
			dizi[i] = scan.nextInt();
		}

		bubbleSort(dizi.clone());
		selectionSort(dizi.clone());
		insertionSort(dizi.clone());

	}

	private static void bubbleSort(int[] dizi) {
		int temp, comparision = 0, swap = 0;
		for (int i = 0; i < dizi.length - 1; i++) {
			for (int j = 0; j < dizi.length - i - 1; j++) {

				if (dizi[j] > dizi[j + 1]) {
					temp = dizi[j + 1];
					dizi[j + 1] = dizi[j];
					dizi[j] = temp;
					swap++;
					comparision++;

				} else
					comparision++;
			}
		}
		System.out.print("Bubble Sort: ");
		for (int i = 0; i < dizi.length; i++) {
			System.out.print(dizi[i] + " ");
		}
		System.out.print(" - " + comparision + " comparisions, " + swap
				+ " swaps");
		System.out.println("");
	}

	public static void selectionSort(int[] dizi) {
		int yedek, minIndex, comparision = 0, swap = 0;
		for (int i = 0; i < dizi.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < dizi.length; j++) {
				comparision++;

				if (dizi[j] < dizi[minIndex]) {
					minIndex = j;
				}

			}

			yedek = dizi[i];
			dizi[i] = dizi[minIndex];
			dizi[minIndex] = yedek;
			swap++;

		}
		System.out.print("Selection Sort: ");
		for (int i = 0; i < dizi.length; i++) {
			System.out.print(dizi[i] + " ");
		}
		System.out.print(" - " + comparision + " comparisions, " + swap
				+ " swaps");
		System.out.println("");
	}

	private static void insertionSort(int[] dizi) {
		int temp, j, comparision = 0;

		for (int i = 1; i < dizi.length; i++) {
			j = i;
			temp = dizi[i];

			comparision++;
			while (j > 0 && dizi[j - 1] > temp) {
				dizi[j] = dizi[j - 1];
				j--;
			}
			dizi[j] = temp;

		}
		System.out.print("Insertion Sort: ");
		for (int i = 0; i < dizi.length; i++) {
			System.out.print(dizi[i] + " ");
		}
		System.out.print(" - " + comparision + " comparisions");

	}
}
