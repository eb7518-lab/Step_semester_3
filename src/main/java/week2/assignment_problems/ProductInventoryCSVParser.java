package week2.assignment_problems;

import java.util.Scanner;

public class ProductInventoryCSVParser {

    static void parseProduct(String line) {

        String[] parts = line.split(",");

        if (parts.length != 3) {
            System.out.println("Invalid product record.");
            return;
        }

        String name = parts[0].trim();
        String price = parts[1].trim();
        String quantity = parts[2].trim();

        if (name.isEmpty() || price.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid product record.");
            return;
        }

        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product record: ");
        String line = sc.nextLine();

        parseProduct(line);

        sc.close();
    }
}