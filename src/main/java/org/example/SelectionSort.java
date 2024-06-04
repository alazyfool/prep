package com.company;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = {5,3,1,2,4,2};
    System.out.println(Arrays.toString(selectionSort(arr)));
  }

  public static int[] selectionSort(int[] arr) {

    int minTillNow = 0;
    int minIndex = 0;

    for (int i = 0; i < arr.length; i++) {
      minTillNow = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] <= minTillNow) {
          minTillNow = arr[j];
          minIndex = j;
        }
      }

      if (minIndex != i) {
        int c = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = c;
      }
    }

    return arr;
  }
}
