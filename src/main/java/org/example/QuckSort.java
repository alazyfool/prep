package com.company;

import java.util.Arrays;

public class QuckSort {
  public static void main(String[] args) {
    int[] arr = {3,5,6,9,8,7,2,1,0};
    System.out.println(Arrays.toString(quicksort(arr, 0, arr.length - 1)));
  }

  public static int[] quicksort(int[] arr, int low, int high) {
    int pivot = arr[low];
    if (low >= high) {
      return arr;
    }

    int i = low, j = high;

    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        i++;
        j--;
      }
    }
    quicksort(arr, low, j );
    quicksort(arr, i, high);
    return arr;
  }
}
