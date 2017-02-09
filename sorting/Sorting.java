package sorting;

public class Sorting {

	public static void main(String args[]) {
		int array[] = new int[10];

		array[0] = 33;
		array[1] = 77;
		array[2] = 44;
		array[3] = 88;
		array[4] = 22;
		array[5] = 66;
		array[6] = 11;
		array[7] = 99;
		array[8] = 55;
		array[9] = 0;

		selectiveSortR(array, 0);
		print(array);

	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void swap(int a, int b, int arr[]) {
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// insertion sort
	public static void insertionSortI(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i], j;

			for (j = i; j > 0 && array[j - 1] > temp; j--) {
				array[j] = array[j - 1];
			}
			array[j] = temp;
		}
	}

	public static void insertionSortR(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i], j;

			for (j = i; j > 0 && array[j - 1] > temp; j--) {
				array[j] = array[j - 1];
			}
			array[j] = temp;
		}
	}

	// selective sort
	public static void selectiveSortI(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int m = 0;
			for (int j = 1; j <= i; j++) {
				if (array[j] > array[m]) {
					m = j;
				}
				swap(i, m, array);
			}
		}
	}

	public static void selectiveSortR(int[] array, int front) {
		if (front == array.length - 1) {
			return;
		}
		int small = array[front];
		int indexSmall = front;

		for (int i = front; i < array.length; i++) {
			if (array[i] < small) {
				small=array[i];
				indexSmall = i;
			}
		}
		swap(indexSmall, front, array);
		selectiveSortR(array, front + 1);

	}

	// shell sort
	public static void shellSort(int[] array) {
		for (int d = array.length / 2; d > 0; d = d / 2) {
			for (int c = 0; c < d; c++)
				for (int i = c + d; i < array.length; i += d) {
					int temp = array[i], j = i;
					while (j > c && array[j - d] > temp) {
						array[j] = array[j - d];
						j -= d;
					}
					array[j] = temp;
				}
		}
	}

	// radix sort
	public static void radixSort(int[] array) {
		int i, m = array[0], exp = 1, n = array.length;
		int[] b = new int[10];
		for (i = 1; i < n; i++)
			if (array[i] > m)
				m = array[i];
		while (m / exp > 0) {
			int[] bucket = new int[10];

			for (i = 0; i < n; i++)
				bucket[(array[i] / exp) % 10]++;
			for (i = 1; i < 10; i++)
				bucket[i] += bucket[i - 1];
			for (i = n - 1; i >= 0; i--)
				b[--bucket[(array[i] / exp) % 10]] = array[i];
			for (i = 0; i < n; i++)
				array[i] = b[i];
			exp *= 10;
		}
	}

	// quick sorting
	public static void quickSort(int[] array, int low, int high) {
		if (array == null || array.length == 0) {
			return;
		}
		if (low >= high) {
			return;
		}
		int middle = low + (high - low) / 2;
		int pivot = array[middle];

		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(array, low, j);

		if (high > i)
			quickSort(array, i, high);
	}
}
