package week8.assignment_problems;

import java.util.Scanner;

interface Customer {
    double calculateAmount(double amount);
    String getType();
}

class StudentCustomer implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer implements Customer {
    public double calculateAmount(double amount) {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new StudentCustomer();
            } else if (type.equals("STAFF")) {
                customer = new StaffCustomer();
            } else {
                customer = new GuestCustomer();
            }

            double finalAmount = customer.calculateAmount(amount);
            total += finalAmount;

            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}