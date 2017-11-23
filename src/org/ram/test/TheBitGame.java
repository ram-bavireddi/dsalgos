package org.ram.test;

import java.util.*;

public class TheBitGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int k = scanner.nextInt();

        int maxXor = maxXor(left, right, k);

        System.out.println(maxXor);
    }

    private static int maxXor(int left, int right, int k) {
        int maxXor = 0;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                int xor = xor(i, j);
                if (isGreaterXor(xor, maxXor)) {
                    maxXor = xor;
                }

            }
        }
        return maxXor;
    }

    private static int xor(int x, int y) {
        return x ^ y;
    }

    private static boolean isGreaterXor(int xor, int maxXor) {
        return xor > maxXor;
    }
}
