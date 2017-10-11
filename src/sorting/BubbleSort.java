package sorting;

public class BubbleSort implements Sorter {

	public int[] sort(int[] x) {
		
		boolean sorted;
		do {
			sorted = true;
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i + 1] < x[i]) {
					// swap consecutive elements if they are out of order
					int temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					sorted = false;
				}
			}
		} while (!sorted);
		
		return x;
	}

}
