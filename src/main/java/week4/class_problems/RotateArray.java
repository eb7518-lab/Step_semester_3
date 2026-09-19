package week4.class_problems;

import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of rotations: ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}