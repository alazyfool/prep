package com.company;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {2,3,6,9,11,12,15,16,17,18,19};
//    System.out.println(binarySearch(arr, 0, arr.length - 1, 12));
    System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 18));


    for (int ar: arr) {
      if (binarySearchRecursive(arr, 0, arr.length - 1, ar)) {
        System.out.println(true);
      } else {
        System.out.println(false);
        System.out.println(ar);
      }
    }
  }

  public static boolean binarySearch(int[] arr, int needle) {
    int low = 0;
    int high = arr.length - 1;
    int mid = (low + high) / 2;

    while (low <= high) {
      if (arr[mid] == needle) {
        return true;
      } else if (arr[mid] < needle) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
      mid = (low + high) / 2;
    }
    return false;
  }

  public static boolean binarySearchRecursive(int[] arr, int low, int high, int needle) {
    if (low > high) {
      return false;
    }

    int mid = (high + low) / 2;

    if (arr[mid] == needle) {
      return true;
    }

    if (arr[mid] < needle) {
      return binarySearchRecursive(arr, mid + 1, high, needle);
    }
    return binarySearchRecursive(arr, low, mid - 1, needle);
  }

}
