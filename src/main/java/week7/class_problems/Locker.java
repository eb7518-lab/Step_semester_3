package week7.class_problems;

public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public void changeCode(String oldCode, String newCode) {
        if (combination.equals(oldCode)) {
            combination = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Wrong current code");
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("1234", "9999");
    }
}