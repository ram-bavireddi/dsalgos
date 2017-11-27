package org.ram.test;

public class ConsecutiveNumbers {

    public static void main(String[] args) {
        int number = 15;
        int ways = countConsecutive(number);
        System.out.println(ways);
    }

    /*
        The idea is to represent number as a sequence of 'length+1' as:
        number = start + (start+1) + (start+2) + .. + (start+length)
        => number = (length+1)*start + (length*(length+1))/2
        => start = (number- length*(length+1)/2)/(length+1)
        We substitute the values of 'length' starting from 1 till length*(length+1)/2 < number
        If we get 'start' as a natural number then the solution should be counted.
     */
    private static int countConsecutive(int number) {
        int ways = 0;
        for (int length = 1; length * (length + 1) < 2 * number; length++) {
            float start = (float) (
                    1.0 * (number - (length * (length + 1)) / 2) / (length + 1)
            );
            if (start - (int) start == 0) {
                ++ways;
            }
        }
        return ways;
    }
}
