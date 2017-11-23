package org.ram.test;

import java.util.Scanner;

public class FindTheWinner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfAndreaElements = scanner.nextInt();
        int[] andreaElements = readNextLines(scanner, noOfAndreaElements);

        int noOfMariaElements = scanner.nextInt();
        int[] mariaElements = readNextLines(scanner, noOfMariaElements);

        String gameMode = scanner.next();

        System.out.println(findTheWinner(andreaElements, mariaElements, gameMode));
    }

    private static String findTheWinner(int[] andreaElements, int[] mariaElements, String gameMode) {
        int andreaScore = 0;
        int mariaScore = 0;

        int firstMove;
        int totalMoves = andreaElements.length;

        if ("Even".equalsIgnoreCase(gameMode)) {
            firstMove = 0;
        } else {
            firstMove = 1;
        }

        for (int move = firstMove; move < totalMoves; move = move + 2) {
            andreaScore += andreaElements[move] - mariaElements[move];
            mariaScore += mariaElements[move] - andreaElements[move];
        }

        if (andreaScore > mariaScore) {
            return "Andrea";
        } else if (mariaScore > andreaScore) {
            return "Maria";
        } else {
            return "Tie";
        }
    }

    private static int[] readNextLines(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
