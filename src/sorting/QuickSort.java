package sorting;

public class QuickSort implements Sorter {

	// this implementation of quick sort uses the last element in the array as the pivot.
	public int[] sort(int[] x) {
		
		// base case
		if (x.length == 1 || x.length == 0) {
			return x;
		}
		
		int pivot = x[x.length - 1];
		
		// partition the array so that elements smaller than pivot are to the left of it.
		int j = 0; // holds the index to place smaller elements in
		for (int i = 0; i < x.length - 1; i++) {
			if (x[i] <= pivot) {
				int temp = x[j];
				x[j] = x[i];
				x[i] = temp;
				j++;
			}
		}
		
		// swap j with pivot, all elements to the left will be less than pivot
		int temp = x[j];
		x[j] = x[x.length - 1];
		x[x.length - 1] = temp;
		
		// recursively sort the subarrays to the left and right of pivot.
		int[] left = new int[j];
		for (int i = 0; i < j; i++) {
			left[i] = x[i];
		}
		
		int[] right = new int[x.length - j - 1];
		for (int i = j + 1; i < x.length; i++) {
			right[i - (j + 1)] = x[i];
		}
		
		int[] leftSorted = sort(left);
		int[] rightSorted = sort(right);
		
		// combine the left half, the pivot, and the right half
		for (int i = 0; i < x.length; i++) {
			if (i < leftSorted.length) {
				x[i] = leftSorted[i];
			} else if (i == leftSorted.length) {
				x[i] = pivot;
			} else {
				x[i] = rightSorted[i - (leftSorted.length + 1)];
			}
		}
		
		return x;
	}

}
