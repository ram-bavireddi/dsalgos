package org.ram.test;

import java.util.*;

public class PsychometricTesting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfScores = scanner.nextInt();
        int[] scores = readNextLines(scanner, noOfScores);

        int noOfLowerLimits = scanner.nextInt();
        int[] lowerLimits = readNextLines(scanner, noOfLowerLimits);

        int noOfUpperLimits = scanner.nextInt();
        int[] upperLimits = readNextLines(scanner, noOfUpperLimits);

        int[] candidatesWhoGotJobOffers = findCandidatesWhoGotJobOffers(scores, lowerLimits, upperLimits);
        printArray(candidatesWhoGotJobOffers);
    }

    private static int[] findCandidatesWhoGotJobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < lowerLimits.length; i++) {
            int noOfCandidatesWithInRange = 0;
            for (int score : scores) {
                if (isCandidateWithInRange(lowerLimits[i], score, upperLimits[i])) {
                    ++noOfCandidatesWithInRange;
                }
            }
            candidates.add(noOfCandidatesWithInRange);
        }
        
        return toArray(candidates);
    }

    private static boolean isCandidateWithInRange(int lowerLimit, int score, int upperLimit) {
        return lowerLimit <= score && score <= upperLimit;
    }

    private static int[] toArray(List<Integer> intList) {
        int[] ints = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            ints[i] = intList.get(i);
        }
        return ints;
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
