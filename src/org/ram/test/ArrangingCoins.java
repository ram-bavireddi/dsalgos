package org.ram.test;

import java.util.*;

public class ArrangingCoins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfCoins = scanner.nextInt();
        long[] coins = readNextLines(scanner, noOfCoins);
        arrangeCoins(coins);
    }

    private static void arrangeCoins(long[] coins) {
        for (long coin : coins) {
            System.out.println(getMaximumPossibleStairCase(coin));
        }
    }

    /**
     * (x + 1) * x / 2 = n
     * (1 + x) * x = 2*n
     * 4x*x + 4*x = 8*n
     * (2x + 1)(2x + 1) - 1 = 8*n
     * x = (int)(Math.sqrt(8*n + 1) - 1) / 2;
     **/
    private static int getMaximumPossibleStairCase(long coin) {
        return (int) (Math.sqrt(8 * coin + 1) - 1) / 2;
    }

    private static long[] readNextLines(Scanner scanner, int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLong();
        }
        return array;
    }
}
