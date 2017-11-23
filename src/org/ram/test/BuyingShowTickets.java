package org.ram.test;

import java.util.*;

public class BuyingShowTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfPersons = scanner.nextInt();
        int[] tickets = readNextLines(scanner, noOfPersons);

        int jessePosition = scanner.nextInt();

        int waitingTime = waitingTime(tickets, jessePosition);
        System.out.println(waitingTime);
    }

    private static int waitingTime(int[] tickets, int jessePosition) {
        int waitingTime = 0;
        int jesseWaitingTime = tickets[jessePosition];

        for (int position = 0; position < tickets.length; position++) {
            if (position < jessePosition) {
                waitingTime += Math.min(tickets[position], jesseWaitingTime);
            } else if (position == jessePosition) {
                waitingTime += jesseWaitingTime;
            } else {
                waitingTime += Math.min(tickets[position], jesseWaitingTime - 1);
            }
        }

        return waitingTime;
    }

    private static int[] readNextLines(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
