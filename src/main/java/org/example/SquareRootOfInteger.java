package com.company;

import java.math.BigInteger;

public class SquareRootOfInteger {
    public static void main(String[] args) {
        Solution45 obj = new Solution45();
        System.out.println(obj.sqrt(930675566));
    }
}

class Solution45 {
    public int sqrt(int A) {
        int high = A / 2;
        int low = 0;
        int answer = -1;
        BigInteger x = BigInteger.valueOf(A);

        while (low <= high) {
            int mid = (low + high) / 2;
            BigInteger sqr = BigInteger.valueOf(mid).multiply(BigInteger.valueOf(mid));

            if (sqr.compareTo(x) == 0) {
                return mid;
            } else if (sqr.compareTo(x) == -1) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
}

