package week9.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new BookItem(title, daysLate);
            } else if (type.equals("DVD")) {
                item = new DVDItem(title, daysLate);
            } else {
                item = new MagazineItem(title, daysLate);
            }

            double fine = item.calculateFine();
            total += fine;

            System.out.printf("%s: %.2f%n", title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", total);

        sc.close();
    }
}