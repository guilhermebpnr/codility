package dev.guilhermebpnr.codility.lessons.lesson4_countingelements.permcheck;

/**
 * PermCheck
 * <p>
 * Check whether array A is a permutation.
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * <p>
 * is a permutation, but array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * <p>
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * <p>
 * the function should return 1.
 * <p>
 * Given array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * <p>
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * <p>
 * Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

public class Solution {

    public static final int MAX_LENGTH = 100000;
    public static final int MIN_LENGTH = 1;

    public int solution(int[] A) {
        if (isEveryAssumptionMet(A)
                && hasArrayCorrectLength(A)
                && isEachElementPresentOnceAndOnlyOnce(A)
        ) {
            return 1;
        }
        return 0;
    }

    private boolean isEveryAssumptionMet(int[] A) throws IllegalArgumentException {
        if (A.length < MIN_LENGTH) {
            throw new IllegalArgumentException("Array is too short: " + A.length);
        }
        if (A.length > MAX_LENGTH) {
            throw new IllegalArgumentException("Array is too long: " + A.length);
        }
        for (int i = 0; i < A.length; i++) {
            if (!isElementWithinRange(A[i])) {
                throw new IllegalArgumentException("Element of array outside the range [1..1,000,000,000]: " + A[i]);
            }
        }
        return true;
    }

    private boolean hasArrayCorrectLength(int[] A) {
        int maxElement = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxElement)
                maxElement = A[i];
        }
        if (maxElement != A.length) {
            return false;
        }
        return true;
    }

    private boolean isElementWithinRange(int element) {
        if (element >= 1
                && element <= 1000000000) {
            return true;
        }
        return false;
    }

    private boolean isEachElementPresentOnceAndOnlyOnce(int[] A) {
        int[] countArray = new int[A.length];
        countElements(A, countArray);
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 1) {
                return false;
            }
        }
        return true;
    }

    private void countElements(int[] A, int[] countArray) {
        initializeArrayWithZeroes(countArray);
        assert hasArrayCorrectLength(A) : "Input array has the wrong length.";
        for (int i = 0; i < A.length; i++) {
            countArray[A[i] - 1] += 1;
        }
    }

    private void initializeArrayWithZeroes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }
}
