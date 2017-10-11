package sorting;
import java.util.Scanner;

/**
 * Class to be run from the command line. User can specify the algorithm they wish
 * to use, and will be prompted to provide an array of integers to be sorted.
 */
public class SortingAlgorithms {
	private static final String INVALID_INPUT = "Please specify a valid sorting algorithm as the first argument."; 

	public static void main(String[] args) {
		// process the CL argument to determine what sorting algorithm to use.
		String alg;
		try {
			alg = args[0];
		} catch (IndexOutOfBoundsException e) {
			System.out.println(INVALID_INPUT);
			return;
		}

		// prompt the user to enter the array they wish to be sorted
		Scanner values = new Scanner(System.in);
		System.out.print("Enter the number of integers to be in this array: ");
		int numValues = values.nextInt();
		
		// initialize the array
		int[] toSort = new int[numValues];
		System.out.println("Enter the numbers to be in the array:");
		for (int i = 0; i < numValues; i++) {
			toSort[i] = values.nextInt();
		}
		values.close();


		Sorter sorter;
		switch(alg) {
		case "ms":
			System.out.println("Sorting with merge sort...");
			sorter = new MergeSort();
			break;
		case "bs":
			System.out.println("Sorting with bubble sort...");
			sorter = new BubbleSort();
			break;
		case "is":
			System.out.println("Sorting with insertion sort...");
			sorter = new InsertionSort();
			break;
		case "qs":
			System.out.println("Sorting with quick sort...");
			sorter = new QuickSort();
			break;
		default:
			System.out.println(INVALID_INPUT);
			return;
		}
		
		// sort array and print the result
		int[] sortedArray = sorter.sort(toSort);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}
}
