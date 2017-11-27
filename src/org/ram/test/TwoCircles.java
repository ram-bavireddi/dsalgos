package org.ram.test;

import java.util.*;

public class TwoCircles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();

        String[] info = readNextLines(scanner, testCases);

        String[] relations = circles(info);
        Arrays.asList(relations).forEach(System.out::println);
    }

    private static String[] circles(String[] info) {
        String[] relations = new String[info.length];
        for (int i = 0; i < info.length; i++) {
            String[] values = info[i].split(" ");

            int x0 = Integer.parseInt(values[0]);
            int y0 = Integer.parseInt(values[1]);
            int r0 = Integer.parseInt(values[2]);
            int x1 = Integer.parseInt(values[3]);
            int y1 = Integer.parseInt(values[4]);
            int r1 = Integer.parseInt(values[5]);

            int distance = distanceBetweenCircles(x0, y0, x1, y1);
            int radiusSum = radiusSum(r0, r1);
            int radiusDiff = radiusDiff(r0, r1);

            if (areTouching(distance, radiusSum, radiusDiff)) {
                relations[i] = "Touching";
            } else if (areCocentric(x0, x1, y0, y1)) {
                relations[i] = "Cocentric";
            } else if (areDisjointOutside(distance, radiusSum)) {
                relations[i] = "Disjoint-Outside";
            } else if (areDisjointInside(distance, radiusDiff)) {
                relations[i] = "Disjoint-Inside";
            } else {
                relations[i] = "Intersecting";
            }

        }
        return relations;
    }

    private static boolean areTouching(int distance, int radiusSum, int radiusDiff) {
        return distance == radiusSum || distance == radiusDiff;
    }

    private static boolean areCocentric(int x0, int x1, int y0, int y1) {
        return x0 == x1 && y0 == y1;
    }

    private static boolean areDisjointOutside(int distance, int radiusSum) {
        return distance > radiusSum;
    }

    private static boolean areDisjointInside(int distance, int radiusDiff) {
        return distance < radiusDiff;
    }

    private static int distanceBetweenCircles(int x0, int y0, int x1, int y1) {
        return (int) Math.hypot(x0 - x1, y0 - y1);
    }

    private static int radiusSum(int r0, int r1) {
        return r0 + r1;
    }

    private static int radiusDiff(int r0, int r1) {
        return Math.abs(r0 - r1);
    }

    private static String[] readNextLines(Scanner scanner, int size) {
        String[] info = new String[size];
        for (int i = 0; i < size; i++) {
            info[i] = scanner.nextLine();
        }
        return info;
    }
}


/*
4
12 0 21 14 0 23
0 45 8 0 94 9
35 0 13 10 0 38
0 26 8 0 9 25

5
0 5 9 0 9 7
0 15 11 0 20 16
26 0 10 39 0 23
37 0 5 30 0 11
41 0 0 28 0 13
 */