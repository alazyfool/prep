package com.company;

// this was part of turing test
public class removeDuplicates {
    public static void main(String[] args) {
        Solution12 obj = new Solution12();
        System.out.println(obj.rd("tttttttuuuuuuuriiiiiiinnggg"));
    }
}


class Solution12 {
    public String rd(String s) {
        String answer = "";
        int count = 0;
        char cih = '.';
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != cih) {
                cih = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
            if (count <= 3) {
                answer += s.charAt(i);
            }

        }
        return answer;
    }
}