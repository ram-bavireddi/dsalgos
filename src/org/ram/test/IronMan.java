package org.ram.test;

import java.util.*;

public class IronMan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfPowers = scanner.nextInt();
        int[] powers = readNextLines(scanner, noOfPowers);

        int minimumPowerRequired = ironMan(powers);
        System.out.println(minimumPowerRequired);
    }

    private static int ironMan(int[] powers) {
        int powerRequired = 1;
        int powerLeft = 1;

        for (int power : powers) {
            if (isNegativePower(power) && isAbsPowerGreaterThanPowerLeft(power, powerLeft)) {
                powerRequired = powerRequired + Math.abs(power) - powerLeft + 1;
                powerLeft = 1;
            } else {
                powerLeft = powerLeft + power;
            }
        }
        return powerRequired;
    }

    private static boolean isNegativePower(int power) {
        return power < 0;
    }

    private static boolean isAbsPowerGreaterThanPowerLeft(int power, int powerLeft) {
        return Math.abs(power) > powerLeft;
    }

    private static int[] readNextLines(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
