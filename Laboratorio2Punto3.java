import java.util.Arrays;

public class Laboratorio2Punto3 {
  
  public static void bubbleSort(double[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
      for (int j = 0; j < n-i-1; j++) {
        if (arr[j] > arr[j+1]) {
          double temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
  }

  public static void insertionSort(double[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      double key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  public static void selectionSort(double[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
      int min_idx = i;
      for (int j = i+1; j < n; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
      }
      double temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  public static void mergeSort(double[] arr, int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      mergeSort(arr, l, m);
      mergeSort(arr, m+1, r);
      merge(arr, l, m, r);
    }
  }

  public static void merge(double[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    double[] L = new double[n1];
    double[] R = new double[n2];
    for (int i = 0; i < n1; ++i) {
      L[i] = arr[l + i];
    }
    for (int j = 0; j < n2; ++j) {
      R[j] = arr[m + 1 + j];
    }
    int i = 0, j = 0;
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args) {
    int[] sizes = {100, 500, 1000, 5000, 10000};
    System.out.println("|   Tamaño   |   Burbuja   |   Inserción    |   Seleccion    |  Mergesort  |");
    System.out.println("|------------|-------------|----------------|----------------|-------------|");
for (int size : sizes) {
  double[] arr = new double[size];
  for (int i = 0; i < size; i++) {
    arr[i] = Math.random();
  }
  double[] arrCopy = Arrays.copyOf(arr, arr.length);
  
  // Bubble Sort
  long start = System.nanoTime();
  bubbleSort(arr);
  long end = System.nanoTime();
  long bubbleSortTime = end - start;

  // Insertion Sort
  start = System.nanoTime();
  insertionSort(arrCopy);
  end = System.nanoTime();
  long insertionSortTime = end - start;

  // Selection Sort
  arrCopy = Arrays.copyOf(arr, arr.length);
  start = System.nanoTime();
  selectionSort(arrCopy);
  end = System.nanoTime();
  long selectionSortTime = end - start;

  // Merge Sort
  arrCopy = Arrays.copyOf(arr, arr.length);
  start = System.nanoTime();
  mergeSort(arrCopy, 0, arrCopy.length-1);
  end = System.nanoTime();
  long mergeSortTime = end - start;

  System.out.printf("| %10d | %11d | %14d | %14d | %11d |\n", size, bubbleSortTime, insertionSortTime, selectionSortTime, mergeSortTime);
}
  }
}
