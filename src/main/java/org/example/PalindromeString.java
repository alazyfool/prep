package com.company;

public class PalindromeString {
    public static void main(String[] args) {
        Solution6 obj = new Solution6();
        System.out.println(obj.isPalindrome("a man n;am a"));
    }
}

class Solution6 {
    private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]";

    public int isPalindrome(String A) {
        int startIndex = 0;
        int endIndex = A.length() - 1;

        while(startIndex < A.length() && endIndex >= 0) {
            if (!isAlphaNumeric(A.charAt(startIndex))) {
                startIndex++;
                continue;
            } else if (!isAlphaNumeric(A.charAt(endIndex))) {
                endIndex--;
                continue;
            }

            if (!charEqual(A.charAt(startIndex), A.charAt(endIndex))) {
                return 0;
            }
            startIndex++; endIndex--;
        }
        return 1;
    }

    boolean charEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    boolean isAlphaNumeric(char character) {
        return ((character >= 48 && character <= 57)
                || (character >= 65 && character <=  90)
                || (character >= 97 && character <= 122)
        );
    }
}
