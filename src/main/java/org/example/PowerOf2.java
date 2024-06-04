package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowerOf2 {
  public static void main(String[] args) {
    Solution81 obj = new Solution81();
    System.out.println(obj.power("0"));
  }
}

class Solution81 {
  public int power(String A) {
    BigInteger a = new BigInteger(A);
    if (a.compareTo(BigInteger.valueOf(2)) == -1) {
      return 0;
    }

    Set<Long> set = new HashSet<>(Arrays.asList(1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L, 16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, 2147483648L));


    BigInteger maxInteger = BigInteger.valueOf(2147483648L);

    while (a.compareTo(maxInteger) == 1) {
      // if odd, return 0;
      if (odd(a)) {
        return 0;
      }
      a = a.divide(maxInteger);
    }
    return set.contains(a.longValue()) ? 1 : 0;
  }

  public boolean odd(BigInteger val) {
    return !val.mod(new BigInteger("2")).equals(BigInteger.ZERO);
  }
}
