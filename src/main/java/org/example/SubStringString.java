package com.company;

public class SubStringString {
  public static void main(String[] args) {
    String input = "abc";
    substrings(0, 0,input);
//    printSubstringsRecursive(0, input.length(),input);
  }

  // Helper function for recursion
  static void substrings(int start, int end,String in ){
    if(start == in.length() && end == in.length()){
      return;
    }else{
      if(end == in.length()){
        substrings(start+1,start+1, in);
      }else{
        System.out.println(in.substring(start, end+1));
        substrings(start, end+1, in);
      }
    }
  }

  public static void printSubstringsRecursive(int start, int end, String str) {
    if (start == end) {
      return;
    }

    for (int i = start; i < end; i++) {
      System.out.println(str.substring(start, i + 1));
    }

    printSubstringsRecursive( start + 1, end, str);
  }
}
