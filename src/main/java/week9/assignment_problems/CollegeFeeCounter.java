package week9.assignment_problems;

import java.util.Scanner;

abstract class Student {
    protected String name;
    static final double BUS_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        return calculateFee() + (usesBus() ? BUS_FEE : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    continue;
            }

            double fee = student.getTotalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}