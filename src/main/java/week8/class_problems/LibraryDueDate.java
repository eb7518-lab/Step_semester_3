package week8.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;

    public DVD(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private String title;

    public Magazine(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            int firstSpace = input.indexOf(" ");
            String type = input.substring(0, firstSpace);
            String title = input.substring(firstSpace + 1).replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(item.getTitle() + ": " + item.getDueDate().format(format));
        }

        sc.close();
    }
}