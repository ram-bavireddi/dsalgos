package org.ram.test;

import java.util.*;

public class CountingGroups {

    private static int count = 0;
    private static final int[] ROWS = {-1, 0, 0, 1};
    private static final int[] COLS = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, rows, cols);

        int noOfQueries = scanner.nextInt();
        int[] queries = readNextLines(scanner, noOfQueries);

        int[] groups = countGroups(matrix, queries);
        printArray(groups);
    }

    private static int[] countGroups(int[][] matrix, int[] queries) {
        int[] ret = new int[queries.length];
        boolean visited[][] = new boolean[matrix.length][matrix.length];
        Map<Integer, Integer> counterMap = new HashMap<>();

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                if (isCellVisitable(matrix, visited, x, y)) {
                    visitCell(matrix, visited, x, y);
                    if (counterMap.containsKey(count)) {
                        counterMap.put(count, counterMap.get(count) + 1);
                    } else {
                        counterMap.put(count, 1);
                    }
                    count = 0;
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            ret[i] = counterMap.getOrDefault(queries[i], 0);
        }

        return ret;
    }

    private static void visitCell(int matrix[][], boolean visited[][], int x, int y) {
        ++count;
        visited[x][y] = true;
        for (int i = 0; i < ROWS.length; i++) {
            if (isCellVisitable(matrix, visited, x + ROWS[i], y + COLS[i])) {
                visitCell(matrix, visited, x + ROWS[i], y + COLS[i]);
            }
        }
    }

    private static boolean isCellVisitable(int matrix[][], boolean visited[][], int x, int y) {
        return 0 <= x && x < matrix.length &&
                0 <= y && y < matrix.length &&
                !visited[x][y] &&
                matrix[x][y] == 1;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[] readNextLines(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
    }
}

/*
Test case1:
10
10
1 1 1 1 1 1 1 1 1 1
1 1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 1 1 1
1 1 0 0 1 0 0 1 1 1
1 0 1 0 0 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1
5
1
10
20
2
6

Test case2:
5
5
1 0 1 1 0
0 1 0 0 1
1 0 1 1 0
1 0 1 1 0
0 1 0 0 1
5
1
2
3
4
5
*/
