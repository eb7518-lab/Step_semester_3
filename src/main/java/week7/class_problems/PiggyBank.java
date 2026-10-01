package week7.class_problems;

public class PiggyBank {
    private String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println(pb.getSavings());

        pb.withdraw(30);
        System.out.println(pb.getSavings());

        pb.withdraw(500);
        System.out.println(pb.getSavings());
    }
}