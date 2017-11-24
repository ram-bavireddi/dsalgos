package org.ram.test;

import java.util.*;

public class Keyboard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        String keyboard = scanner.next();

        int entryTime = entryTime(s, keyboard);
        System.out.println(entryTime);
    }

    private static int entryTime(String s, String keyboardStr) {
        int[][] keyboard = readKeyboard(keyboardStr);
        int[] digits = readDigits(s);

        int entryTime = 0;
        int xnext = 0;
        int ynext = 0;

        for (int di = 0; di < digits.length; di++) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (digits[di] == keyboard[x][y]) {
                        if (di == 0 && xnext == 0 && ynext == 0) {
                            xnext = x;
                            ynext = y;
                        } else if (xnext != x || ynext != y) {
                            if (xnext + 2 == x || xnext - 2 == x || ynext + 2 == y || ynext - 2 == y) {
                                entryTime += 2;
                                xnext = x;
                                ynext = y;
                            } else {
                                entryTime += 1;
                                xnext = x;
                                ynext = y;
                            }
                        }
                    }
                }
            }
        }

        return entryTime;
    }

    private static int[][] readKeyboard(String keyboardStr) {
        int index = 0;
        int[][] keyboard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, index++) {
                keyboard[i][j] = Integer.parseInt(keyboardStr.charAt(index) + "");
            }
        }
        return keyboard;
    }

    private static int[] readDigits(String str) {
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = Integer.parseInt(str.charAt(i) + "");
        }
        return digits;
    }
}
