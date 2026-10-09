package week9.class_problems;

import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Staff staff;

            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staff = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else {
                double stipend = sc.nextDouble();
                staff = new Intern(name, stipend);
            }

            double pay = staff.calculatePay();
            total += pay;

            System.out.printf("%s: %.2f%n", staff.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", total);

        sc.close();
    }
}