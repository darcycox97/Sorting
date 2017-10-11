package sorting;

public class InsertionSort implements Sorter {

	public int[] sort(int[] x) {
		
		for (int i = 1; i < x.length; i++) {
			int element = x[i];
			int j = i - 1;
			while (j >= 0 && element < x[j]) {
				x[j + 1] = x[j];
				j--;
			}
			x[j + 1] = element;
		}
		return x;
	}

}
