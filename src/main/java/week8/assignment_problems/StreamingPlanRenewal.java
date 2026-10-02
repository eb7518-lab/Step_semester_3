package week8.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface Plan {
    LocalDate getRenewalDate(LocalDate startDate);
}

class BasicPlan implements Plan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements Plan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements Plan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan();
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan();
            } else {
                plan = new PremiumPlan();
            }

            LocalDate renewalDate = plan.getRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
