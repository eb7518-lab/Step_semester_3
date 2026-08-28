package week2.assignment_problems;

import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    static void validateISBN(String isbn) {

        isbn = isbn.trim();

        if (isbn.length() != 13) {
            System.out.println("Invalid ISBN.");
            return;
        }

        for (int i = 0; i < isbn.length(); i++) {
            char ch = isbn.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                System.out.println("Invalid ISBN.");
                return;
            }
        }

        String normalizedISBN = isbn.toUpperCase();

        StringBuilder formatted = new StringBuilder();

        formatted.append(normalizedISBN.substring(0, 3));
        formatted.append("-");
        formatted.append(normalizedISBN.substring(3, 6));
        formatted.append("-");
        formatted.append(normalizedISBN.substring(6, 9));
        formatted.append("-");
        formatted.append(normalizedISBN.substring(9, 13));

        System.out.println("Valid ISBN.");
        System.out.println("Normalized ISBN: " + normalizedISBN);
        System.out.println("Formatted ISBN: " + formatted);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        validateISBN(isbn);

        sc.close();
    }
}