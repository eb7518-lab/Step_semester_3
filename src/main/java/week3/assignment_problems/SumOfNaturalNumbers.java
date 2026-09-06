package week3.assignment_problems;

import java.util.Scanner;

public class SumOfNaturalNumbers {

    static int calculateSum(int n) {

        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum = sum + i;
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        int result = calculateSum(n);

        System.out.println("Sum = " + result);

        sc.close();
    }
}
