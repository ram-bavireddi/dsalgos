package org.ram.test;

import java.util.*;

public class InTheFuture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ashaProblemsPerDay = scanner.nextInt();
        int kellyProblemsPerDay = scanner.nextInt();
        int noOfProblemsAshaAheadOfKelly = scanner.nextInt();

        int minNumOfDays = minNum(ashaProblemsPerDay, kellyProblemsPerDay, noOfProblemsAshaAheadOfKelly);
        System.out.println(minNumOfDays);

    }

    private static int minNum(int ashaProblemsPerDay, int kellyProblemsPerDay, int noOfProblemsAshaAheadOfKelly) {
        if (!isInputValid(ashaProblemsPerDay, kellyProblemsPerDay, noOfProblemsAshaAheadOfKelly)) {
            return -1;
        }
        if (ashaProblemsPerDay >= kellyProblemsPerDay) {
            return -1;
        }

        int minNumOfDays = 1;

        int ashaTotalNumOfProblems = ashaProblemsPerDay + noOfProblemsAshaAheadOfKelly;
        int kellyTotalNumOfProblems = kellyProblemsPerDay;

        while (kellyTotalNumOfProblems <= ashaTotalNumOfProblems) {
            ashaTotalNumOfProblems += ashaProblemsPerDay;
            kellyTotalNumOfProblems += kellyProblemsPerDay;
            minNumOfDays++;
        }

        return minNumOfDays;
    }

    private static boolean isInputValid(int ashaProblemsPerDay, int kellyProblemsPerDay, int noOfProblemsAshaAheadOfKelly) {
        return 1 <= ashaProblemsPerDay && ashaProblemsPerDay <= 100 &&
                1 <= kellyProblemsPerDay && kellyProblemsPerDay <= 100 &&
                0 <= noOfProblemsAshaAheadOfKelly && noOfProblemsAshaAheadOfKelly <= 100;
    }
}
