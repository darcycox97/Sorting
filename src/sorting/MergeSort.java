package sorting;

public class MergeSort implements Sorter {


	public int[] sort(int[] x) {

		// base case
		if (x.length <= 1) {
			return x;
		}

		// split array into halves
		int midPoint = x.length/2;

		int[] left = new int[midPoint];
		for (int i = 0; i < midPoint; i++) {
			left[i] = x[i];
		}

		int[] right = new int[x.length - midPoint];
		for (int i = midPoint; i < x.length; i++) {
			right[i - midPoint] = x[i];
		}

		// sort each half recursively
		int[] leftSorted = sort(left);
		int[] rightSorted = sort(right);

		// merge the result
		return merge(leftSorted, rightSorted);
	}


	private int[] merge(int[] a, int[] b) {
		// set up array to be returned
		int mergedLength = a.length + b.length;
		int[] merged = new int[mergedLength];

		int aPos = 0;
		int bPos = 0;
		int mergedPos = 0;
		while (aPos < a.length && bPos < b.length) {
			if (a[aPos] < b[bPos]) {
				merged[mergedPos] = a[aPos];
				aPos++;
			} else {
				merged[mergedPos] = b[bPos];
				bPos++;
			}
			mergedPos++;
		}

		// determine which array did not get processed entirely (if this is the case) and append the remaining elements to merged.
		if (aPos < a.length) {
			for (int i = mergedPos; i < mergedLength; i++) {
				merged[i] = a[aPos];
				aPos++;
			}
		}

		if (bPos < b.length) {
			for (int i = mergedPos; i < mergedLength; i++) {
				merged[i] = b[bPos];
				bPos++;
			}
		}

		return merged;
	}

}
