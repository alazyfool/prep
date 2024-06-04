package com.company;

// this was part of turing test

public class sortedString {
    public static void main(String[] args) {
        String s = "talentcloudturing";
        int[] k = {6,7,8,9,10,11,12,13,14,15,16,0,1,2,3,4,5};
        System.out.println(soln(s, k));
    }
    static String soln(String s, int[] k) {
        char[] c = new char[s.length()];
        for(int i=0; i < s.length(); i++){
            c[k[i]] = s.charAt(i);
        }
        return String.valueOf(c);
    }
}
