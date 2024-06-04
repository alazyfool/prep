package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {5,4,3,2,1,6};
    bubbleSort(arr);
  }

  public static int[] bubbleSort(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
      for (int j = 0; j <= i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int c = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = c;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }
}
