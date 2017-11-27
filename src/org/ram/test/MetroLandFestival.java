package org.ram.test;

public class MetroLandFestival {

    public static void main(String[] args) {
//        int p[] = {1, 1, 1};
//        int x[] = {5, 2, 3};
//        int y[] = {3, 4, 7};

        int p[] = {1, 1};
        int x[] = {1, 3};
        int y[] = {1, 1};

        System.out.println(minimizeCost(p, x, y));
    }

    private static int minimizeCost(int[] p, int[] x, int[] y) {
        int minimumCostX = Integer.MAX_VALUE;
        int minimumCostY = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            int sumOfX = 0;
            int sumOfY = 0;
            for (int j = 0; j < x.length; j++) {
                sumOfX += Math.abs(x[i] - x[j]) * p[j];
                sumOfY += Math.abs(y[i] - y[j]) * p[j];
            }
            if (sumOfX < minimumCostX) {
                minimumCostX = sumOfX;
            }
            if (sumOfY < minimumCostY) {
                minimumCostY = sumOfY;
            }
        }
        return minimumCostX + minimumCostY;
    }
}
