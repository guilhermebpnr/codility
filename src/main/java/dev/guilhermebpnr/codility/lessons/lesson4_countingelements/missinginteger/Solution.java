package dev.guilhermebpnr.codility.lessons.lesson4_countingelements.missinginteger;

/**
 * MissingInteger
 *
 * Find the smallest positive integer that does not occur in a given sequence.
 *
 * Level: Respectable
 *
 * Write a function:
 *
 *     class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 *     - N is an integer within the range [1..100,000];
 *     - each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 * Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

class Solution {

    public static final int MAX_POSITIVE_VALUE = 1000000;

    public int solution(int[] A) {

        boolean[] flagArray = new boolean[MAX_POSITIVE_VALUE + 1];

        init(flagArray);

        setFlagForFoundPositiveElements(flagArray, A);

        int pos = getPositionOfFirstAbsentPositiveElement(flagArray);

        return pos;
    }

    private void init(boolean[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = false;
        }
    }

    private void setFlagForFoundPositiveElements(boolean[] flagArray, int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                flagArray[A[i]] = true;
            }
        }
    }

    private int getPositionOfFirstAbsentPositiveElement(boolean[] flagArray) {
        int pos = -1;

        for (int i = 1; i < flagArray.length - 1 && pos == -1; i++) {
            if (flagArray[i] == false) {
                pos = i;
            }
        }

        return pos;
    }

}
