package week3.assignment_problems;

import java.util.Scanner;

public class PrintNumbers1ToN {

    static void printNumbers(int n) {

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        printNumbers(n);

        sc.close();
    }
}