package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatAndMissingNumberArrayPENDING {
  public static void main(String[] args) {
    SolutionRAMNA obj = new SolutionRAMNA();
    ArrayList<Integer> s = obj.repeatedNumber(new ArrayList<>(Arrays.asList(new Integer[] {4,3,6,2,1,1})));
    System.out.println(s.toString());
  }
}

class SolutionRAMNA {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
    BigInteger squares = new BigInteger("0");
    BigInteger addition = new BigInteger("0");
    BigInteger squareSum = new BigInteger("0");
    for (int i = 0; i < A.size(); i++) {
      addition = addition.add(BigInteger.valueOf(A.get(i)));
      squares = squares.add(BigInteger.valueOf(A.get(i) * A.get(i)));
      squareSum = squareSum.add(BigInteger.valueOf(((i + 1) * (i + 1))));
    }

    BigInteger actualsum = BigInteger.valueOf(A.size()).multiply(BigInteger.valueOf(A.size() + 1)).divide(BigInteger.TWO);

    BigInteger xMinusy = addition.subtract(actualsum);
    BigInteger x2Minusy2 = squares.subtract(squareSum);
    BigInteger xPlusy = x2Minusy2.divide(xMinusy);
    long x = (xPlusy.subtract(xMinusy)).divide(BigInteger.valueOf(2L)).longValue();
    long y  = xPlusy.longValue() - x;
    return new ArrayList<Integer>(Arrays.asList(new Integer[]{(int)y, (int)x}));

  }
}
