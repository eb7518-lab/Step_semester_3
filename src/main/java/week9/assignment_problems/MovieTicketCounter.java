package week9.assignment_problems;

import java.util.Scanner;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20.0;
    protected double price;

    Ticket(double price) {
        this.price = price;
    }

    abstract String getSeatType();

    double calculateAmount(int count) {
        return (price + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    RegularTicket() {
        super(150);
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket() {
        super(250);
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket() {
        super(400);
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            Ticket ticket = null;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket();
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket();
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket();
                    break;
            }

            if (ticket != null) {
                double amount = ticket.calculateAmount(count);
                System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
                total += amount;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}