package dev.guilhermebpnr.codility.lessons.lesson5_prefixsums.passingcars;

/**
 * PassingCars
 * Count the number of passing cars on the road.
 * <p>
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * <p>
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * <p>
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * For example, given:
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * <p>
 * the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * <p>
 * Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

public class Solution {

    private static final int PASSING_CARS_LIMIT = 1000000000;

    public int solution(int[] A) {
        if (A.length < 1) {
            throw new IllegalArgumentException("The input array must contain at least one element. It contains: 0");
        }
        if (A.length > 100000) {
            throw new IllegalArgumentException("The input array can only contain up to 100,000 elements. It contains: " + A.length);
        }
        int[] suffixSum = getSuffixSum(A);
        return getPassingCarsCount(A, suffixSum);
    }

    private int[] getSuffixSum(int[] A) {
        int[] suffixSum = new int[A.length+1];
        suffixSum[suffixSum.length-1] = 0;
        for (int i = suffixSum.length-2; i >= 0 ; i--) {
            if (A[i] != 0 && A[i] != 1) {
                throw new IllegalArgumentException("Each element of the input array must be an integer that can have one of the following values: 0, 1. It was found: " + A[i]);
            }
            suffixSum[i] = suffixSum[i+1] + A[i];
        }
        return suffixSum;
    }

    private int getPassingCarsCount(int[] A, int[] suffixSum) {
        int passingCarsCount = 0;
        for (int i = 0; i < suffixSum.length-2; i++) {
            if (A[i] == 0) {
                passingCarsCount += suffixSum[i];
                if(passingCarsCount > PASSING_CARS_LIMIT) {
                    return -1;
                }
            }
        }
        return passingCarsCount;
    }
}
