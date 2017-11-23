package org.ram.test;

import java.util.Scanner;

public class LargestSubsetSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfElements = scanner.nextInt();
        int[] kArray = readNextLines(scanner, noOfElements);

        int[] largestSubsetSum = findLargestSubsetSum(kArray);
        printArray(largestSubsetSum);
    }

    private static int[] findLargestSubsetSum(int[] kArray) {
        int[] result = new int[kArray.length];
        for (int i = 0; i < kArray.length; i++) {
            int k = kArray[i];
            int sumOfLcmOfK = k;
            for (int j = 1; j <= k / 2; j++) {
                if (k % j == 0) {
                    sumOfLcmOfK += j;
                }
            }
            result[i] = sumOfLcmOfK;
        }
        return result;
    }

    private static int[] readNextLines(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
