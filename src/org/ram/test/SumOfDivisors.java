package org.ram.test;

public class SumOfDivisors {

    public static void main(String[] args) {
        int number = 4;
        int sum  = sum(number);
        System.out.println(sum);
    }

    private static int sum(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
